Student Attendance Management System (Java):
  A simple console based Java application for managing student attendance records. The project focuses on clean code structure, object oriented design, and manual implementation of basic algorithms using arrays.

Overview:
  This application allows users to manage student attendance through a text based menu. It supports adding students, updating attendance, sorting records, searching students, and displaying all stored data. The goal of the project is clarity and correctness rather than advanced frameworks or libraries.

Features:
- Add new student records.
- Update attendance of existing students.
- Sort students by ID.
- Search students by ID.
- Display all students with attendance percentage.

Project Structure:
css
  com.attendance
  ├── Main.java
  ├── AttendanceManager.java
  └── Student.java

Code Explanation:
i: Student.java:
  Represents a single student.

Responsibilities:
- Stores student ID, name, total classes, and attended classes.
- Calculates attendance percentage.
- Formats student data for display.

Key Design Choices:
- All fields are private to enforce encapsulation.
- Attendance percentage logic is kept inside the student model.
- toString() is overridden to provide clean formatted output.

ii: AttendanceManager.java:
  Handles the core application logic.

Responsibilities:
- Stores students in a fixed size array.
- Adds new students while preventing duplicate IDs.
- Updates attendance information.
- Sorts students by ID using insertion sort.
- Searches students by ID using binary search.

Why This Design:
- Keeps logic separate from user interaction.
- Makes algorithms explicit and easy to follow.
- Demonstrates composition by managing Student objects.

iii: Main.java:
  Entry point of the application.

Responsibilities:
- Displays menu options.
- Reads user input using Scanner.
- Calls appropriate methods from AttendanceManager.

Design Notes:
- Contains no business logic.
- Focuses only on program flow and input handling.
- Includes basic exception handling to prevent crashes.

Data Structures Used:
- Fixed size array of Student objects.
Arrays were intentionally used to make sorting and searching algorithms transparent.

Algorithms Used:
i: Insertion Sort:
- Sorts students by ID in ascending order.
- Efficient for small datasets.
- Worst case time complexity: O(n²).
- In place sorting.

ii: Binary Search:
- Searches for students by ID.
- Requires sorted data.
- Time complexity: O(log n).

iii: Error Handling:
- Duplicate student IDs are rejected.
- Invalid numeric input is handled using try catch blocks.
- Empty list checks are performed before searching.

Limitations:
- Fixed maximum number of students.
- No persistent storage.
- Console based interface only.

Possible Improvements:
- Use dynamic collections instead of arrays.
- Add file or database storage.
- Implement a graphical user interface.
- Add sorting by name or attendance percentage.
