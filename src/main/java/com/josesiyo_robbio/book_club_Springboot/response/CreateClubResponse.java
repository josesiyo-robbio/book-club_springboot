package com.josesiyo_robbio.book_club_Springboot.response;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;
import java.util.List;



public class CreateClubResponse
{
    private Long id;
    private String name;
    private int readTime;
    private List<ParticipantDto> participants;
    private ClubBookDto currentBook;


    // Constructor
    public CreateClubResponse(Long id, String name, int readTime, List<ParticipantDto> participants, ClubBookDto currentBook)
    {
        this.name           =   name;
        this.readTime       =   readTime;
        this.participants   =   participants;
        this.currentBook    =   currentBook;
        this.id             =   id;
    }


    //SETTERS
    public void setId(Long id) { this.id = id; }


    // GETTERS
    public Long getId()                             { return id;            }
    public String getName()                         { return name;          }
    public int getReadTime()                        { return readTime;      }
    public List<ParticipantDto> getParticipants()   { return participants;  }
    public ClubBookDto getCurrentBook()             { return currentBook;   }

}
