# Book Club API

## Overview
This REST API is designed to manage a book club platform, allowing users to create reading clubs, add books, manage votes, and share reviews. Built with Spring Boot, it follows REST architecture principles and best practices.

## Key Features
- Book Club Creation and Management
- Book Catalog Management
- Voting System
- Review System
- Email Notifications
- JWT Authentication
- Top Book Tracking

## Project Structure
```
src/main/java/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/            # Data Transfer Objects
├── exception/      # Custom exceptions and handlers
├── model/          # Entity classes
├── repository/     # Data access layer
├── request/        # Request models
├── response/       # Response models
└── service/        # Business logic layer
```

## API Endpoints

### 1. Club Management
```
POST /api/clubs/create
```
- Creates a new reading club
- Required fields: name, reading time, participants, first book
- Automatically sends welcome emails to all participants

### 2. Book Management
```
POST /api/books/add
```
- Adds a new book to the club
- Requires authentication (Bearer token)
- Required fields: book name, description

### 3. Voting System
```
POST /api/vote/add
```
- Allows members to vote for books
- Requires authentication (Bearer token)
- Required field: bookId

### 4. Review System
```
POST /api/reviews/new
```
- Adds a new book review
- Requires authentication (Bearer token)
- Required field: review content

### 5. Top Book Feature
```
GET /api/topBook/{clubId}
```
- Retrieves and updates the most voted book in a specific club
- Required parameter: clubId

## Technical Stack
- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Java Version**: 17
- **Security**: JWT Authentication
- **Email Service**: Spring Email
- **Architecture**: REST API
- **Design Pattern**: MVC

## Security Implementation
- JWT-based authentication
- Token validation for protected endpoints
- Bearer token format: `Authorization: Bearer <token>`
- Request validation using `@Valid` annotation

## API Response Format
All endpoints return standardized responses:
- Appropriate HTTP status code
- Response message
- Relevant data payload when applicable

## Error Handling
- 400 Bad Request: Invalid requests or missing token
- 200 OK: Successful operations
- Standardized error responses

## Setup Requirements
1. Java 17
2. Gradle
3. Database configuration
4. Email (SMTP) settings
5. JWT secret key
6. Spring Boot properties

## Installation & Running
```bash
# Clone the repository
git clone [repository-url]

# Navigate to project directory
cd book-club-api

# Build the project
gradle clean build

# Run the application
gradle bootRun
```

## Environment Variables
```
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
JWT_SECRET=your_jwt_secret
SMTP_HOST=your_smtp_host
SMTP_PORT=your_smtp_port
```

## Build Configuration
```groovy
plugins {
    id 'org.springframework.boot' version '3.x.x'
    id 'io.spring.dependency-management'
    id 'java'
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-mail'
    implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
    runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
    runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'
    // Add other dependencies as needed
}
```

## Future Enhancements
- Integration with external book APIs
- Reading progress tracking
- Book recommendations system
- Real-time notifications
- Meeting scheduler integration

## Contributing
Feel free to submit issues and enhancement requests.

## License
[Your chosen license]