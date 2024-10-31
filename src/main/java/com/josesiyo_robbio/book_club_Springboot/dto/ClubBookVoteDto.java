package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ClubBookVoteDto
{

    @Positive()
    @NotNull()
    private Long id;

    @Positive()
    @NotNull()
    private Long clubId;

    @Positive()
    @NotNull()
    private Long bookId;

    @Positive()
    @NotNull()
    private int voteCount;


    //GETTERS
    public Long getId()         { return id;        }
    public Long getClubId()     { return clubId;    }
    public Long getBookId()     { return bookId;    }
    public int getVoteCount()   { return voteCount; }


    //SETTERS
    public void setId(Long id)                  { this.id = id;                 }
    public void setClubId(Long clubId)          { this.clubId = clubId;         }
    public void setBookId(Long bookId)          { this.bookId = bookId;         }
    public void setVoteCount(int voteCount)     { this.voteCount = voteCount;   }

}
