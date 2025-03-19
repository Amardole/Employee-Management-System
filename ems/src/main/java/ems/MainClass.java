package ems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    private static final String URL = "jdbc:postgresql://localhost:5432/Enter_Your_DatabaseName";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Enter_your_password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n------------Employee Management System--------------");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Employee Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); 
                    addEmployee(name, age, dept, salary);
                    System.out.println(" \n Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Employee Name: ");
                    String newName = scanner.nextLine();
                    updateEmployee(updateId, newName);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); 
                    deleteEmployee(deleteId);
                    break;
                case 4:
                    viewAllEmployees();
                    break;
                case 5:
                    System.out.println("\n Exit Successfully ....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEmployee(String name, int age, String dept, double salary) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "INSERT INTO employee (name, age, department, salary) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, dept);
                pstmt.setDouble(4, salary);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

    private static void updateEmployee(int id, String newName) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE employee SET name = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("\n Employee updated successfully!");
            } else {
                System.out.println(" \n No employee found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployee(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM employee WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("\n Employee deleted successfully!");
            } else {
                System.out.println("\n No employee found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllEmployees() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }
            if (employees.isEmpty()) {
                System.out.println("\n No employees found.");
            } else {
                employees.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class Employee {
        private int id;
        private String name;
        private int age;
        private String dept;
        private double salary;

        public Employee(int id, String name, int age, String dept, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.dept = dept;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}