CREATE TABLE club (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    read_time INT NOT NULL,
    numberParticipants INT DEFAULT 0,
    reviews INT DEFAULT 0
);

CREATE TABLE club_member (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    club_id INT REFERENCES club(id) ON DELETE CASCADE,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE club_book (
    id SERIAL PRIMARY KEY,
    club_id INT REFERENCES club(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    is_current BOOLEAN DEFAULT FALSE
);

CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    club_id INT REFERENCES club(id) ON DELETE CASCADE,
    member_id INT REFERENCES club_member(id) ON DELETE CASCADE,
    content TEXT NOT NULL
);

CREATE TABLE club_book_vote (
    id SERIAL PRIMARY KEY,
    club_id INT REFERENCES club(id) ON DELETE CASCADE,
    book_id INT REFERENCES club_book(id) ON DELETE CASCADE,
    vote_count INT DEFAULT 0
);
