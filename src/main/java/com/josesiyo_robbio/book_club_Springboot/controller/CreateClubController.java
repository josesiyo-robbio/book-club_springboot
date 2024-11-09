package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.request.CreateClubRequest;
import com.josesiyo_robbio.book_club_Springboot.response.CreateClubResponse;
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
    public ResponseEntity<CreateClubResponse> createClub(@RequestBody @Valid CreateClubRequest createClubRequest)
    {

        //convert request to dto
        ClubBookDto clubBookDto = new ClubBookDto();
        clubBookDto.setName(createClubRequest.getName());
        clubBookDto.setReadTime(createClubRequest.getReadTime());
        clubBookDto.getParticipants().addAll(createClubRequest.getParticipants());
        clubBookDto.setFirstBook(createClubRequest.getFirstBook());


        //call the service for results
        ClubBookDto createdClub = createClubService.createClub(clubBookDto);


        // Send email with the club information and participants (after persisting the club)
        emailService.sendTokensEmail(createdClub, clubBookDto.getParticipants());


        //create response
        CreateClubResponse response = new CreateClubResponse(
                createdClub.getId(),
                createdClub.getName(),
                createdClub.getReadTime(),
                createdClub.getParticipants(),
                createdClub.getFirstBook()

        );

        return ResponseEntity.ok(response);
    }
}
