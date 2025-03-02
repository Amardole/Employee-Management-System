# Employee Management System

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.6-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-green)
![JDBC](https://img.shields.io/badge/JDBC-4.2-orange)

The **Employee Management System** is a console-based application built using **Core Java**, **JDBC**, and **PostgreSQL**. It allows users to perform CRUD (Create, Read, Update, Delete) operations on employee records stored in a PostgreSQL database. The application is menu-driven, providing a simple and intuitive interface for managing employee data.

---

## Features

- **Add Employee**: Add a new employee record to the database.
- **View All Employees**: Fetch and display all employee records.
- **Update Employee**: Update an existing employee's details (e.g., name, age, department, salary).
- **Delete Employee**: Delete an employee record by ID.
- **Search Employee**: Search for an employee by their ID.
- **Input Validation**: Validate user inputs to ensure data integrity.
- **Menu-Driven Interface**: Easy-to-use console-based menu for seamless navigation.

---

## Technologies Used

- **Core Java**: For implementing the application logic and OOPs concepts.
- **JDBC (Java Database Connectivity)**: For connecting to and interacting with the PostgreSQL database.
- **PostgreSQL**: For storing and managing employee data.
- **Maven**: For project dependency management and building the project.

---

## Dependencies

The project uses the following dependencies:

- **PostgreSQL JDBC Driver**: For connecting to the PostgreSQL database.
  ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.6.0</version>
  </dependency>
  ```

---

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK) 17 or higher**.
2. **Apache Maven 3.8.6 or higher**.
3. **PostgreSQL 15 or higher**.
4. A PostgreSQL database with the following table:
   ```sql
   CREATE TABLE employees (
       id SERIAL PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       age INT NOT NULL,
       department VARCHAR(100) NOT NULL,
       salary DECIMAL(10, 2) NOT NULL
   );
   ```

---

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeatureName`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeatureName`).
5. Open a pull request.

---

## Contact

For any questions or feedback, feel free to reach out:

- **Your Name** : Amar Dole 
- **Email**: amardole7576@gmail.com  
- **GitHub**: [your-username](https://github.com/Amardole)

---

Enjoy using the **Employee Management System**! 🚀

---



