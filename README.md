F2025 MAD204-01 Java Development for MAD

MAD204-01 LAB 1

Name: Darshilkumar Karkar

Student ID: A0203357

Date of Submission: 21/09/2025

LAB 1
Overview
Build a small console app that ties together: classes/objects, methods (with parameters and return values),
user input with Scanner, operators, if/else, switch, loops (for/while/do-while/for-each), type casting,
exceptions, and a touch of recursion.
Scenario
Create a Gradebook & Utilities app with a menu. Users can add students, enter marks, compute
averages/letter grades, and run a few utility demos (operator precedence, casting, recursion counter).
Learning Targets
 Class design, fields, methods, main entry point and printing.
 Input with Scanner, expressions, operator precedence, and basic math.
 Conditionals, string comparison, switch, and all loop types.
 Methods (parameters/returns), recursion, and basic exception handling with try/catch.
Requirements
1) Model a Student Class
a. Fields: String name, int id, double[] grades (size 5).
b. Methods:
i. void setGrade(int index, double value)
ii. double average()
iii. char letterGrade() → A/B/C/D/F using if/else ranges.
iv. String toString() → "ID: 101, Name: Sam, Avg: 86.4 (B)"
2) Main Menu (loop until user chooses Exit)
a. Implement a while(true) or do-while loop that shows:
i. Add student
ii. Enter grades
iii. Show all students
iv. Utilities
v. Exit
b. Parse choice with Scanner. Use a switch on the menu option.
c. Store students in an ArrayList<Student>; when listing, also show per-student average and
letter grade
3) Input Validation
a. Use Scanner for String, int, and double. Handle input mismatch with try/catch and prompt
again.
b. For string equality (e.g., searching by name), use .equals, not == .
4) Utilities submenu
Implement a second switch with:
a. Operator demo: Show 2 + 3 * 4 vs (2 + 3) * 4 and explain result (BODMAS/precedence).
b. Type casting: Safely widen int -> double and narrow double -> int to show truncation.
c. Recursion: countdown(n) that prints n...0 “Done!”. Guard against negatives.
5) Loops coverage
a. for → iterate 0..4 to input the 5 grades for a student.
b. while → menu loop.
c. do-while → ask “Add another student? (y/n)” at least once.
d. for-each → print all student names from an array/list snapshot.
Documentation
When you submit your Java program, include proper documentation. Documentation is part of
programming best practices and will count toward your grade.
 File Header (at the very top of your .java file)
o Include:
 Course code and lab number
 Your full name and Student ID
 Date of Submission
 A short description of what program does.
 Class and Method Comments
o Use /** .... **/ above each class and method to describe its purpose.
o Mention parameters and return values.
 Inline Comments
o Use // to explain tricky or important lines.
o Do not comment every line – just enough to make logic clear.
o
Submission
All work for this lab must be submitted through GitHub. You will practice both coding and professional
collaboration workflows.
1. Create a Repository
a. Go to Github and create a new public repository.
b. Name it : MAD204-LAB01-YOURNAME
c. Add a README.md with:
i. Lab title and your name / ID
ii. A short description of the project
2. Code & Documentation
a. Add your Main.java and Student.java file.
b. Include full documentation:
i. File header ( course, lab, your name, description)
ii. Method/class Javadoc comments
iii. Inline comments for tricky logic.
3. Commit Requirements
a. You must have at least 5 commits.
b. Commits should be meaningful and descriptive (not “update” or “fix”).
4. Pull Request Requirements.
a. You must create at least 3 Pull Requests (PRs), each with a clear title and description.
b. Each PR should represent a logical feature or change. For example:
i. Add Student class and constructors.
ii. Implement Gradebook menu and input handling
iii. Add utilities (operator demo, type casting, recursion)
c. Even if you are working alone, you can:
i. Create a new branch (e.g., feature-student-class)
ii. Push changes
iii. Open a PR into main
iv. Merge it after review (self-review allowed in this case).
5. Final Submission
a. Push your final version to Github.
b. Ensure your repo has:
i. Main.java with complete documentation
ii. At least 5 meaningful commits.
iii. At least 3 merged pull requests.
iv. A README.md explaining your project.
6. What to Submit to Instructor
a. Submit the GitHub Repository link.
b. Make sure the repo is public.
Marking Rubric (25 points)
 Classes & Objects, constructor, toString (4)
 Methods with prams/returns, clean structure (4)
 Input handling + exception safety (3)
 Conditionals + switch correctness (3)
 Loop coverage (for/while/do-while/for-each) (4)
 Recursion utility (2).
 Documentation (3)

 Submission (2)
