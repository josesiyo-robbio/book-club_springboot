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
    public Long createClub(ClubRequest request)
    {
        System.out.println("Creating club...");
        try {
            //trans #1
            Club club = new Club();
            club.setName(request.getName());
            club.setReadTime(request.getReadTime());
            club.setNumberParticipants(request.getParticipants().size());

            clubRepository.save(club);

            //trans #2
            List<ParticipantDto> participants = request.getParticipants();
            if (participants != null) {
                for (ParticipantDto participantDto : participants) {
                    ClubMember participant = new ClubMember();
                    participant.setName(participantDto.getName());
                    participant.setEmail(participantDto.getEmail());
                    participant.setClubId(club.getId());

                    clubMemberRepository.save(participant);

                }
            }

            //trans #3
            ClubBookDto clubBookDto = request.getFirstBook();

            ClubBook clubBook = new ClubBook();
            clubBook.setName(clubBookDto.getName());
            clubBook.setDescription(clubBookDto.getDescription());
            clubBook.setClubId(club.getId());
            clubBook.setCurrent(true);

            clubBookRepository.save(clubBook);

            emailService.sendTokensEmail(club, participants);

            return club.getId();
        }
        catch (Exception e) {
            throw new RuntimeException("Error creating club", e);
        }

    }




}
