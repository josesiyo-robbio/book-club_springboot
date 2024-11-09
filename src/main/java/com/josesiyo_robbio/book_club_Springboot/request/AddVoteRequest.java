package com.josesiyo_robbio.book_club_Springboot.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public class AddVoteRequest
{
    @Positive()
    @NotNull()
    private Long clubId;

    @Positive()
    @NotNull()
    private Long bookId;


    //GETTERS
    public Long getClubId()     { return clubId;    }
    public Long getBookId()     { return bookId;    }


    //SETTERS }
    public void setClubId(Long clubId)          { this.clubId = clubId;         }
    public void setBookId(Long bookId)          { this.bookId = bookId;         }

}
