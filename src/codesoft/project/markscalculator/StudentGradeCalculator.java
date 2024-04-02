package codesoft.project.markscalculator;
import codesoft.project.markscalculator.GradeCalculator;
import java.util.*;
class StudentGradeCalculator extends GradeCalculator{

@Override
protected int inputMarks(Scanner scanner, int[] marks) {
    int totalMarks = 0;
    for (int i = 0; i < marks.length; i++) {
        System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
        marks[i] = scanner.nextInt();
        if (marks[i] < 0 || marks[i] > 100) {
            System.out.println("Invalid input! Marks should be between 0 and 100.");
            System.exit(1);
        }
        totalMarks += marks[i];
    }
    return totalMarks;
}
    @Override
    protected double calculateAveragePercentage(int totalMarks, int numOfSubjects) {
        return (double) totalMarks / numOfSubjects;
    }
    @Override
    protected char calculateGrade(double averagePercentage) {
        int gradePercentage = (int) averagePercentage / 10;

        switch (gradePercentage) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }

    @Override
    protected void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\n------ Results ------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }


}
