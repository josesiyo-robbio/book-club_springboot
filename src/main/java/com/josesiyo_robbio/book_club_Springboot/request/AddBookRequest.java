package com.josesiyo_robbio.book_club_Springboot.request;



public class AddBookRequest
{
    private String bookName;
    private String description;


    //GETTERS
    public String getDescription()      { return description;   }
    public String getBookName()         { return bookName;      }


    //SETTERS
    public void setBookName(String bookName)        { this.bookName = bookName;         }
    public void setDescription(String description)  { this.description = description;   }

}
