package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.request.ClubRequest;
import com.josesiyo_robbio.book_club_Springboot.response.ClubResponse;
import com.josesiyo_robbio.book_club_Springboot.service.CreateClubService;
import com.josesiyo_robbio.book_club_Springboot.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
public class CreateClubController {

    @Autowired
    private CreateClubService createClubService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<ClubResponse> createClub(@RequestBody @Valid ClubRequest clubRequest)
    {

        //convert request to dto
        ClubBookDto clubBookDto = new ClubBookDto();
        clubBookDto.setName(clubRequest.getName());
        clubBookDto.setReadTime(clubRequest.getReadTime());
        clubBookDto.getParticipants().addAll(clubRequest.getParticipants());
        clubBookDto.setFirstBook(clubRequest.getFirstBook());


        //call the service for results
        ClubBookDto createdClub = createClubService.createClub(clubBookDto);


        // Send email with the club information and participants (after persisting the club)
        emailService.sendTokensEmail(createdClub, clubBookDto.getParticipants());


        //create response
        ClubResponse response = new ClubResponse(
                createdClub.getId(),
                createdClub.getName(),
                createdClub.getReadTime(),
                createdClub.getParticipants(),
                createdClub.getFirstBook()

        );

        return ResponseEntity.ok(response);
    }
}
