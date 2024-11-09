package com.josesiyo_robbio.book_club_Springboot.repository;

import com.josesiyo_robbio.book_club_Springboot.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReviewRepository extends JpaRepository<Review, Long>
{

}
