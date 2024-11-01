package com.josesiyo_robbio.book_club_Springboot.response;

public class AddVoteResponse
{
    private Long id;

    public AddVoteResponse(Long id)
    {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
