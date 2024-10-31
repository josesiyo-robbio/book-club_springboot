package com.josesiyo_robbio.book_club_Springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "club_member")
public class ClubMember
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "club_id")
    private Long clubId;

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
