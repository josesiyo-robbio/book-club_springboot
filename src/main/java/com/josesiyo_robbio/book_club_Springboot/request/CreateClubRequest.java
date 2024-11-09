package com.josesiyo_robbio.book_club_Springboot.request;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;



public class CreateClubRequest
{
    @NotBlank()
    private String name;

    @NotNull()
    @Positive()
    private int readTime;

    private List<ParticipantDto> participants;

    @NotNull()
    private ClubBookDto firstBook;


    //GETTERS
    public String getName()                         { return name;          }
    public int getReadTime()                        { return readTime;      }
    public List<ParticipantDto> getParticipants()   { return participants;  }
    public ClubBookDto getFirstBook()               { return firstBook;     }


    //SETTERS
    public void setName(String name)                                    { this.name = name;                     }
    public void setReadTime(int readTime)                               { this.readTime = readTime;             }
    public void setParticipants(List<ParticipantDto> participants)      { this.participants = participants;     }
    public void setFirstBook(ClubBookDto clubBook)                      { this.firstBook = clubBook;            }

}
