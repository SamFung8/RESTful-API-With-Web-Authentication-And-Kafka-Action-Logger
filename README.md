# RESTful-API-With-Web-Authentication-And-Kafka-Action-Logger

>This project is a Spring Boot-based web application that provides a RESTful API for managing a product catalog. The key features of this project include:

>> • **RESTful API:** A set of RESTful endpoints connected with MYSQL DB for performing CRUD (Create, Read, Update, Delete) operations on data using ORM(Object Relational Mapping).
>> • **Web-based Authentication:** A web-based authentication system allows access to the different RESTful API functionalities based on user account(Admin, Senior User and Normal User).__
>> • **Kafka Integration for Web Action Logger:** A distributed streaming platform used Apache Kafka to logging user RESTful actions(create, update, or delete) and recorded as log files for auditing and analytics.__


The main components packages of this project include:

• **APIService:** Handles the RESTful API functionality, processing requests and responses.\
• **ExceptionConfig:** Manages exception handling and provides consistent error responses.\
• **KafkaConfig:** Configures the integration with Apache Kafka for distributed logging and event streaming.\
• **MVCConfig:** Sets up the Model-View-Controller architecture and web-based functionality.\
• **SecurityConfig:** Handles authentication, authorization, and access control for the application.
