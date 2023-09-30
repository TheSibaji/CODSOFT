package Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course Database
class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;
    private List<String> enrolledStudents;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and setters for course properties

    //If the course is full
    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    // Add new student to the course
    public void enrollStudent(String studentID) {
        enrolledStudents.add(studentID);
    }

    // Remove student
    public void removeStudent(String studentID) {
        enrolledStudents.remove(studentID);
    }
   
    // Get complete info. about course
    public String getCourseInfo() {
        return "Course: " + code + " - " + title + "\nDescription: " + description + "\nCapacity: " + capacity
                + "\nSchedule: " + schedule + "\nEnrolled: " + enrolledStudents.size() + "/" + capacity;
    }

    public Object getCode() {
        return null;
    }
}

// Student Database
class Student {
    private String studentID;
    private String name;
    private List<String> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters for student properties

    // Add new course for the student
    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    // Drop course for the student
    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    // Get all details about student
    public String getStudentInfo() {
        return "Student: " + studentID + " - " + name + "\nRegistered Courses: " + registeredCourses;
    }

    public Object getStudentID() {
        return null;
    }
}
public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n'Student Course Registration System' \nChoose an option by its corresponding number.\n");
                System.out.println("1. Add a Course");
                System.out.println("2. Register a Student");
                System.out.println("3. Enroll a Student in a Course");
                System.out.println("4. Drop a Course for a Student");
                System.out.println("5. View Course Listings");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice;
                try {
                    choice = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine(); // Clear the invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        // Add a course
                        System.out.print("Enter course code: ");
                        String courseCode = sc.nextLine();
                        System.out.print("Enter course title: ");
                        String courseTitle = sc.nextLine();
                        System.out.print("Enter course description: ");
                        String courseDescription = sc.nextLine();
                        int courseCapacity;
                        try {
                            System.out.print("Enter course capacity: ");
                            courseCapacity = sc.nextInt();
                            sc.nextLine(); // Consume the newline character
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input for course capacity. Please enter a number.");
                            sc.nextLine(); // Clear the invalid input
                            continue;
                        }
                        System.out.print("Enter course schedule (start dd/mm/yy, end dd/mm/yy): ");
                        String scheduleInput = sc.nextLine();
                        List<String> schedule = new ArrayList<>();
                        for (String day : scheduleInput.split(",")) {
                            schedule.add(day.trim());
                        }

                        Course newCourse = new Course(courseCode, courseTitle, courseDescription, courseCapacity, schedule);
                        courses.add(newCourse);
                        System.out.println("Course added successfully.");
                        break;

                    case 2:
                        // Register a student
                        System.out.print("Enter student ID: ");
                        String studentID = sc.nextLine();
                        System.out.print("Enter student name: ");
                        String studentName = sc.nextLine();

                        Student newStudent = new Student(studentID, studentName);
                        students.add(newStudent);
                        System.out.println("Student registered successfully.");
                        break;

                    case 3:
                        // Enroll a student in a course
                        System.out.print("Enter student ID: ");
                        String studentIDEnroll = sc.nextLine();
                        System.out.print("Enter course code: ");
                        String courseCodeEnroll = sc.nextLine();

                        Student studentToEnroll = findStudent(students, studentIDEnroll);
                        Course courseToEnroll = findCourse(courses, courseCodeEnroll);

                        if (studentToEnroll != null && courseToEnroll != null) {
                            if (!courseToEnroll.isFull()) {
                                studentToEnroll.registerCourse(courseCodeEnroll);
                                courseToEnroll.enrollStudent(studentIDEnroll);
                                System.out.println("Student enrolled in the course successfully.");
                            } else {
                                System.out.println("Course is already full.");
                            }
                        } else {
                            System.out.println("Student or course not found.");
                        }
                        break;

                    case 4:
                        // Drop a course for a student
                        System.out.print("Enter student ID: ");
                        String studentIDDrop = sc.nextLine();
                        System.out.print("Enter course code: ");
                        String courseCodeDrop = sc.nextLine();

                        Student studentToDrop = findStudent(students, studentIDDrop);
                        Course courseToDrop = findCourse(courses, courseCodeDrop);

                        if (studentToDrop != null && courseToDrop != null) {
                            studentToDrop.dropCourse(courseCodeDrop);
                            courseToDrop.removeStudent(studentIDDrop);
                            System.out.println("Student dropped the course successfully.");
                        } else {
                            System.out.println("Student or course not found.");
                        }
                        break;

                    case 5:
                        // View Course Listings
                        System.out.println("\nCourse Listings:");
                        for (Course course : courses) {
                            System.out.println(course.getCourseInfo());
                            System.out.println();
                        }
                        break;

                    case 6:
                        // Exit
                        System.out.println("Exiting the system.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static Student findStudent(List<Student> students, String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourse(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}