package com.josesiyo_robbio.book_club_Springboot.request;



public class NewReviewRequest
{
    private Long clubId;
    private String email;
    private String content ;

    public Long getClubId() {return clubId;}
    public String getSub() {return email;}
    public String getContent() {return content;}

    public void setClubId(Long clubId) {this.clubId = clubId;}
    public void setSub(String sub) {this.email = sub;}
    public void setContent(String content) {this.content = content;}


}
