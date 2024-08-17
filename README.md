# bookstore

Project Documentation
=====================

Table of Contents
-----------------

1.  [Overview](#overview)
2.  [Setting Up the Application](#setting-up-the-application)
3.  [Running the Application](#running-the-application)
4.  [API Endpoints](#api-endpoints)
5.  [Using the Token](#using-the-token)



Overview
--------

This project is a library management system built using Spring Boot. It includes features for managing books, borrowing records, and patrons.

Setting Up the Application
--------------------------

### Prerequisites

*   **Java 17** or later
*   **Maven** for dependency management and build
*   **Git** for version control

### Configuration

Ensure that your `application.properties` file in the `src/main/resources` directory is set up correctly. Here’s a basic example:

    server.port=8080
    
    # Database configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=root
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=create-drop
    spring.jpa.show-sql=true
    
    # JWT Configuration
    security.jwt.secret-key=your-secret-key
    security.jwt.expiration-time=3600000
    
    # Other configurations
    logging.level.org.springframework=INFO


Replace `your-secret-key` with a strong secret key for JWT and adjust the database URL, username, and password as per your database setup.

Running the Application
-----------------------

1.  **Clone the Repository**

        git clone git@github.com:mahmoud-elbasiony/bookstore.git
        cd bookstore


2.  **Build the Project**

        mvn clean install


3.  **Run the Application**

        mvn spring-boot:run


    The application will start and be available at `http://localhost:8080`.


API Endpoints
-------------
https://documenter.getpostman.com/view/27300981/2sA3s9BnjE

Using the Token
---------------

Include the token in the `Authorization` header for protected endpoints:

    Authorization: your-jwt-token




