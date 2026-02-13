# Blood Bank Management System

## Overview
The Blood Bank Management System is a web application built using Java 11, Spring Boot, MySQL, and Thymeleaf. It aims to streamline the process of blood donation management, allowing donors to register, manage their profiles, and view their donation history. Admins can manage donor information and oversee blood inventory.

## Features
- **User Authentication**: Secure login and registration for donors and admins.
- **Role-Based Access Control**: Different functionalities for donors and admins based on user roles.
- **Donor Management**: Admins can view, add, edit, and delete donor information.
- **Blood Inventory Management**: Admins can manage blood donation records, including adding and removing inventory.
- **Responsive UI**: User-friendly interface built with Thymeleaf and styled with CSS.

## Technologies Used
- **Java 11**: Programming language used for backend development.
- **Spring Boot**: Framework for building the web application.
- **MySQL**: Database for storing user and blood inventory data.
- **Thymeleaf**: Template engine for rendering web pages.

## Setup Instructions
1. **Clone the Repository**:
   ```
   git clone <repository-url>
   cd blood-bank-management-system
   ```

2. **Configure Database**:
   - Create a MySQL database for the application.
   - Update the `src/main/resources/application.properties` file with your database credentials.

3. **Build the Application**:
   ```
   mvn clean install
   ```

4. **Run the Application**:
   ```
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - Open your web browser and go to `http://localhost:8080`.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for details.