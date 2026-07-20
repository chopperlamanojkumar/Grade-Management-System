/**
 * Student.java
 * Stores student information and marks.
 */

public class Student {

    private String name;
    private double[] marks;

    public static final int SUBJECT_COUNT = 5;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = new double[SUBJECT_COUNT];

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            this.marks[i] = marks[i];
        }
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for marks
    public double[] getMarks() {
        return marks;
    }

    // Update marks
    public void setMarks(double[] marks) {
        for (int i = 0; i < SUBJECT_COUNT; i++) {
            this.marks[i] = marks[i];
        }
    }

    // Get mark of a subject
    public double getMark(int subjectIndex) {
        return marks[subjectIndex];
    }

    // Update one subject mark
    public void setMark(int subjectIndex, double mark) {
        marks[subjectIndex] = mark;
    }
}
