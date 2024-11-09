package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookVoteDto;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookVoteRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;



@Service
public class AddVoteService
{
    @Autowired
    private ClubBookVoteRepository clubBookVoteRepository;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public ClubBookVoteDto addVote(String token, ClubBookVoteDto clubBookVoteDto)
    {
        try
        {
            //token operations
            Claims claims = jwtService.extractAllClaims(token);
            String clubIdStr = claims.get("clubId", String.class);
            String sub = claims.get("email", String.class);
            if (clubIdStr == null || sub == null)
            {
                throw new RuntimeException("Missing required claims in token");
            }
            Long clubId = Long.parseLong(clubIdStr);


            Optional<ClubBookVote> existingVote = clubBookVoteRepository.findByClubIdAndBookId(clubId, clubBookVoteDto.getBookId());
            ClubBookVote clubBookVote;
            if (existingVote.isEmpty()) {
                clubBookVote = new ClubBookVote();
                clubBookVote.setClubId(clubId);
                clubBookVote.setBookId(clubBookVoteDto.getBookId());
                System.out.println("Saving ClubBookVote: clubId=" + clubBookVote.getClubId() +
                        ", bookId=" + clubBookVote.getBookId() +
                        ", voteCount=" + clubBookVote.getVoteCount());

                clubBookVote.setVoteCount(1);
            }
            else
            {
                clubBookVote = existingVote.get();
                System.out.println("Saving ClubBookVote: clubId=" + clubBookVote.getClubId() +
                        ", bookId=" + clubBookVote.getBookId() +
                        ", voteCount=" + clubBookVote.getVoteCount());

                clubBookVote.setVoteCount(clubBookVote.getVoteCount() + 1);
            }
            clubBookVoteRepository.save(clubBookVote);
            clubBookVoteDto.setId(clubBookVote.getId());


            return clubBookVoteDto;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error adding vote", e);
        }
    }

}
