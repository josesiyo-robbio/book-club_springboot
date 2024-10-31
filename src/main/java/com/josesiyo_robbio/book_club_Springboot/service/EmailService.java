package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;
import com.josesiyo_robbio.book_club_Springboot.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JwtService jwtService;

    public void sendTokensEmail(Club club, List<ParticipantDto> participants) {
        for (ParticipantDto participant : participants) {
            String token = generateToken(club.getId(), participant.getEmail());
            sendEmail(participant.getEmail(), token);
        }
    }

    private String generateToken(Long clubId, String email) {
        Map<String, String> claims = new HashMap<>();
        claims.put("clubId", clubId.toString());
        claims.put("email", email);
        return jwtService.generateToken(claims);
    }

    private void sendEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Club Token");
        message.setText("Here is your JWT token: " + token);
        mailSender.send(message);
    }
}
