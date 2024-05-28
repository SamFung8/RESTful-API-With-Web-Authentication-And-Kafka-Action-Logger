# RESTful-API-With-Web-Authentication-And-Kafka-Action-Logger

This project is a Spring Boot-based web application that provides a RESTful API for managing a product catalog. The key features of this project include:

• RESTful API: The application exposes a set of RESTful endpoints MYSQL DB for performing CRUD (Create, Read, Update, Delete) operations on product data using ORM(Object Relational Mapping) method.
• Web-based Authentication: The application includes a web-based authentication system, allowing users to securely access and interact with the product management functionality.
• Kafka Integration for Action Logging: The application integrates with Apache Kafka, a distributed streaming platform, to log user actions, such as creating, updating, or deleting products. These user actions are recorded in log files for auditing and analytics purposes.


The main components of this project include:

• Product Management Service: Responsible for handling CRUD operations on product data and communicating with the Kafka producer.
• Product Repository: A Spring Data JPA repository that provides the necessary database operations for the Product entity.
• Product Controller: The Spring MVC controller that exposes the RESTful API endpoints for managing products.
• Kafka Consumer: A Python script that subscribes to the Kafka topic and logs the user actions to local log files.
• This project demonstrates the integration of a Spring Boot-based web application with a Kafka-based logging system, providing a robust and scalable solution for managing a product catalog with user action tracking.
