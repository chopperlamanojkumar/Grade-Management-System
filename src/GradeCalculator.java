/**
 * GradeCalculator.java
 * Performs all grade and mark calculations.
 */

public class GradeCalculator {

    // Calculate average marks
    public static double calculateAverage(double[] marks) {
        double sum = 0;

        for (double mark : marks) {
            sum += mark;
        }

        return sum / marks.length;
    }

    // Find highest mark
    public static double findHighestMark(double[] marks) {
        double highest = marks[0];

        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    // Find lowest mark
    public static double findLowestMark(double[] marks) {
        double lowest = marks[0];

        for (double mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    // Calculate total marks
    public static double calculateTotal(double[] marks) {
        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        return total;
    }

    // Return grade based on average
    public static String getGrade(double average) {

        if (average >= 90)
            return "A";

        else if (average >= 80)
            return "B";

        else if (average >= 70)
            return "C";

        else if (average >= 60)
            return "D";

        else
            return "F";
    }

    // Check pass or fail
    public static boolean isPassed(double average) {
        return average >= 40;
    }

    // Display complete student performance
    public static void displayStudentPerformance(Student student) {

        double[] marks = student.getMarks();

        double total = calculateTotal(marks);
        double average = calculateAverage(marks);
        double highest = findHighestMark(marks);
        double lowest = findLowestMark(marks);
        String grade = getGrade(average);

        System.out.println("-------------------------------------------");
        System.out.println("Student Name : " + student.getName());
        System.out.println("Total Marks  : " + total);
        System.out.printf("Average      : %.2f%n", average);
        System.out.println("Highest Mark : " + highest);
        System.out.println("Lowest Mark  : " + lowest);
        System.out.println("Grade        : " + grade);
        System.out.println("Result       : " + (isPassed(average) ? "PASS" : "FAIL"));
        System.out.println("-------------------------------------------");
    }
}