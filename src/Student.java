//MAD204-01 LAB 1
//Student.java
//Name: Darshilkumar Karkar
//Student ID: A00203357
//Date of Submission: 21/09/2025
//A simple Student model for the Gradebook & Utilities app.
//Fields: name, id, grades[5]
//Methods:
//  - setGrade(int index, double value)
//  - average()
//  - letterGrade()
//  - toString()
// Note: grades are 0-100. average() returns a double average across the 5 grades.

//Test change
public class Student {
    public String getName;
    private String name;
    private int id;
    private double[] grades;


    //Create a student with a name and id. Grades default to 0.0.
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new double[5];
        for (int i = 0; i < this.grades.length; i++) {
            this.grades[i] = 0.0;
        }
    }


    //Set a grade at index (0..4).
    public void setGrade(int index, double value) {
        if (index < 0 || index >= grades.length) {
            throw new IllegalArgumentException("Grade index must be between 0 and 4.");
        }
        if (value < 0.0 || value > 100.0) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades[index] = value;
    }

    //Compute average of the 5 grades.
    public double average() {
        double sum = 0.0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }


    //Return letter grade based on average.
    //Ranges:
    //- A: avg >= 90
    //- B: 80 <= avg < 90
    //- C: 70 <= avg < 80
    //- D: 60 <= avg < 70
    //- F: avg < 60
    public char letterGrade() {
        double avg = average();
        if (avg >= 90.0) return 'A';
        else if (avg >= 80.0) return 'B';
        else if (avg >= 70.0) return 'C';
        else if (avg >= 60.0) return 'D';
        else return 'F';
    }

    //String representation required: "ID: 101, Name: Sam, Avg: 86.4 (B)"
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Avg: %.1f (%c)", id, name, average(), letterGrade());
    }

    // Simple getters (used by Main)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double[] getGrades() {
        return grades;
    }
}
