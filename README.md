# SOA Continuous Project

A Spring Boot microservices workspace for user authentication, task management, service discovery, and API routing.

## Modules

| Module | Role | Port |
| --- | --- | ---: |
| `ms_eureka_server` | Netflix Eureka service registry | `8761` |
| `microservice1.1` | User signup, signin, and JWT generation | `1001` |
| `microservice2.1` | JWT-protected task CRUD service | `1002` |
| `microservice2.2` | Alternate lightweight multiplication service | `1003` |
| `api` | Spring Cloud Gateway for `ms1` and `ms2` routes | `8000` |
| `projectname1` | Standalone Spring Boot/JPA sample using H2 | `1119` |

## Requirements

- JDK compatible with the Spring Boot version declared in each module's `pom.xml`
- Maven, or the included Maven wrapper (`mvnw.cmd`)
- PostgreSQL for `microservice1.1` and `microservice2.1`/`microservice2.2`
- A database named `soa14`, unless the datasource settings are changed

The PostgreSQL username, password, and JWT signing key are configured in source properties. Replace local development values with environment-specific configuration before sharing or deploying the services.

## Run Order

Open a terminal in each module and run:

```powershell
cd ms_eureka_server
.\mvnw.cmd spring-boot:run
```

Then start `microservice1.1`, `microservice2.1` (or `microservice2.2`), and finally `api` in separate terminals:

```powershell
cd microservice1.1
.\mvnw.cmd spring-boot:run
```

```powershell
cd microservice2.1
.\mvnw.cmd spring-boot:run
```

```powershell
cd api
.\mvnw.cmd spring-boot:run
```

Use `.\mvnw.cmd test` in a module to run its tests. The gateway forwards `/ms1/**` to port `1001` and `/ms2/**` to port `1002` by default.

## API Overview

### User service

- `GET /ms1/add?a=2&b=3`
- `POST /ms1/signup`
- `POST /ms1/signin`

### Task service (`microservice2.1`)

Task mutation and listing endpoints require the JWT returned by signin in the `Token` header:

- `GET /ms2/mul?a=2&b=3`
- `POST /ms2/createtask`
- `GET /ms2/getalltasks/{PAGE}/{SIZE}`
- `PUT /ms2/updatetask/{ID}`
- `DELETE /ms2/deletetask/{ID}`

## Notes

- Start the registry before services that register with Eureka.
- Gateway routes currently use fixed localhost URLs; update `api/src/main/resources/application.properties` when deploying elsewhere.
- Generated `target/` directories and IDE metadata are intentionally ignored by Git.
