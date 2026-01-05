package com.attendance;

public class AttendanceManager {
    private Student[] students;
    private int count;
    private int capacity;

    public AttendanceManager(int capacity) {
        this.capacity = capacity;
        this.students = new Student[capacity];
        this.count = 0;
    }

    public boolean addStudent(int id, String name, int totalClasses, int attended) {
        if (count >= capacity) {
            System.out.println("Error: Database is full.");
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(students[i].getId() == id) {
                System.out.println("Error: Student ID already exists.");
                return false;
            }
        }
        students[count++] = new Student(id, name, totalClasses, attended);
        return true;
    }
    public boolean updateAttendance(int id, int newTotal, int newAttended) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].setTotalClasses(newTotal);
                students[i].setClassesAttended(newAttended);
                return true;
            }
        }
        return false;
    }
    public void sortStudentsById() {
        for (int i = 1; i < count; i++) {
            Student key = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].getId() > key.getId()) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
        System.out.println("Students sorted by ID successfully.");
    }
    public Student searchStudentById(int id) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (students[mid].getId() == id) {
                return students[mid];
            }

            if (students[mid].getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }
    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
        System.out.println("-----------------------");
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
}
