package com.josesiyo_robbio.book_club_Springboot.repository;

import com.josesiyo_robbio.book_club_Springboot.model.ClubBookVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;



public interface ClubBookVoteRepository extends JpaRepository<ClubBookVote, Long>
{
    Optional<ClubBookVote> findByClubIdAndBookId(Long clubId, Long bookId);

    @Query("SELECT clubBookVote FROM ClubBookVote clubBookVote WHERE clubBookVote.clubId = :clubId ORDER BY clubBookVote.voteCount DESC")
    Optional<ClubBookVote> findTopBookByClubId(@Param("clubId") Long clubId);
}