package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

public class ClubBookDto
{
    private Long id;


    @NotNull()
    @Positive()
    private int readTime;

    @NotBlank()
    private String name;

    @NotBlank()
    private String description;

    @NotBlank()
    private boolean isCurrent;

    private List<ParticipantDto> participants = new ArrayList<>();

    @NotNull()
    private ClubBookDto firstBook;

    // Constructor
    public ClubBookDto()
    {
        this.isCurrent = true;
    }



    //GETTERS
    public boolean isCurrent()      { return isCurrent;     }
    public String getDescription()  { return description;   }
    public String getName()         { return name;          }
    public int getReadTime()                        { return readTime;      }
    public List<ParticipantDto> getParticipants()   { return participants;  }
    public ClubBookDto getFirstBook()               { return firstBook;     }



    //SETTERS

    public void setName(String name)                        { this.name = name;                 }
    public void setDescription(String description)          { this.description = description;   }
    public void setCurrent(boolean current)                 { isCurrent = current;              }
    public void setReadTime(int readTime)                               { this.readTime = readTime;             }
    public void setParticipants(List<ParticipantDto> participants)      { this.participants = participants;     }
    public void setFirstBook(ClubBookDto clubBook)                      { this.firstBook = clubBook;            }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }
}
