package com.attendance;

public class Student {
    private int id;
    private String name;
    private int totalClasses;
    private int classesAttended;

    public Student(int id, String name, int totalClasses, int classesAttended) {
        this.id = id;
        this.name = name;
        this.totalClasses = totalClasses;
        this.classesAttended = classesAttended;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getClassesAttended() {
        return classesAttended;
    }

    public void setClassesAttended(int classesAttended) {
        this.classesAttended = classesAttended;
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0.0;
        return ((double) classesAttended / totalClasses) * 100;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-15s | Attended: %3d/%3d | Percentage: %6.2f%%",
                id, name, classesAttended, totalClasses, getAttendancePercentage());
    }
}
