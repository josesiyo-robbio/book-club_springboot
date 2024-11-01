package com.josesiyo_robbio.book_club_Springboot.controller;


import com.josesiyo_robbio.book_club_Springboot.request.AddBookRequest;
import com.josesiyo_robbio.book_club_Springboot.request.NewReviewRequest;
import com.josesiyo_robbio.book_club_Springboot.response.AddBookResponse;
import com.josesiyo_robbio.book_club_Springboot.service.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class AddBookController
{
    @Autowired
    private  AddBookService addBookService;

    @PostMapping("/add")
    public ResponseEntity<?> newReview(@RequestHeader("Authorization") String authHeader, @RequestBody AddBookRequest addBookRequest)
    {
        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.status(401).body("Token missing or invalid");
        }

        String token = authHeader.substring(7);


        Long clubId = addBookService.addBook(token,addBookRequest);

        AddBookResponse addBookResponse = new AddBookResponse(
                clubId,
                addBookRequest.getFirstBook()

        );
        return ResponseEntity.status(201).body(addBookResponse);
    }



}
