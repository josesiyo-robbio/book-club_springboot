package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.model.ClubBook;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopBookService {
    @Autowired
    private ClubBookVoteRepository clubBookVoteRepository;
    @Autowired
    private ClubBookRepository clubBookRepository;

    @Transactional
    public Long getAndUpdateTopBook(Long clubId) {
        // Primera Transacción: Desmarcar el libro actual
        List<ClubBook> clubBooks = clubBookRepository.findByClubId(clubId);
        for (ClubBook book : clubBooks) {
            if (book.getCurrent()) {
                book.setCurrent(false);
                clubBookRepository.save(book);
            }
        }

        // Segunda Transacción: Encontrar el libro con más votos y marcarlo como actual
        Optional<ClubBookVote> topBookVote = clubBookVoteRepository.findTopBookByClubId(clubId);

        if (topBookVote.isPresent()) {
            Long topBookId = topBookVote.get().getBookId();
            ClubBook topBook = clubBookRepository.findById(topBookId).orElseThrow(() -> new RuntimeException("Book not found"));
            topBook.setCurrent(true);
            clubBookRepository.save(topBook);
            return topBookId;
        }

        throw new RuntimeException("No books found for this club");
    }
}
