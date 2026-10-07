# API Gateway

Spring Cloud Gateway entry point for the SOA project. It exposes a single gateway on port `8000` and forwards requests to the user and task services.

## Routes

| Gateway path | Upstream |
| --- | --- |
| `/ms1/**` | `http://localhost:1001` |
| `/ms2/**` | `http://localhost:1002` |

The upstream URLs are defined in `src/main/resources/application.properties`. Update them for a non-local deployment.

## Run

Start the Eureka server and upstream services first, then run:

```powershell
.\mvnw.cmd spring-boot:run
```

The gateway is available at `http://localhost:8000`.
