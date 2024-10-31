package com.josesiyo_robbio.book_club_Springboot.repository;

import com.josesiyo_robbio.book_club_Springboot.model.ClubBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubBookRepository extends JpaRepository<ClubBook, Long>
{

}
