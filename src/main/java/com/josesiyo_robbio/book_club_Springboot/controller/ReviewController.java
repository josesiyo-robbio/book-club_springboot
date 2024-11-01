package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import com.josesiyo_robbio.book_club_Springboot.response.ReviewResponse;
import com.josesiyo_robbio.book_club_Springboot.service.NewReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private NewReviewService newReviewService;

    @PostMapping("/new")
    public ResponseEntity<?> newReview(@RequestHeader("Authorization") String authHeader, @RequestBody NewReviewRequest newReviewRequest) {

        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.status(401).body("Token missing or invalid");
        }

        String token = authHeader.substring(7);

        try
        {
            Long id = newReviewService.newReview(token, newReviewRequest);
            ReviewResponse reviewResponse = new ReviewResponse(id, newReviewRequest.getContent().getContent());
            reviewResponse.setMessage("Review successfully created");
            return ResponseEntity.ok(reviewResponse);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body("Failed to create review: " + e.getMessage());
        }
    }
}
