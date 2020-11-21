# Sleeper
Playing around with the [Sleeper App](https://sleeper.app/) public API: https://docs.sleeper.app/

## Build
Gradle based project running Java 11.

```
./gradlew clean build
./gradlew bootRun

curl localhost:8080/sleeper/user/<user_name>
```

## Codegen
Generates the Sleeper client from an OAS doc using the [OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator)
