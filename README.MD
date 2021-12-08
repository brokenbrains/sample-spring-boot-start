# BrokenBrains Spring Boot Micro sample

Microservices enabled application project

## Installation

```terminal
./gradlew assemble
```

## Usage

### To start

```terminal
./gradlew serviceUp
```

### To stop

```terminal
./gradlew serviceDown
```

## Tests
```terminal
./gradlew :[project-name]:test
```
Result: [project-name]/build/reports/tests/test/index.html

#### Project name
* customer-service (Third Party Application Sample)
* account-service 

### Accessing the Swagger UI
```terminal
http://localhost:8081/swagger.html
http://localhost:8082/swagger.html
```
### Accessing the Swagger API Doc URL
```terminal
http://localhost:8081/v3/api-docs
http://localhost:8082/v3/api-docs
```
### Generating Postman Collection
```terminal
open postman > import > Swagger API Doc URL
```
## ||||||||||||||| 
[BrokenBrains](https://github.com/brokenbrains)
