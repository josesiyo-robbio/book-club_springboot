package com.josesiyo_robbio.book_club_Springboot.controller;

import com.josesiyo_robbio.book_club_Springboot.service.TopBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/topBook")
public class TopBookController
{
    @Autowired
    private TopBookService topBookService;


    @GetMapping("/{clubId}")
    public ResponseEntity<?> getAndUpdateTopBook(@PathVariable Long clubId)
    {
        Long topBookId = topBookService.getAndUpdateTopBook(clubId);
        return ResponseEntity.ok("Top book ID: " + topBookId);
    }
}
