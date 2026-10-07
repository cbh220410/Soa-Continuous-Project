# Microservice 2.2

Lightweight alternate implementation of the `ms2` service. It registers with Eureka on port `1003` and currently exposes a multiplication endpoint only.

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

## Endpoint

```text
GET /ms2/mul?a=6&b=7
```

The response is a plain-text multiplication result. This module uses the same `/ms2` base path as `microservice2.1`, so do not run both behind the same gateway route without changing the gateway target.
