package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;
import com.josesiyo_robbio.book_club_Springboot.model.Club;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${jwt.secret}")
    private String secretKey;

    public void sendTokensEmail(Club club, List<ParticipantDto> participants) {
        for (ParticipantDto participant : participants) {
            String token = generateToken(club.getId(), participant.getEmail());
            sendEmail(participant.getEmail(), token);
        }
    }

    private String generateToken(Long clubId, String email) {
        return Jwts.builder()
                .setSubject(email)
                .claim("clubId", clubId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 1 día
                .signWith(SignatureAlgorithm.HS256, secretKey) // Usando el secretKey inyectado
                .compact();
    }

    private void sendEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your Club Token");
        message.setText("Here is your JWT token: " + token);
        mailSender.send(message);
    }
}
