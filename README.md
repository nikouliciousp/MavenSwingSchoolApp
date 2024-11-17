# SchoolApp

## Description
SchoolApp is a Java Swing application built with Maven, designed to manage students and teachers within an educational institution. This application provides functionalities for adding, updating, deleting, and viewing student and teacher information.

## Features
- Add, update, delete, and view student information.
- Add, update, delete, and view teacher information.
- Search functionality for students and teachers.
- User-friendly graphical user interface (GUI) built with Java Swing.
- Data storage and retrieval using a local database (e.g., MySQL).

## Prerequisites
To run the application, you will need:
- Java Development Kit (JDK) 8 or later.
- A Java development environment such as Eclipse or IntelliJ IDEA.
- MySQL JDBC driver (if using MySQL for data storage).
- Apache Maven installed on your system.

## Running the Application
Follow these steps to run the application:

1. Clone the repository:
   
   ```bash
   git clone https://github.com/nikouliciousp/MavenSwingSchoolApp.git

2. Open the project in your preferred development environment.

3. Ensure the MySQL JDBC driver is included in your project's dependencies in the pom.xml file.

4. Compile and run the application using Maven:
   
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.schoolapp.Main"

5. Ensure that your pom.xml file includes the necessary dependencies, such as:
  
   ```bash
      <dependencies>
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>8.0.26</version>
          </dependency>
          <dependency>
              <groupId>org.swinglabs</groupId>
              <artifactId>swingx-all</artifactId>
              <version>1.6.4-2</version>
          </dependency>
          <!-- Add other dependencies here -->
      </dependencies>
      
