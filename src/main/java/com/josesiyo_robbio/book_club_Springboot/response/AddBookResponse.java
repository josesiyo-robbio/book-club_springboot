package com.josesiyo_robbio.book_club_Springboot.response;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;

import java.util.List;

public class AddBookResponse
{

    private ClubBookDto currentBook;
    private Long id;

    // Constructor
    public AddBookResponse(Long id, ClubBookDto currentBook) {


        this.currentBook = currentBook;

        this.id = id;

    }


    public ClubBookDto getCurrentBook() { return currentBook; }
    public void setCurrentBook(ClubBookDto currentBook) { this.currentBook = currentBook; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


}
