package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.model.Club;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBook;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookVoteRepository;
import com.josesiyo_robbio.book_club_Springboot.request.AddBookRequest;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookService
{
    private static final Logger logger = LoggerFactory.getLogger(NewReviewService.class);
    @Autowired
    private ClubBookRepository clubBookRepository;

    @Autowired
    private ClubBookVoteRepository voteRepository;

    @Autowired
    private JwtService jwtService;


    @Transactional
    public Long addBook(String token, AddBookRequest request)
    {
        try
        {
            Claims claims = jwtService.extractAllClaims(token);

            String clubIdStr = claims.get("clubId", String.class);
            String sub = claims.get("email", String.class);

            if (clubIdStr == null || sub == null) {
                throw new RuntimeException("Missing required claims in token");
            }

            Long clubId = Long.parseLong(clubIdStr);

            Club club = new Club();

            ClubBookDto clubBookDto = request.getFirstBook();
            ClubBook clubBook = new ClubBook();
            clubBook.setName(clubBookDto.getName());
            clubBook.setDescription(clubBookDto.getDescription());
            clubBook.setClubId(clubId);
            clubBook.setCurrent(false);
            clubBookRepository.save(clubBook);

            ClubBookVote clubBookVote = new ClubBookVote();
            clubBookVote.setBookId(clubBook.getId());
            clubBookVote.setClubId(clubId);

            voteRepository.save(clubBookVote);


            return clubId;


        }
        catch (Exception e)
        {
            throw new RuntimeException("Error creating club", e);
        }

    }
}
