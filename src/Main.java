//MAD204-01 LAB 1
//Main.java
//Name: Darshilkumar Karkar
//Student ID: A0203357
//Date of Submission: 21/09/2025
//Console Gradebook & Utilities application.
//This class models a Student object for the Gradebook application.
//Each student has an ID, name, and a set of 5 grades. The class provides
//methods to set grades, calculate the average, determine the letter grade,
//and return a formatted string representation of the student.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();

    //in run loop (while -> menu loop).
    public void run() {
        System.out.println("Welcome to Gradebook & Utilities App");
        while (true) {
            printMainMenu();
            int choice = readInt("Enter menu choice: ");
            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    enterGradesMenu();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    utilitiesMenu();
                    break;
                case 5:
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Choose 1-5.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1) Add student");
        System.out.println("2) Enter grades");
        System.out.println("3) Show all students");
        System.out.println("4) Utilities");
        System.out.println("5) Exit");
    }



    //Add student: uses do-while to allow adding multiple students.
    private void addStudentMenu() {
        do {
            String name = readNonEmptyString("Enter student name: ");
            int id = readInt("Enter student ID (numeric): ");
            if (findStudentById(id) != null) {
                System.out.println("A student with that ID already exists. Try again.");
                continue; // skip adding, loop again
            }
            Student s = new Student(name, id);
            students.add(s);
            System.out.println("Added: " + s);
        } while (readYesNo("Add another student? (y/n): "));
    }

    //Enter 5 grades for a selected student (for loop handles 5 entries).
    private void enterGradesMenu() {
        if (students.isEmpty()) {
            System.out.println("No students available. Add a student first.");
            return;
        }

        printStudentListBrief();
        int id = readInt("Enter the student ID to enter grades for: ");
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Entering 5 grades for: " + s.getName());
        for (int i = 0; i < 5; i++) {
            double g = readDouble(String.format("Grade %d (0-100): ", i + 1));
            try {
                s.setGrade(i, g);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid grade/index: " + e.getMessage());
                i--; // repeat this index
            }
        }
        System.out.println("Updated student: " + s);
    }


    //Show all students (for-each demo)
    private void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
            return;
        }
        System.out.println("\n--- All Students ---");
        // for-each loop used here to print student info
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    private void printStudentListBrief() {
        System.out.println("\nStudents (ID - Name):");
        for (Student s : students) {
            System.out.printf("%d - %s\n", s.getId(), s.getName());
        }
    }

    //Utilities submenu with its own switch.
    private void utilitiesMenu() {
        while (true) {
            System.out.println("\n--- UTILITIES ---");
            System.out.println("1) Operator demo");
            System.out.println("2) Type casting demo");
            System.out.println("3) Recursion demo (countdown)");
            System.out.println("4) For-each demo (print just names)");
            System.out.println("5) Back to main menu");
            int choice = readInt("Choice: ");
            switch (choice) {
                case 1:
                    operatorDemo();
                    break;
                case 2:
                    typeCastingDemo();
                    break;
                case 3:
                    recursionDemo();
                    break;
                case 4:
                    forEachNamesDemo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid utility choice.");
            }
        }
    }

    private void operatorDemo() {
        int a = 2, b = 3, c = 4;
        int result1 = a + b * c;         // 2 + (3*4) = 14
        int result2 = (a + b) * c;       // (2+3)*4 = 20
        System.out.println("Operator demo:");
        System.out.printf("2 + 3 * 4 = %d  (because * has higher precedence than +)\n", result1);
        System.out.printf("(2 + 3) * 4 = %d  (parentheses change evaluation order)\n", result2);
    }

    private void typeCastingDemo() {
        int i = 7;
        double widened = i; // widening (safe)
        double d = 7.9;
        int narrowed = (int) d; // narrowing/truncation
        System.out.println("Type casting demo:");
        System.out.println("int 7 widened to double => " + widened);
        System.out.println("double 7.9 narrowed to int => " + narrowed + " (fraction truncated)");
    }

    private void recursionDemo() {
        int n = readInt("Enter a non-negative integer to countdown from: ");
        if (n < 0) {
            System.out.println("Negative value not allowed for countdown.");
            return;
        }
        System.out.println("Countdown:");
        countdown(n);
        System.out.println("Done!");
    }

    //Recursive countdown method. Guard against negative by caller.
    private void countdown(int n) {
        System.out.println(n);
        if (n == 0) return;
        countdown(n - 1);
    }

    private void forEachNamesDemo() {
        System.out.println("For-each demo: student names:");
        for (Student s : students) {
            System.out.println("- " + s.getName);
        }
    }

    // -----------------------
    // Helper / Input methods
    // -----------------------

    //Read integer safely (handles non-integer input).
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer; please try again.");
            }
        }
    }

    //Read double safely (handles non-double input).
    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number; please try again.");
            }
        }
    }

    //Read non-empty string.
    private String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty.");
        }
    }

    //Read yes/no, returns true for 'y' or 'Y'.
    private boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("y") || line.equals("yes")) return true;
            if (line.equals("n") || line.equals("no")) return false;
            System.out.println("Enter 'y' or 'n'.");
        }
    }

    //Find a student by numeric id.
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
