package com.josesiyo_robbio.book_club_Springboot.response;



public class AddBookResponse
{
    private Long id;
    private String message;


    // Constructor
    public AddBookResponse(Long id)
    {
        this.id = id;
    }


    //SETTERS
    public String getMessage()  { return message;   }
    public Long getId()         { return id;        }


    //GETTERS
    public void setMessage(String message)  { this.message = message;   }
    public void setId(Long id)              { this.id = id;             }

}
