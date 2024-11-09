package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class ParticipantDto
{
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;


    //GETTERS
    public String getEmail()    { return email; }
    public String getName()     { return name;  }


    //SETTERS
    public void setName(String name)    { this.name = name;     }
    public void setEmail(String email)  { this.email = email;   }

}
