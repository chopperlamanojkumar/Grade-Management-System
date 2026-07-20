/**
 * ReportGenerator.java
 * Generates reports and class statistics.
 */

public class ReportGenerator {

    private static final String[] SUBJECTS = {
            "Mathematics",
            "Science",
            "English",
            "History",
            "Computer"
    };

    // Generate complete class report
    public static void generateClassReport(Student[] students, int studentCount) {

        if (studentCount == 0) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== CLASS PERFORMANCE REPORT ==========");

        System.out.println("Total Students : " + studentCount);

        Student topStudent = getTopPerformer(students, studentCount);

        double topAverage = GradeCalculator.calculateAverage(topStudent.getMarks());

        System.out.printf("Top Performer : %s (%.2f%%)%n",
                topStudent.getName(),
                topAverage);

        System.out.println();

        displaySubjectAverages(students, studentCount);

        System.out.println();

        displayGradeDistribution(students, studentCount);

        System.out.println("===============================================");
    }

    // Display average marks of every subject
    public static void displaySubjectAverages(Student[] students, int studentCount) {

        System.out.println("Subject Averages");

        for (int subject = 0; subject < SUBJECTS.length; subject++) {

            double total = 0;

            for (int student = 0; student < studentCount; student++) {
                total += students[student].getMark(subject);
            }

            double average = total / studentCount;

            System.out.printf("%-15s : %.2f%n",
                    SUBJECTS[subject],
                    average);
        }
    }

    // Display grade distribution
    public static void displayGradeDistribution(Student[] students, int studentCount) {

        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeF = 0;

        for (int i = 0; i < studentCount; i++) {

            double average =
                    GradeCalculator.calculateAverage(students[i].getMarks());

            String grade =
                    GradeCalculator.getGrade(average);

            switch (grade) {

                case "A":
                    gradeA++;
                    break;

                case "B":
                    gradeB++;
                    break;

                case "C":
                    gradeC++;
                    break;

                case "D":
                    gradeD++;
                    break;

                default:
                    gradeF++;
            }
        }

        System.out.println("Grade Distribution");

        System.out.println("A Grade : " + gradeA);
        System.out.println("B Grade : " + gradeB);
        System.out.println("C Grade : " + gradeC);
        System.out.println("D Grade : " + gradeD);
        System.out.println("F Grade : " + gradeF);
    }

    // Find top performer
    public static Student getTopPerformer(Student[] students, int studentCount) {

        Student topStudent = students[0];

        double highestAverage =
                GradeCalculator.calculateAverage(topStudent.getMarks());

        for (int i = 1; i < studentCount; i++) {

            double currentAverage =
                    GradeCalculator.calculateAverage(students[i].getMarks());

            if (currentAverage > highestAverage) {

                highestAverage = currentAverage;
                topStudent = students[i];
            }
        }

        return topStudent;
    }
}
