# Spring Boot Project with MongoDB and Thymeleaf

## Description
This is a Spring Boot project that uses MongoDB as the database and Thymeleaf for the front-end. The project includes user registration, login, and CRUD operations for a TODO application.

## Table of Contents
1. [Installation](#installation)
2. [Configuration](#configuration)
3. [Usage](#usage)
4. [Features](#features)
5. [Technologies Used](#technologies-used)
6. [Contributing](#contributing)
7. [License](#license)
8. [Contact](#contact)

## Installation

### Prerequisites
- Java 11 or higher
- Maven
- MongoDB

### Steps
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the project:
    ```bash
    mvn spring-boot:run
    ```

## Configuration

### `application.properties`
Make sure to configure your MongoDB connection settings in the `src/main/resources/application.properties` file:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/your-database-name
spring.thymeleaf.cache=false
