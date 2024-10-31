package com.josesiyo_robbio.book_club_Springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "club")
public class Club
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "read_time")
    private int readTime;

    @Column(name = "numberparticipants")
    private int numberParticipants;

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
