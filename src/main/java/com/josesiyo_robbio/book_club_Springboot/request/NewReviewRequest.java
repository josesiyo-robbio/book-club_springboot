package com.josesiyo_robbio.book_club_Springboot.request;

import com.josesiyo_robbio.book_club_Springboot.dto.ReviewDto;

public class NewReviewRequest
{
    private Long clubId; //viene del token
    private String sub; //viene del token
    private ReviewDto content ; //viene del request

    public Long getClubId() {return clubId;}
    public String getSub() {return sub;}
    public ReviewDto getContent() {return content;}

    public void setClubId(Long clubId) {this.clubId = clubId;}
    public void setSub(String sub) {this.sub = sub;}
    public void setContent(ReviewDto content) {this.content = content;}


}
