# Task For Java Junior Developer Position

# Task Management System Development

## Task Description
You are tasked with developing a straightforward Task Management System using Java. This system should offer features for creating, editing, deleting, and viewing tasks. Each task should encompass a title, description, status (e.g., "pending," "in progress," "completed"), priority (e.g., "high," "medium," "low"), as well as the author and assignee of the task. Only API implementation is required.

## Requirements
1. The service must support user authentication and authorization via email and password.
2. Access to the API must be authenticated using JWT tokens.
3. Users can manage their tasks: create new ones, edit existing ones, view and delete, change task status, and assign task assignees.
4. Users can view tasks of other users, and task assignees can change the status of their tasks.
5. Comments can be added to tasks.
6. The API should allow retrieving tasks of a specific author or assignee, as well as all comments related to them. Filtering and pagination of output should be provided.
7. The service must handle errors properly, return clear messages, and validate incoming data.
8. The service must be well-documented. The API should be described using Open API and Swagger. Swagger UI should be configured in the service. A README with instructions for local project setup must be written. Development environment should be set up using docker-compose.
9. Write several basic tests to verify the core functions of your system.
10. Use Java 17+ and Spring, Spring Boot for system implementation. PostgreSQL or MySQL can be used as the database. Spring Security should be used for authentication and authorization. Additional tools can be used if necessary (e.g., caching).

## Evaluation
The following aspects will be evaluated:
1. Compliance with requirements.
2. Code quality and cleanliness.
3. System design and use of OOP.
4. Presence of tests and their coverage.
5. Error handling.
