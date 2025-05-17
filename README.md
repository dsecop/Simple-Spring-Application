# Simple Spring Application

The goal of this project is to create a GitHub Actions pipeline for a simple Spring application.
The pipeline includes a workflow that performs the following steps:

- Runs automated tests to ensure code correctness.
- Builds the project using Gradle.
- Packages the application into a JAR file.
- Creates a Docker image containing the built JAR file.
- Pushes the Docker image to Docker Hub.

## Technologies Used

- Java 17
- Spring Boot
- Gradle
- Docker

## Prerequisites

- Java 17 or higher
- Gradle 8.5 or higher
- Docker (for containerization)

## Building the Application

### Using Gradle

```bash
./gradlew build
```

The built JAR file will be located in the `build/libs/` directory.

### Using Docker

```bash
docker build -t spring-hello-world .
```

## Running the Application Locally

### Using Java

```bash
java -jar build/libs/app-0.0.1-SNAPSHOT.jar
```

### Using Docker

```bash
docker run -p 8080:8080 spring-hello-world
```

The application will be accessible at http://localhost:8080

## Running Tests
To run the automated tests for the application, use the following Gradle command:
```bash
./gradlew test
```

Test reports are generated in:
```bash
build/reports/tests/test/index.html
```
You can open this file in a web browser to view detailed test results.

## Pulling the Docker Image
You can pull the prebuilt Docker image from Docker Hub using the following command:
```bash
docker pull secop/spring-app
```

## Running Pulled Docker Image
To run the container from the pulled image:
```bash
docker run -p 8080:8080 secop/spring-app
```
The application will be available at http://localhost:8080

## API Endpoints

- `GET /` - Returns "Hello World from Spring Boot"
- `GET /goodbye` - Returns "Goodbye from Spring Boot"

## Project Structure

- `src/main/java/com/example/app/AppApplication.java` - Main application class
- `src/main/java/com/example/app/HelloWorldController.java` - REST controller with endpoints
- `Dockerfile` - Docker configuration for containerizing the application
