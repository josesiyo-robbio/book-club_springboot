package com.josesiyo_robbio.book_club_Springboot.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Enabled
@Table(name = "club_book")
public class ClubBook
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_id")
    private int clubId;

    private String name;
    private String description;

    @Column(name = "is_current")
    private boolean isCurrent;



    //GETTERS
    public Long getId()             { return id;            }
    public boolean getCurrent()     { return isCurrent;     }
    public String getDescription()  { return description;   }
    public String getName()         { return name;          }
    public int getClubId()          { return clubId;        }


    //SETTERS
    public void setId(Long id)                              { this.id = id;                     }
    public void setClubId(int clubId)                       { this.clubId = clubId;             }
    public void setName(String name)                        { this.name = name;                 }
    public void setDescription(String description)          { this.description = description;   }
    public void setCurrent(boolean current)                 { isCurrent = current;              }



}
