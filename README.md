**Movie Ticket Booking System**

The Movie Ticket Booking System is a simple Java application developed to demonstrate object-oriented programming (OOP) principles. The system allows users to browse movies, select showtimes, choose seats, and book tickets in a structured and organized way.
This project is designed as a university assignment and focuses on clean code structure, proper use of OOP concepts, UML diagrams, unit testing, and version control using Git and GitHub.

**Project Structure**

The project is organized using a clear and modular package structure to improve readability and maintainability. The model package contains the core domain classes such as movies, bookings, customers, seats, and showtimes. The interfaces package defines system contracts like the Bookable interface, while the app package contains the main entry point used to run the application. A separate test directory is used for testing-related code, following standard Maven project conventions. This structure helps separate concerns and supports clean object-oriented design principles.

**OOP Concepts Used**

- Encapsulation – Class fields are private and accessed through methods
- Inheritance – Movie2D and Movie3D extend the abstract Movie class
- Polymorphism – Different pricing logic implemented via method overriding
- Interfaces – Bookable interface implemented by the Booking class
- Abstraction – Abstract Movie class defines common behavior

**UML Diagrams**

- Class Diagram
- Use Case Diagram

UML diagrams were created to visualize the system structure and user interactions.

## How to Run
1. Clone the repository
2. Run `mvn clean package`
3. Run `java -jar target/MovieTicketSystem-1.0-SNAPSHOT.jar`
