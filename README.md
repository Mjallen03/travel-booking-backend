# Travel Booking Backend API

Spring Boot backend service for a travel booking platform, handling customers, carts, vacations, excursions, and checkout processing with MySQL persistence.

## Overview
This application provides a RESTful API for managing travel booking operations. It supports customer management, shopping cart functionality, and a checkout system that persists relational data across multiple entities.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- REST APIs

## Features
- RESTful API for managing:
    - Customers
    - Vacations
    - Excursions
    - Shopping carts
- Checkout system that:
    - Processes purchases
    - Generates order tracking numbers
    - Persists related entities (customer, cart, cart items)
- Relational database modeling with JPA/Hibernate
- Automatic schema updates using Hibernate
- Preloaded sample data using a DataLoader
- CORS configuration for frontend integration

## Project Structure
controllers/   → API endpoints  
services/      → business logic  
dao/           → data access (JPA repositories)  
entities/      → domain models  
config/        → configuration and data seeding

## How to Run

### 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/travel-booking-backend.git  
cd travel-booking-backend

### 2. Set up MySQL
Create a database:
CREATE DATABASE full_stack_ecommerce;

### 3. Update database config (if needed)
Edit:
src/main/resources/application.properties

Make sure:
spring.datasource.url=jdbc:mysql://localhost:3306/full_stack_ecommerce  
spring.datasource.username=your_username  
spring.datasource.password=your_password

### 4. Run the application

Windows:
mvnw.cmd spring-boot:run

Mac/Linux:
./mvnw spring-boot:run

### 5. Access the API
Open in browser:
http://localhost:8080/api

Example endpoints:
- /api/customers
- /api/vacations
- /api/excursions
- /api/checkout/purchase

## Notes
- Designed to integrate with an Angular frontend (not included)
- Uses Spring Data REST for rapid API exposure
- Built and tested locally with MySQL

## What I Learned
- Building a layered backend architecture (Controller → Service → DAO)
- Integrating Spring Boot with a relational database
- Designing RESTful APIs and handling data persistence
- Debugging and configuring database connections in a local environment  