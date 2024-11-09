package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;
import com.josesiyo_robbio.book_club_Springboot.model.Club;
import com.josesiyo_robbio.book_club_Springboot.model.ClubBook;
import com.josesiyo_robbio.book_club_Springboot.model.ClubMember;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubMemberRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubRepository;
import com.josesiyo_robbio.book_club_Springboot.request.ClubRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CreateClubService
{


    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ClubMemberRepository clubMemberRepository;

    @Autowired
    private ClubBookRepository clubBookRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public ClubBookDto createClub(ClubBookDto clubBookDto)
    {
        try
        {
            //trans #1 create a new club in table club
            Club club = new Club();
            club.setName(clubBookDto.getName());
            club.setReadTime(clubBookDto.getReadTime());
            club.setNumberParticipants(clubBookDto.getParticipants().size());
            clubRepository.save(club);


            //trans #2 insert members to table club_member
            List<ParticipantDto> participants = clubBookDto.getParticipants();
            if (participants != null)
            {
                for (ParticipantDto participantDto : participants)
                {
                    ClubMember participant = new ClubMember();
                    participant.setName(participantDto.getName());
                    participant.setEmail(participantDto.getEmail());
                    participant.setClubId(club.getId());
                    clubMemberRepository.save(participant);
                }
            }

            //trans #3 insert first book into table club_book
            ClubBook clubBook = new ClubBook();
            clubBook.setName(clubBookDto.getFirstBook().getName());
            clubBook.setDescription(clubBookDto.getFirstBook().getDescription());
            clubBook.setClubId(club.getId());
            clubBook.setCurrent(true);
            clubBookRepository.save(clubBook);

            // Return the clubBookDto with the clubId now assigned
            clubBookDto.setId(club.getId());

            return clubBookDto;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error creating club", e);
        }

    }

    public void sendTokensEmail(ClubBookDto club, List<ParticipantDto> participants)
    {
        emailService.sendTokensEmail(club, participants);
    }





}
