package com.josesiyo_robbio.book_club_Springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ClubBookDto
{

    @NotNull()
    @Positive()
    private Long id;

    @NotNull()
    @Positive()
    private int clubId;

    @NotBlank()
    private String name;

    @NotBlank()
    private String description;

    @NotBlank()
    private Boolean isCurrent;


    //GETTERS
    public Long getId()             { return id;            }
    public Boolean getCurrent()     { return isCurrent;     }
    public String getDescription()  { return description;   }
    public String getName()         { return name;          }
    public int getClubId()          { return clubId;        }


    //SETTERS
    public void setId(Long id)                              { this.id = id;                     }
    public void setClubId(int clubId)                       { this.clubId = clubId;             }
    public void setName(String name)                        { this.name = name;                 }
    public void setDescription(String description)          { this.description = description;   }
    public void setCurrent(Boolean current)                 { isCurrent = current;              }
}
