# Travel Booking Backend

Spring Boot backend application for managing travel bookings, including customers, carts, vacations, and excursions. Designed to support a frontend booking interface by handling checkout and data persistence.

## Overview

This application provides backend functionality for a travel booking system. It manages customer data, shopping cart behavior, and excursion selections, and processes checkout by persisting relational data across multiple entities.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- REST APIs
- Angular (frontend integration)

## Features

- RESTful backend for travel booking operations
- Checkout flow that processes customer orders and persists related data
- Entity relationships between customers, carts, vacations, and excursions
- Data seeding for initial records using a DataLoader
- Cross-origin configuration to support Angular frontend communication
- Repository pattern using Spring Data JPA

## Project Structure

- `controllers/` – API endpoints
- `services/` – business logic for checkout and processing
- `dao/` – data access layer using JPA repositories
- `entities/` – domain models (Customer, Cart, Vacation, Excursion, etc.)
- `config/` – configuration classes and data seeding

## How to Run

1. Clone the repository
2. Configure your database connection in `application.properties`
3. Ensure MySQL is running and accessible
4. Run the application:
   - Linux/Mac:
     ```
     ./mvnw spring-boot:run
     ```
   - Windows:
     ```
     mvnw.cmd spring-boot:run
     ```

## Notes

- Originally developed as part of a full-stack system with an Angular frontend
- Backend is designed to handle checkout logic and persist booking data across related entities

## What I Learned

- Building a layered backend architecture using Spring Boot
- Designing and implementing RESTful APIs
- Working with relational data models and entity relationships
- Integrating backend services with a frontend application