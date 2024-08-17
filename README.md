# bookstore

Project Documentation

Project Documentation
=====================

Table of Contents
-----------------

1.  [Overview](#overview)
2.  [Setting Up the Application](#setting-up-the-application)
3.  [Running the Application](#running-the-application)
4.  [API Endpoints](#api-endpoints)
   *   [Authentication](#authentication)
   *   [Books](#books)
   *   [Patrons](#patrons)
   *   [Borrowing Records](#borrowing-records)
   *   [Registration](#registration)
5.  [Obtaining a Token](#obtaining-a-token)
6.  [Using the Token](#using-the-token)



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

### Authentication

Authentication is managed using JWT (JSON Web Tokens). Ensure you have a valid token to access secured endpoints.

### Registration

*   **Register a New User**

    **POST** `/api/auth/signup`

    Request Body:

        {
            "fullName": "fullName",
            "email": "email",
            "password": "password"
        }


Registers a new user with the specified fullName, email, and password.


Obtaining a Token
-----------------

You must authenticate to obtain a JWT token. Use the following endpoint:

*   **Login**

    **POST** `/api/auth/login`

    Request Body:

        {
            "email": "your-email",
            "password": "your-password"
        }


    Response:
    
        {
            "token": "your-jwt-token",
            "expiresIn": expiration-time
        }



Using the Token
---------------

Include the token in the `Authorization` header for protected endpoints:

    Authorization: your-jwt-token

API DOCUMENTAION
---------------

https://documenter.getpostman.com/view/27300981/2sA3s9BnjE

