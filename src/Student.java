//MAD204-01 LAB 1
//Student.java
//Name: Darshilkumar Karkar
//Student ID: A00203357
//Date of Submission: 21/09/2025
//
//This class represents a single student in the Gradebook & Utilities app.
// Each student has a name, an ID number, and 5 grades.
// The class can calculate the student's average, assign a letter grade,
// and print out a summary of their info in a nice format.


public class Student {
    //This field seems incorrect: `getName` should probably be a method, not a variable.
    // Leaving it here for now, but in real cleanup we’d remove or fix it.
    public String getName;
    // Core information about a student
    private String name;              // Student’s name
    private int id;                   // Unique student ID
    private double[] grades;          // Array of 5 grades (default 0.0)

    // Constructor: when creating a new student, we pass in their name and ID.
    // Grades array is initialized with 5 slots, all starting at 0.
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new double[5];
        for (int i = 0; i < this.grades.length; i++) {
            this.grades[i] = 0.0;
        }
    }

    // Assigns a grade to a specific position in the grades array (0–4).
    // We validate both the index (must be within array) and the grade value (0–100).
    public void setGrade(int index, double value) {
        if (index < 0 || index >= grades.length) {
            throw new IllegalArgumentException("Grade index must be between 0 and 4.");
        }
        if (value < 0.0 || value > 100.0) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades[index] = value;
    }

    // Calculates the average across the 5 grades.
    // Even if some grades are still 0, they’re factored into the average.
        public double average() {
        double sum = 0.0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }

    // Converts the numeric average into a letter grade.
    // Uses standard grading scale:
    // A (90+), B (80–89), C (70–79), D (60–69), F (<60).
    public char letterGrade() {
        double avg = average();
        if (avg >= 90.0) return 'A';
        else if (avg >= 80.0) return 'B';
        else if (avg >= 70.0) return 'C';
        else if (avg >= 60.0) return 'D';
        else return 'F';
    }

    // Nicely formatted summary of the student’s info.
    // Example: "ID: 101, Name: Sam, Avg: 86.4 (B)"
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Avg: %.1f (%c)", id, name, average(), letterGrade());
    }

    // Getter methods so other classes (like Main) can safely access fields.
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Returns the full grades array if needed.
    // Note: exposes internal array directly (could be risky in real-world apps).
    public double[] getGrades() {
        return grades;
    }
}
