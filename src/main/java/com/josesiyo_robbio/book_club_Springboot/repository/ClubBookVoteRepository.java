package com.josesiyo_robbio.book_club_Springboot.repository;

import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubBookVoteRepository extends JpaRepository<ClubBookVote, Long>
{

    Optional<ClubBookVote> findByClubIdAndBookId(Long clubId, Long bookId);
}