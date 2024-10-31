package com.josesiyo_robbio.book_club_Springboot.controller;


import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import com.josesiyo_robbio.book_club_Springboot.response.ReviewResponse;
import com.josesiyo_robbio.book_club_Springboot.service.NewReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController
{
    @Autowired
    private NewReviewService newReviewService;

    @PostMapping("/new")
    public ResponseEntity<ReviewResponse> newReview(@RequestBody NewReviewRequest newReviewRequest)
    {
        Long id = newReviewService.newReview(newReviewRequest);

        ReviewResponse reviewResponse = new ReviewResponse(id,newReviewRequest.getContent().getContent());

        reviewResponse.setMessage("Review successfully created");

        return ResponseEntity.ok(reviewResponse);
    }
}
