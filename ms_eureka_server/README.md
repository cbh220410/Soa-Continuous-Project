# Eureka Server

Netflix Eureka service registry for the SOA microservices. The server runs on port `8761` and does not register itself or fetch a registry.

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

Open the Eureka dashboard at `http://localhost:8761`.

Start this service before `microservice1.1`, `microservice2.1`, or `microservice2.2`, which are configured as Eureka clients.
