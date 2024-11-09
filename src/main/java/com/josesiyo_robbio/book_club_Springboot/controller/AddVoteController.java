package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookVoteDto;
import com.josesiyo_robbio.book_club_Springboot.request.AddVoteRequest;
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
    public ResponseEntity<AddVoteResponse> newReview(@RequestHeader("Authorization") String authHeader, @RequestBody AddVoteRequest addVoteRequest)
    {
        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.badRequest().build();
        }
        String token = authHeader.substring(7);


        //convert request to dto
        ClubBookVoteDto clubBookVoteDto = new ClubBookVoteDto();
        clubBookVoteDto.setBookId(addVoteRequest.getBookId());


        //call the service for results
        ClubBookVoteDto addVote = addVoteService.addVote(token, clubBookVoteDto);


        //create response
        AddVoteResponse response = new AddVoteResponse(addVote.getId());
        response.setMessage("Successfully added vote");

        return ResponseEntity.ok(response);
    }

}
