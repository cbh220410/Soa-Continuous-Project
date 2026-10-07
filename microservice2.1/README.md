# Microservice 2.1

JWT-protected task management service. It runs on port `1002`, registers with Eureka, and persists tasks in PostgreSQL.

## Prerequisites

- PostgreSQL database `soa14`, or updated datasource settings
- Eureka server running on port `8761`
- A JWT from `microservice1.1` signin

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

## Endpoints

All task endpoints require the JWT in the `Token` request header.

- `GET /ms2/mul?a=2&b=3`
- `POST /ms2/createtask`
- `GET /ms2/getalltasks/{PAGE}/{SIZE}`
- `PUT /ms2/updatetask/{ID}`
- `DELETE /ms2/deletetask/{ID}`

Task fields include `title`, `description`, `assignedto`, `priority`, `status`, and `deadline`. The service records the authenticated user as `createdbywhom`.
