package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.request.ClubRequest;
import com.josesiyo_robbio.book_club_Springboot.response.ClubResponse;
import com.josesiyo_robbio.book_club_Springboot.service.CreateClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private CreateClubService createClubService;

    @PostMapping("/create")
    public ResponseEntity<ClubResponse> createClub(@RequestBody ClubRequest clubRequest) {
        createClubService.createClub(clubRequest);

        ClubResponse clubResponse = new ClubResponse(
                clubRequest.getName(),
                clubRequest.getReadTime(),
                clubRequest.getParticipants(),
                clubRequest.getFirstBook()
        );
        clubResponse.setMessage("Club created successfully!");

        return ResponseEntity.ok(clubResponse);
    }
}
