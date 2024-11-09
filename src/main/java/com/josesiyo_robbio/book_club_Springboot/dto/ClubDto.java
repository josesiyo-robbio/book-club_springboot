package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



public class ClubDto
{
    @Positive()
    @NotNull()
    private Long id;

    @NotBlank()
    private String name;

    @NotNull()
    @Positive()
    private int readTime;

    @NotNull()
    @Positive()
    private int numberParticipants;

    @NotNull()
    @Positive()
    private int reviews;


    //GETTERS
    public Long getId()                 { return id;                    }
    public String getName()             { return name;                  }
    public int getReadTime()            { return readTime;              }
    public int getNumberParticipants()  { return numberParticipants;    }
    public int getReviews()             { return reviews;               }


    //SETTERS
    public void setId(Long id)                                  { this.id = id;                                     }
    public void setName(String name)                            { this.name = name;                                 }
    public void setReadTime(int readTime)                       { this.readTime = readTime;                         }
    public void setNumberParticipants(int numberParticipants)   { this.numberParticipants = numberParticipants;     }
    public void setReviews(int reviews)                         { this.reviews = reviews;                           }

}
