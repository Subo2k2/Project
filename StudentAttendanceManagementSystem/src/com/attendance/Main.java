package com.attendance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager(100);
        boolean running = true;

        System.out.println("Welcome to Student Attendance Management System");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Attendance");
            System.out.println("3. Sort Records (Insertion Sort by ID)");
            System.out.println("4. Search Student (Binary Search by ID)");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudentUI(scanner, manager);
                    break;
                case 2:
                    updateStudentUI(scanner, manager);
                    break;
                case 3:
                    manager.sortStudentsById();
                    break;
                case 4:
                    searchStudentUI(scanner, manager);
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addStudentUI(Scanner scanner, AttendanceManager manager) {
        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Total Classes Held: ");
            int total = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Classes Attended: ");
            int attended = Integer.parseInt(scanner.nextLine());

            if (manager.addStudent(id, name, total, attended)) {
                System.out.println("Student added successfully.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }
    }

    private static void updateStudentUI(Scanner scanner, AttendanceManager manager) {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter New Total Classes: ");
            int total = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter New Classes Attended: ");
            int attended = Integer.parseInt(scanner.nextLine());

            if (manager.updateAttendance(id, total, attended)) {
                System.out.println("Attendance updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }
    }

    private static void searchStudentUI(Scanner scanner, AttendanceManager manager) {
        if (manager.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        
        System.out.println("Note: Binary search requires the list to be sorted.");
        System.out.print("Do you want to sort automatically before searching? (y/n): ");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("y")) {
            manager.sortStudentsById();
        }

        try {
            System.out.print("Enter Student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            Student result = manager.searchStudentById(id);

            if (result != null) {
                System.out.println("Student Found: " + result);
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format.");
        }
    }
}
