package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBook;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookVoteRepository;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddBookService
{
    @Autowired
    private ClubBookRepository clubBookRepository;

    @Autowired
    private ClubBookVoteRepository voteRepository;

    @Autowired
    private JwtService jwtService;


    @Transactional
    public ClubBookDto addBook(String token, ClubBookDto clubBookDto)
    {
        try
        {
            //extract data from token
            Claims claims = jwtService.extractAllClaims(token);
            String clubIdStr = claims.get("clubId", String.class);
            String sub = claims.get("email", String.class);
            if (clubIdStr == null || sub == null)
            {
                throw new RuntimeException("Missing required claims in token");
            }
            Long clubId = Long.parseLong(clubIdStr);


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

            clubBookDto.setId(clubBook.getId());
            return clubBookDto;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error creating club", e);
        }
    }

}
