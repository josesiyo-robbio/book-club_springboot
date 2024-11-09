package com.josesiyo_robbio.book_club_Springboot.controller;


import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.request.AddBookRequest;
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
    public ResponseEntity<AddBookResponse> addBook(@RequestHeader("Authorization") String authHeader, @RequestBody AddBookRequest addBookRequest)
    {
        if (authHeader == null || !authHeader.startsWith("Bearer "))
        {
            return ResponseEntity.badRequest().build();
        }

        String token = authHeader.substring(7);

        //convert request to dto
        ClubBookDto clubBookDto = new ClubBookDto();
        clubBookDto.setName(addBookRequest.getBookName());
        clubBookDto.setDescription(addBookRequest.getDescription());


        //call the service for results
        ClubBookDto addBook = addBookService.addBook(token, clubBookDto);


        //create response
        AddBookResponse response = new AddBookResponse( addBook.getId() );
        response.setMessage("Successfully added book");

        return ResponseEntity.ok(response);




    }



}
