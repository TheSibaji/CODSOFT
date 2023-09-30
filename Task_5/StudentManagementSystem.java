package Task_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//  student class
class Student {
    private static int rollNumberStart = 11111;    //starting point of roll number
    private int rollNumber;
    private String name;
    private long phoneNumber;
    private String bloodGroup;
    private String grade;

    public Student(String name, String grade, long phone, String blood) {
        this.name = name;
        this.rollNumber = ++rollNumberStart;    //updating roll number automatically when addiing new student
        this.grade = grade;
        this.phoneNumber = phone;
        this.bloodGroup = blood;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public long getPhoneNumber(){
        return phoneNumber;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ",  Grade: " + grade+", Roll Number: " + rollNumber + ", Phone Number: " + phoneNumber + ", Blood group: "+bloodGroup;
    }
}


// Student management system 
class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, String grade, long phone, String blood) {
        Student student = new Student(name, grade, phone, blood);
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Main method
public class StudentManagementSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StudentManagement system = new StudentManagement();

            System.out.println("\nStudent Management System");
            while (true) {
                try {
                    System.out.println("\nChoose an option");
                    System.out.println("1. Add New Student");
                    System.out.println("2. Remove Student");
                    System.out.println("3. Search Student");
                    System.out.println("4. Display All Students");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter student name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter grade: ");
                            String grade = sc.nextLine();
                            System.out.print("Enter phone number: ");
                            long phone = sc.nextLong();
                            System.out.print("Enter blood group: ");
                            String blood = sc.next();
                            system.addStudent(name, grade, phone, blood);
                            break;
                        case 2:
                            System.out.print("Enter roll number of student to remove: ");
                            int removeRollNumber = sc.nextInt();
                            sc.nextLine(); // Consume newline
                            system.removeStudent(removeRollNumber);
                            System.out.println("Student removed successfully.");
                            break;
                        case 3:
                            System.out.print("Enter roll number of student to search: ");
                            int searchRollNumber = sc.nextInt();
                            sc.nextLine(); // Consume newline
                            Student foundStudent = system.searchStudent(searchRollNumber);
                            if (foundStudent != null) {
                                System.out.println("Student found: " + foundStudent);
                            } else {
                                System.out.println("Student not found.");
                            }
                            break;
                        case 4:
                            System.out.println("All Students:");
                            system.displayAllStudents();
                            break;
                        case 5:
                            System.out.println("Exiting program. Goodbye!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next(); // Clear the invalid input
                }
            }
        }
    }
}

