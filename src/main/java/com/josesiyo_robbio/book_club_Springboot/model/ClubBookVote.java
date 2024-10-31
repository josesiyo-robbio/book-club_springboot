package com.josesiyo_robbio.book_club_Springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "club_book_vote")
public class ClubBookVote
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "vote_count")
    private int voteCount;


    //GETTERS
    public Long getId()         { return id;        }
    public Long getClubId()     { return clubId;    }
    public Long getBookId()     { return bookId;    }
    public int getVoteCount()   { return voteCount; }


    //SETTERS
    public void setId(Long id)                  { this.id = id;                 }
    public void setClubId(Long clubId)          { this.clubId = clubId;         }
    public void setBookId(Long bookId)          { this.bookId = bookId;         }
    public void setVoteCount(int voteCount)     { this.voteCount = voteCount;   }






}
