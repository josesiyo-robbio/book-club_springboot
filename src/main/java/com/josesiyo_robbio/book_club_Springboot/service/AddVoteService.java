package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubBookVoteRepository;
import com.josesiyo_robbio.book_club_Springboot.request.AddVoteRequest;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AddVoteService {
    @Autowired
    private ClubBookVoteRepository clubBookVoteRepository;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public Long addVote(String token, AddVoteRequest request) {
        try {
            Claims claims = jwtService.extractAllClaims(token);
            String clubIdStr = claims.get("clubId", String.class);
            String sub = claims.get("email", String.class);
            if (clubIdStr == null || sub == null) {
                throw new RuntimeException("Missing required claims in token");
            }
            Long clubId = Long.parseLong(clubIdStr);

            // Buscar la instancia existente de ClubBookVote
            Optional<ClubBookVote> existingVote = clubBookVoteRepository.findByClubIdAndBookId(clubId, request.getBookId());
            ClubBookVote clubBookVote;
            if (!existingVote.isPresent()) {
                // Si no existe, crear una nueva
                clubBookVote = new ClubBookVote();
                clubBookVote.setClubId(clubId);
                clubBookVote.setBookId(request.getBookId());
                clubBookVote.setVoteCount(1);  // Inicializa en 1 ya que es un nuevo voto
            } else {
                // Si existe, incrementa el conteo de votos
                clubBookVote = existingVote.get();
                clubBookVote.setVoteCount(clubBookVote.getVoteCount() + 1);
            }

            // Guardar la entidad actualizada
            clubBookVoteRepository.save(clubBookVote);
            return clubId;
        } catch (Exception e) {
            throw new RuntimeException("Error adding vote", e);
        }
    }
}
