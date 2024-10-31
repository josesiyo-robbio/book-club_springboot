package com.josesiyo_robbio.book_club_Springboot.service;


import com.josesiyo_robbio.book_club_Springboot.model.Club;
import com.josesiyo_robbio.book_club_Springboot.model.ClubMember;
import com.josesiyo_robbio.book_club_Springboot.model.Review;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubMemberRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ReviewRepository;
import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewReviewService
{
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public Long newReview(NewReviewRequest request)
    {
        try
        {

            //TRANSACTION #1
            Review review = new Review();
            review.setClubId(request.getClubId()); //club_id
            review.setContent(request.getContent().getContent()); //content
            ClubMember memberId = clubMemberRepository.findByEmail(request.getSub()); //member_id
            review.setMemberId(memberId.getId());
            reviewRepository.save(review);

            //TRANSACTION #2
            Club club = clubRepository.findById(request.getClubId()).orElseThrow(() -> new RuntimeException("Club not found"));
            club.setReviews(club.getReviews() + 1);
            clubRepository.save(club);

            return club.getId();





        }
        catch (Exception e) {
            throw new RuntimeException("Error creating vote", e);
        }
    }
}