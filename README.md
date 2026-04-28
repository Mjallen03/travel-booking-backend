# Travel Booking Backend

Spring Boot backend application for managing travel bookings, customer records, carts, and excursions. Built with a layered architecture using controllers, services, repositories, and JPA entities.

## Overview
This project provides backend functionality for a travel booking system. It supports customer order processing, excursion selection, cart management, and seeded sample data for testing and development.

## Tech Stack
- Java
- Spring Boot
- Maven
- Spring Data JPA
- REST APIs
- MySQL
- Angular frontend integration

## Features
- REST endpoint for checkout and order placement
- Layered backend architecture with controller, service, and repository layers
- Entity modeling for customers, vacations, excursions, carts, and divisions
- Seed data loading for initial records
- Cross-origin configuration for frontend communication
- Database persistence with JPA repositories

## Project Structure
- `controllers/` - API endpoints
- `services/` - business logic
- `dao/` - data access repositories
- `entities/` - domain models
- `config/` - application configuration and seed data

## How to Run
1. Clone the repository
2. Configure the database in `application.properties`
3. Run the application with Maven wrapper:
   - `./mvnw spring-boot:run`
   - or on Windows: `mvnw.cmd spring-boot:run`
4. Connect the frontend or test endpoints locally

## What I Learned
- Building a backend application with Spring Boot
- Structuring a project with layered architecture
- Implementing RESTful services and persistence
- Integrating backend functionality with a frontend application