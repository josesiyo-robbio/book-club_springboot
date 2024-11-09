package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public class ClubMemberDto
{
    @NotNull()
    @Positive()
    private Long id;

    @NotBlank()
    private String name;

    @NotBlank()
    private String email;

    @NotNull()
    @Positive()
    private Long clubId;

    @NotBlank()
    private String status;


    //GETTERS
    public Long getId()         { return id;        }
    public String getStatus()   { return status;    }
    public String getEmail()    { return email;     }
    public String getName()     { return name;      }
    public Long getClubId()     { return clubId;    }


    //SETTERS
    public void setId(Long id)              { this.id = id;         }
    public void setName(String name)        { this.name = name;     }
    public void setEmail(String email)      { this.email = email;   }
    public void setClubId(Long clubId)      { this.clubId = clubId; }
    public void setStatus(String status)    { this.status = status; }

}
