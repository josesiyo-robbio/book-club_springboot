package com.josesiyo_robbio.book_club_Springboot.request;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import jakarta.validation.constraints.NotNull;

public class AddBookRequest
{

    @NotNull()
    private ClubBookDto firstBook;

    public ClubBookDto getFirstBook()               { return firstBook;     }
    public void setFirstBook(ClubBookDto clubBook)                      { this.firstBook = clubBook; }

}
