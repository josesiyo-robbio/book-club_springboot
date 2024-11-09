package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.dto.ReviewDto;
import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import com.josesiyo_robbio.book_club_Springboot.response.ReviewResponse;
import com.josesiyo_robbio.book_club_Springboot.service.NewReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/reviews")
public class ReviewController
{
    @Autowired
    private NewReviewService newReviewService;


    @PostMapping("/new")
    public ResponseEntity<ReviewResponse> newReview(@RequestHeader("Authorization") String authHeader, @RequestBody NewReviewRequest newReviewRequest) {

        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.badRequest().build();
        }
        String token = authHeader.substring(7);


        //convert request to dto
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setContent(newReviewRequest.getContent());


        //call the service for results
        ReviewDto addReview =  newReviewService.newReview(token, reviewDto);
        addReview.setContent(newReviewRequest.getContent());


        //create response
        ReviewResponse response = new ReviewResponse();
        response.setMessage("New review added");

        return ResponseEntity.ok(response);
    }

}
