import java.util.Scanner;

public class GradeManagementSystem {

    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECT_COUNT = 5;

    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    private static final String[] SUBJECTS = {
            "Mathematics",
            "Science",
            "English",
            "History",
            "Computer"
    };

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {

            printMenu();

            int choice = getValidChoice();

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
                    calculateAllAverages();
                    break;

                case 5:
                    showHighestAndLowest();
                    break;

                case 6:
                    ReportGenerator.generateClassReport(students, studentCount);
                    break;

                case 7:
                    exit = true;
                    System.out.println("\nThank you for using Grade Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {

        System.out.println("\n======================================");
        System.out.println("      GRADE MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Calculate Averages");
        System.out.println("5. Highest & Lowest Marks");
        System.out.println("6. Generate Report");
        System.out.println("7. Exit");
        System.out.print("Enter your choice : ");
    }

    private static int getValidChoice() {

        while (true) {

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 7)
                    return choice;

                System.out.print("Enter a number between 1 and 7 : ");

            } catch (NumberFormatException e) {

                System.out.print("Invalid input. Enter a number : ");
            }
        }
    }

        // Add a new student
    private static void addStudent() {

        if (studentCount >= MAX_STUDENTS) {
            System.out.println("\nMaximum student limit reached.");
            return;
        }

        System.out.println("\n========== ADD STUDENT ==========");

        String name;

        while (true) {

            System.out.print("Enter Student Name : ");
            name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                break;
            }

            System.out.println("Student name cannot be empty.");
        }

        double[] marks = new double[SUBJECT_COUNT];

        for (int i = 0; i < SUBJECT_COUNT; i++) {

            marks[i] = getValidMark(SUBJECTS[i]);
        }

        students[studentCount] = new Student(name, marks);

        studentCount++;

        System.out.println("\nStudent added successfully.");
    }

    // View all students
    private static void viewStudents() {

        if (studentCount == 0) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n================ STUDENT RECORDS ================");

        System.out.printf("%-20s %-10s %-10s%n",
                "Student Name",
                "Average",
                "Grade");

        System.out.println("-----------------------------------------------");

        for (int i = 0; i < studentCount; i++) {

            double average =
                    GradeCalculator.calculateAverage(students[i].getMarks());

            String grade =
                    GradeCalculator.getGrade(average);

            System.out.printf("%-20s %-10.2f %-10s%n",
                    students[i].getName(),
                    average,
                    grade);
        }
    }

    // Search student
    private static void searchStudent() {

        if (studentCount == 0) {

            System.out.println("\nNo student records available.");
            return;
        }

        System.out.print("\nEnter student name : ");

        String searchName = scanner.nextLine().trim();

        boolean found = false;

        for (int i = 0; i < studentCount; i++) {

            if (students[i].getName().equalsIgnoreCase(searchName)) {

                GradeCalculator.displayStudentPerformance(students[i]);

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println("Student not found.");
        }
    }

        // Calculate average of every student
    private static void calculateAllAverages() {

        if (studentCount == 0) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== STUDENT AVERAGES ==========");

        for (int i = 0; i < studentCount; i++) {

            double average =
                    GradeCalculator.calculateAverage(students[i].getMarks());

            String grade =
                    GradeCalculator.getGrade(average);

            System.out.printf("%-20s Average : %-8.2f Grade : %s%n",
                    students[i].getName(),
                    average,
                    grade);
        }
    }

    // Display highest and lowest marks
    private static void showHighestAndLowest() {

        if (studentCount == 0) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== HIGHEST & LOWEST MARKS ==========");

        for (int i = 0; i < studentCount; i++) {

            double highest =
                    GradeCalculator.findHighestMark(students[i].getMarks());

            double lowest =
                    GradeCalculator.findLowestMark(students[i].getMarks());

            System.out.printf("%-20s Highest : %-8.2f Lowest : %.2f%n",
                    students[i].getName(),
                    highest,
                    lowest);
        }

        Student topper = ReportGenerator.getTopPerformer(students, studentCount);

        double average =
                GradeCalculator.calculateAverage(topper.getMarks());

        System.out.println("\nTop Performer");

        System.out.println("----------------------------");
        System.out.println("Name    : " + topper.getName());
        System.out.printf("Average : %.2f%n", average);
        System.out.println("----------------------------");
    }

        // Validate marks input
    private static double getValidMark(String subject) {

        while (true) {

            try {

                System.out.print("Enter marks for " + subject + " (0-100): ");

                double mark = Double.parseDouble(scanner.nextLine());

                if (mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.println("Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

}