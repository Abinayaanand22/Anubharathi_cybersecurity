import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    int rollNo;
    String name;
    int age;
    String course;

    // Constructor
    Student(int rollNo, String name, int age, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display Method
    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
        System.out.println("----------------------------");
    }
}

// Main Management System Class
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(rollNo, name, age, course));
        System.out.println("✅ Student added successfully!\n");
    }

    // View Students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ No students found.\n");
            return;
        }

        System.out.println("\n📋 Student List:\n");
        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    public static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("\n✅ Student Found:\n");
                s.display();
                return;
            }
        }
        System.out.println("❌ Student not found.\n");
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Enter new details:");

                System.out.print("New Name: ");
                s.name = sc.nextLine();

                System.out.print("New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("New Course: ");
                s.course = sc.nextLine();

                System.out.println("✅ Student updated successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found.\n");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == rollNo) {
                students.remove(s);
                System.out.println("✅ Student deleted successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found.\n");
    }

    // Main Method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== STUDENT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

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
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("👋 Exiting program...");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 6);
    }
}
