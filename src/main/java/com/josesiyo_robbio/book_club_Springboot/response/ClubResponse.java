package com.josesiyo_robbio.book_club_Springboot.response;

import com.josesiyo_robbio.book_club_Springboot.dto.ClubBookDto;
import com.josesiyo_robbio.book_club_Springboot.dto.ParticipantDto;

import java.util.List;

public class ClubResponse
{
    private Long id;
    private String name;
    private int readTime;
    private List<ParticipantDto> participants;
    private ClubBookDto currentBook;
    private String message;

    // Constructor
    public ClubResponse(String name, int readTime, List<ParticipantDto> participants, ClubBookDto currentBook) {

        this.name = name;
        this.readTime = readTime;
        this.participants = participants;
        this.currentBook = currentBook;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getReadTime() { return readTime; }
    public void setReadTime(int readTime) { this.readTime = readTime; }

    public List<ParticipantDto> getParticipants() { return participants; }
    public void setParticipants(List<ParticipantDto> participants) { this.participants = participants; }

    public ClubBookDto getCurrentBook() { return currentBook; }
    public void setCurrentBook(ClubBookDto currentBook) { this.currentBook = currentBook; }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
