import java.util.ArrayList;
import java.util.Scanner;
import java.io;
1st line

// Student Class
class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void displayStudent() {
        System.out.println("-------------------------------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);
        System.out.println("-------------------------------------------------");
    }
}

// Main Class
public class StudentManagementSystem {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 5);
    }

    // Add Student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, age, course, marks);
        studentList.add(student);

        System.out.println("Student Added Successfully!");
    }

    // View All Students
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student student : studentList) {
            student.displayStudent();
        }
    }

    // Search Student
    private static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        int id = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getId() == id) {
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = scanner.nextInt();

        Student studentToRemove = null;

        for (Student student : studentList) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }
}
