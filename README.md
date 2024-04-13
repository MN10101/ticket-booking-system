# Ticket Booking System

This is a ticket booking system designed to manage bookings, customers, movies, showtimes, and seats in a cinema or theater setting.

## Controllers

### BookingController

- **Endpoints**:
  - `GET /api/bookings`: Get all bookings.
  - `GET /api/bookings/{bookingId}`: Get a booking by ID.
  - `POST /api/bookings`: Add a new booking.
  - `PUT /api/bookings`: Update an existing booking.
  - `DELETE /api/bookings/{bookingId}`: Delete a booking by ID.

### CustomerController

- **Endpoints**:
  - `GET /api/customers`: Get all customers.
  - `GET /api/customers/{customerId}`: Get a customer by ID.
  - `POST /api/customers`: Add a new customer.
  - `PUT /api/customers`: Update an existing customer.
  - `DELETE /api/customers/{customerId}`: Delete a customer by ID.

### MovieController

- **Endpoints**:
  - `GET /api/movies`: Get all movies.
  - `GET /api/movies/{movieId}`: Get a movie by ID.
  - `POST /api/movies`: Add a new movie.
  - `PUT /api/movies`: Update an existing movie.
  - `DELETE /api/movies/{movieId}`: Delete a movie by ID.

### SeatController

- **Endpoints**:
  - `GET /api/seats`: Get all seats.
  - `GET /api/seats/{seatId}`: Get a seat by ID.
  - `POST /api/seats`: Add a new seat.
  - `PUT /api/seats`: Update an existing seat.
  - `DELETE /api/seats/{seatId}`: Delete a seat by ID.

### ShowtimeController

- **Endpoints**:
  - `GET /api/showtimes`: Get all showtimes.
  - `GET /api/showtimes/{showtimeId}`: Get a showtime by ID.
  - `POST /api/showtimes`: Add a new showtime.
  - `PUT /api/showtimes`: Update an existing showtime.
  - `DELETE /api/showtimes/{showtimeId}`: Delete a showtime by ID.

## Services

### BookingService

Provides CRUD operations for bookings.

### CustomerService

Provides CRUD operations for customers.

### MovieService

Provides CRUD operations for movies.

### SeatService

Provides CRUD operations for seats.

### ShowtimeService

Provides CRUD operations for showtimes.

## Data Access Objects (DAOs)

### BookingRepository

Handles database operations for bookings.

### CustomerRepository

Handles database operations for customers.

### MovieRepository

Handles database operations for movies.

### SeatRepository

Handles database operations for seats.

### ShowtimeRepository

Handles database operations for showtimes.

# Ticket Booking System

This is a ticket booking system designed to manage bookings, customers, movies, showtimes, and seats in a cinema or theater setting.

## Author

- Mahmoud Najmeh

## Configuration

```properties
spring.application.name=ticket-booking-system

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://localhost:3306/tbs_system
spring.datasource.username=*****
spring.datasource.password=*****
