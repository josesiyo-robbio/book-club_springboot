package com.josesiyo_robbio.book_club_Springboot.response;

public class ReviewResponse
{
    private Long id;
    private String content;
    private String message;

    public ReviewResponse(Long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
