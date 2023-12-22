# Wheels on Rent - Project

This project consists of three microservices (backend) for car, customer, and rental management, as well as a frontend application in React to interact with the services.

## Backend

### Car Project
- **Description:** Microservice for car and station management.
- **Technologies:** Spring Boot, JPA, SQL database.
- **Port:** 8091 (can be changed in `src/main/resources/application.properties`).

### Customer Project
- **Description:** Microservice for customer and address management.
- **Technologies:** Spring Boot, JPA, SQL database.
- **Port:** 8093 (can be changed in `src/main/resources/application.properties`).

### Rental Project
- **Description:** Microservice for rental and insurance management.
- **Technologies:** Spring Boot, JPA, SQL database.
- **Port:** 8092 (can be changed in `src/main/resources/application.properties`).

## Frontend

### Wheels on Rent App
- **Description:** A React web application for interacting with the different microservices.
- **Technologies:** React, JavaScript.
- **Port:** 3000 (can be changed in `frontend/wheels-on-rent-app/package.json`).

## How to Run the Project

1. Clone the project from [GitHub](https://github.com/samami2002/WheelsOnRent.git).
2. Start each microservice (car-project, customer-project, rental-project) separately.
3. Navigate to frontend/wheels-on-rent-app and run `npm install` and `npm start` to start the frontend application.

## Team Members

- Danilo Schulman
- Hugo Rajamäe
- Saman Amirrahmani

## Links

- [GitHub Repo](https://github.com/samami2002/WheelsOnRent.git)
