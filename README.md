# TaskManagementSystem

Welcome to TaskManagementSystem! This application helps you organize tasks for users efficiently. Below, you'll find information on how to set up and run the application, as well as an overview of its key features.

You can access Swagger and see all available endpoints by visiting http://localhost:8080/swagger-ui/index.html

## Features

- **User Management**: Users can log in, create, and update tasks, as well as write comments.
- **Registration and Authorization**: Registration and authorization are handled securely using JWT Tokens.
- **Task Management**: Tasks can be created by users and organized efficiently.
- **Comments**: Tasks can have comments associated with them, allowing for collaboration and discussion.

## Getting Started

To run this application locally, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the root directory of the project.
3. Create a `.env` file in the root directory with the following environment variables:

HOST - host of Postgresql database
POSTGRES_USERNAME - username for Postgresql database
POSTGRES_PASSWORD - password for Postgresql database
POSTGRES_DATABASE - name of Postgresql database
POSTGRES_SCHEMA - name of Postgresql schema
SPRING_JPA_HIBERNATE_DDL_AUTO=update
JWT_SECRET - secret string for JWT tokens

Replace `<...>` placeholders with your PostgreSQL database credentials and JWT secret string.

4. Ensure you have PostgreSQL installed and running on your machine.
5. Run the application using your preferred Java IDE or by executing `./mvnw spring-boot:run` in the terminal.

