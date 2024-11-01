package com.josesiyo_robbio.book_club_Springboot.controller;


import com.josesiyo_robbio.book_club_Springboot.request.AddVoteRequest;
import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import com.josesiyo_robbio.book_club_Springboot.response.AddVoteResponse;
import com.josesiyo_robbio.book_club_Springboot.service.AddVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
public class AddVoteController
{
    @Autowired
    private AddVoteService addVoteService;

    @PostMapping("/add")
    public ResponseEntity<?> newReview(@RequestHeader("Authorization") String authHeader, @RequestBody AddVoteRequest addVoteRequest)
    {
        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.status(401).body("Token missing or invalid");
        }

        String token = authHeader.substring(7);

        try
        {
            Long id = addVoteService.addVote(token, addVoteRequest);
            return ResponseEntity.ok(new AddVoteResponse(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body("Failed to create review: " + e.getMessage());
        }
    }
}
