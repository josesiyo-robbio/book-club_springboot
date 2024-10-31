package com.josesiyo_robbio.book_club_Springboot.repository;

import com.josesiyo_robbio.book_club_Springboot.model.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubMemberRepository extends JpaRepository<ClubMember, Long>
{

}
