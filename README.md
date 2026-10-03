# Project Pipeline

Production-style Spring Boot REST API for creating and managing software delivery pipelines.

## Tech Stack
- Java 25
- Spring Boot 4
- Spring MVC
- Spring Data JPA / Hibernate
- PostgreSQL
- Bean Validation
- JUnit 5 / MockMvc
- Docker / Docker Compose
- GitHub Actions

## Architecture
Controller -> Service -> Repository -> PostgreSQL

## APIs
- GET /api/pipelines
- GET /api/pipelines/{id}
- POST /api/pipelines
- POST /api/pipelines/{id}/execute
- GET /api/pipelines/{id}/status
- DELETE /api/pipelines/{id}
- GET /api/health

## Run locally
Start PostgreSQL with `docker compose up -d postgres`, then run `mvn spring-boot:run`.
The API runs on http://localhost:8045.

## Example
POST /api/pipelines
```json
{"name":"order-service-ci","description":"Build and test the order service"}
```

## Testing
`mvn test`
