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
        // Start the program by creating an instance and running it
        new Main().run();
    }

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Student> students = new ArrayList<>();

    // Main loop that shows the menu and keeps running until user exits
    public void run() {
        System.out.println("Welcome to Gradebook & Utilities App");
        while (true) {
            printMainMenu();
            int choice = readInt("Enter menu choice: ");
            switch (choice) {
                case 1:     // add new students
                    addStudentMenu();
                    break;
                case 2:     // input grades for a student
                    enterGradesMenu();
                    break;
                case 3:     // display all students
                    showAllStudents();
                    break;
                case 4:     // open extra utilities/demos
                    utilitiesMenu();
                    break;
                case 5:     //exit program
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Choose 1-5.");
            }
        }
    }
    // Shows the available main menu options
    private void printMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1) Add student");
        System.out.println("2) Enter grades");
        System.out.println("3) Show all students");
        System.out.println("4) Utilities");
        System.out.println("5) Exit");
    }



    // Menu for adding one or multiple students
    private void addStudentMenu() {
        do {
            String name = readNonEmptyString();
            int id = readInt("Enter student ID (numeric): ");
            // Prevent duplicates by checking if this ID is already in use
            if (findStudentById(id) != null) {
                System.out.println("A student with that ID already exists. Try again.");
                continue; // skip adding, loop again
            }
            // Create a new student and add them to the list
            Student s = new Student(name, id);
            students.add(s);
            System.out.println("Added: " + s);
        } while (readYesNo());
    }

    // Allows the user to pick a student and enter 5 grades for them
    private void enterGradesMenu() {
        if (students.isEmpty()) {
            System.out.println("No students available. Add a student first.");
            return;
        }

        // Show students in short form so user can choose
        printStudentListBrief();
        int id = readInt("Enter the student ID to enter grades for: ");
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Entering 5 grades for: " + s.getName());
        // Force exactly 5 grades
        for (int i = 0; i < 5; i++) {
            double g = readDouble(String.format("Grade %d (0-100): ", i + 1));
            try {
                s.setGrade(i, g);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid grade/index: " + e.getMessage());
                i--; // retry this slot if input was invalid
            }
        }
        System.out.println("Updated student: " + s);
    }


    // Prints details of every student currently stored
    private void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
            return;
        }
        System.out.println("\n--- All Students ---");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
    // Show only ID and name (used in grade entry selection)
    private void printStudentListBrief() {
        System.out.println("\nStudents (ID - Name):");
        for (Student s : students) {
            System.out.printf("%d - %s\n", s.getId(), s.getName());
        }
    }

    // Submenu with fun demos like operators, type casting, recursion
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
                    return;   // go back to main menu
                default:
                    System.out.println("Invalid utility choice.");
            }
        }
    }

    // Simple arithmetic example showing operator precedence
    private void operatorDemo() {
        int a = 2, b = 3, c = 4;
        int result1 = a + b * c;         // 2 + (3*4) = 14  // * happens before +
        int result2 = (a + b) * c;       // (2+3)*4 = 20    // parentheses change order
        System.out.println("Operator demo:");
        System.out.printf("2 + 3 * 4 = %d  (because * has higher precedence than +)\n", result1);
        System.out.printf("(2 + 3) * 4 = %d  (parentheses change evaluation order)\n", result2);
    }

    // Example of widening and narrowing type casts
    private void typeCastingDemo() {
        int i = 7;
        double widened = i;              // safe conversion
        double d = 7.9;
        int narrowed = (int) d;         // fractional part lost
        System.out.println("Type casting demo:");
        System.out.println("int 7 widened to double => " + widened);
        System.out.println("double 7.9 narrowed to int => " + narrowed + " (fraction truncated)");
    }

    // Countdown example using recursion
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

    // Recursive helper for countdown
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

    // Safely reads an int, keeps asking until valid
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

    // Safely reads a double, keeps asking until valid
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

    // Ensures input is not empty
    private String readNonEmptyString() {
        while (true) {
            System.out.print("Enter student name: ");
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty.");
        }
    }

    // Reads yes/no input and returns boolean
    private boolean readYesNo() {
        while (true) {
            System.out.print("Add another student? (y/n): ");
            String line = scanner.nextLine().trim().toLowerCase();
            if (line.equals("y") || line.equals("yes")) return true;
            if (line.equals("n") || line.equals("no")) return false;
            System.out.println("Enter 'y' or 'n'.");
        }
    }

    // Finds a student by their unique ID
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
