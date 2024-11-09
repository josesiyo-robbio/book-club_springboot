package com.josesiyo_robbio.book_club_Springboot.response;

public class AddVoteResponse
{
    private Long id;
    private String message;


    public AddVoteResponse(Long id)
    {
        this.id = id;
    }


    //GETTERS
    public String getMessage() { return message; }
    public Long getId() { return id; }


    //SETTERS
    public void setMessage(String message) { this.message = message; }
    public void setId(Long id) { this.id = id; }

}
