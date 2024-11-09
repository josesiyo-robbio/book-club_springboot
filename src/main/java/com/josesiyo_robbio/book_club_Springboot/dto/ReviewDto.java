package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public class ReviewDto
{
    @NotNull()
    @Positive()
    private Long id;

    @NotNull()
    @Positive()
    private Long clubId;

    @NotNull()
    @Positive()
    private Long memberId;

    @NotBlank()
    private String content;


    //GETTERS
    public Long getId()         { return id;        }
    public String getContent()  { return content;   }
    public Long getMemberId()   { return memberId;  }
    public Long getClubId()     { return clubId;    }


    //SETTERS
    public void setId(Long id)              { this.id = id;             }
    public void setClubId(Long clubId)      { this.clubId = clubId;     }
    public void setMemberId(Long memberId)  { this.memberId = memberId; }
    public void setContent(String content)  { this.content = content;   }

}
