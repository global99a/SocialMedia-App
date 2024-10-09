# Social Media Application

## Project Overview
This Social Media Application allows users to create accounts, log in, post articles, comment on them, like articles, and follow other users. The application is built using Spring Boot for the backend and React for the frontend. It utilizes PostgreSQL as the database to manage user accounts, articles, comments, likes, and user relationships.

## Installation Steps

### Prerequisites
Before you begin, ensure you have the following installed on your system:
- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/download/)


### Backend Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/global99a/SocialMedia-App.git
   cd SocialMedia-App/backend
   Set Up PostgreSQL Database:
### Install Backend Dependencies:
mvn install

 ### Start the Spring Boot Application: 
 You can run the Spring Boot application using Maven. Use the following command:
mvn spring-boot:run
Backend runs on http://localhost:8080
# Mock Database Setup

This project uses a PostgreSQL database for data persistence. Below are the steps to set up the PostgreSQL database, including the necessary configurations and connection details.

### PostgreSQL Setup

1. **Install PostgreSQL**:
   If you haven't installed PostgreSQL, download and install it from the [official website](https://www.postgresql.org/download/). Follow the instructions for your operating system.

2. **Create a Database**:
   Open your terminal or command prompt and access the PostgreSQL shell:
   psql -U postgres
3.Update the application.properties or application.yml file in the src/main/resources directory with your PostgreSQL connection details:
properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/socialmedia-db
spring.datasource.username=your_username
spring.datasource.password=your_password

