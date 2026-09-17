package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!\n");

        // 1. Creating a student using the default constructor
        Student student1 = new Student();
        student1.roll = 101;
        student1.name = "John Doe";

        // 2. Creating a student using the parameterized constructor
        Student student2 = new Student(102, "Jane Smith");

        // Displaying the data
        System.out.println("Student 1 Details:");
        student1.displayInfo();

        System.out.println("\nStudent 2 Details:");
        student2.displayInfo();
    }
}

// We remove the "public" keyword here so it can safely live inside Main.java
class Student {
    int roll;
    String name;

    Student() {
    }

    public Student(int r, String n) {
        roll = r;
        name = n;
    }

    public void displayInfo() {
        System.out.println("Roll Number: " + roll + " | Name: " + name);
    }
}