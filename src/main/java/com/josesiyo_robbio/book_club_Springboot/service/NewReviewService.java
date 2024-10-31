package com.josesiyo_robbio.book_club_Springboot.service;

import com.josesiyo_robbio.book_club_Springboot.model.Club;
import com.josesiyo_robbio.book_club_Springboot.model.ClubMember;
import com.josesiyo_robbio.book_club_Springboot.model.Review;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubMemberRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ClubRepository;
import com.josesiyo_robbio.book_club_Springboot.repository.ReviewRepository;
import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class NewReviewService {
    private static final Logger logger = LoggerFactory.getLogger(NewReviewService.class);

    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public Long newReview(String token, NewReviewRequest request)
    {
        try
        {
            Claims claims = jwtService.extractAllClaims(token);

            String clubIdStr = claims.get("clubId", String.class);
            String sub = claims.get("email", String.class);

            if (clubIdStr == null || sub == null) {
                throw new RuntimeException("Missing required claims in token");
            }

            Long clubId = Long.parseLong(clubIdStr);

            logger.info("Extracted clubId: {}", clubId);
            logger.info("Extracted sub: {}", sub);

            // TRANSACTION #1
            Review review = new Review();
            review.setClubId(clubId);
            review.setContent(request.getContent().getContent());
            ClubMember memberId = clubMemberRepository.findByEmail(sub); // member_id
            if (memberId == null) {
                throw new RuntimeException("Club member not found for email: " + sub);
            }
            review.setMemberId(memberId.getId());
            reviewRepository.save(review);
            logger.info("Review saved with id: {}", review.getId());

            // TRANSACTION #2
            Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Club not found"));
            club.setReviews(club.getReviews() + 1);
            clubRepository.save(club);
            logger.info("Club updated with new review count: {}", club.getReviews());

            return club.getId();
        }
        catch (Exception e)
        {
            logger.error("Error creating review", e);
            throw new RuntimeException("Error creating review", e);
        }
    }
}
