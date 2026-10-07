# Microservice 1.1

User and authentication service. It runs on port `1001`, registers with Eureka, stores users in PostgreSQL, and issues JWTs for successful sign-ins.

## Prerequisites

- PostgreSQL running locally
- Database `soa14` available, or datasource settings updated in `src/main/resources/application.properties`
- Eureka server running on port `8761`

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

## Endpoints

- `GET /ms1/add?a=2&b=3` returns a simple addition response.
- `POST /ms1/signup` accepts a JSON user with `username` and `password`.
- `POST /ms1/signin` accepts JSON credentials and returns a JWT on success.

Example signin body:

```json
{
  "username": "alice",
  "password": "change-me"
}
```

Pass the returned JWT in the `Token` header when calling protected task-service endpoints.
