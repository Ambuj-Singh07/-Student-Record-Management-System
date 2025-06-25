import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Update Student by Roll No");
            System.out.println("5. Delete Student by Roll No");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Exiting Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        students.add(new Student(roll, name, course));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = Integer.parseInt(scanner.nextLine());

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int roll = Integer.parseInt(scanner.nextLine());

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.print("Enter New Name: ");
                s.name = scanner.nextLine();
                System.out.print("Enter New Course: ");
                s.course = scanner.nextLine();
                System.out.println("Student record updated.");
                return;
            }
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = Integer.parseInt(scanner.nextLine());

        for (Student s : students) {
            if (s.rollNo == roll) {
                students.remove(s);
                System.out.println("Student record deleted.");
                return;
            }
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }
}
