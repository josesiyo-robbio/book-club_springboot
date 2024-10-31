package com.josesiyo_robbio.book_club_Springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "member_id")
    private Long memberId;

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
