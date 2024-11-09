package com.josesiyo_robbio.book_club_Springboot.response;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;

import java.util.List;

public class AddBookResponse
{


    private Long id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




    // Constructor
    public AddBookResponse(Long id)
    {
        this.id = id;


    }



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


}
