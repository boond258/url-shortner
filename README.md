# URL Shortening Service

This is an application programming interface (API) that provides a URL Shortening Service similar to TinyURL.

## Functional Requirements

1. Given a URL, the service should generate a shorter and unique alias of it. This is called a short link. The link should be short enough to be easily copied and pasted into applications.
2. When users access a short link, the service should redirect them to the original link.

## Non-Functional Requirements

1. The system should be highly available. This is required because if the service is down, all the URL redirections will start failing.
2. URL redirection should happen in real-time with minimal latency.

## Technologies Used

- **Java**: The application is implemented using Java and the Spring Boot framework.
- **Redis**: The application uses Redis as the in-memory data store to store the mapping between short URLs and original URLs.

## Project Structure

The project follows a standard Maven project structure:
url-shortener/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── controller/
│   │   │           │   └── URLShortenerController.java
│   │   │           ├── model/
│   │   │           │   └── URL.java
│   │   │           │   └── ShortenedURL.java
│   │   │           ├── repository/
│   │   │           │   └── URLRepository.java
│   │   │           ├── service/
│   │   │           │   └── URLShortenerService.java
│   │   │           ├── util/
│   │   │           │   └── URLShortenerUtils.java
│   │   │           └── URLShortenerApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback.xml
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── controller/
│       │           │   └── URLShortenerControllerTest.java
│       │           └── service/
│       │               └── URLShortenerServiceTest.java
│       └── resources/
├── .gitignore
├── pom.xml
└── README.md


Copy code

## How to Run the Application

1. Ensure you have Java 11 or higher and Maven installed on your system.
2. Clone the repository or download the source code.
3. Navigate to the project directory in your terminal.
4. Run the following command to build and start the application:
5. The application will start running on `http://localhost:8080`.

## API Endpoints

1. **Shorten a URL**:
- Endpoint: `POST /api/v1/urls/shorten`
- Request Body: `{ "url": "https://www.example.com" }`
- Response: `{ "shortUrl": "http://localhost:8080/abc123" }`

2. **Redirect to Original URL**:
- Endpoint: `GET /{shortUrl}`
- Example: `GET /abc123`
- Response: Redirects the user to the original URL.

## Testing

The project includes unit tests for the `URLShortenerController` and `URLShortenerService` classes. You can run the tests using the following command:

## Future Improvements

1. Implement a more robust URL shortening algorithm to ensure uniqueness and scalability.
2. Add support for custom short URLs.
3. Implement rate limiting to prevent abuse.
4. Add monitoring and logging to improve observability.
5. Explore distributed caching solutions to improve performance and availability.

## Contributing

If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.



