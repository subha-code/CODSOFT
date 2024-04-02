package codesoft.project.markscalculator;

import java.util.*;

public class Main extends StudentGradeCalculator {
    static char button;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to the Student Grade Calculator!");
            System.out.print("Enter the number of subjects: ");
            int numOfSubjects = scanner.nextInt();
            int[] marks = new int[numOfSubjects];

            Main gradeCalculator = new Main();

            int totalMarks = gradeCalculator.inputMarks(scanner, marks);
            double averagePercentage = gradeCalculator.calculateAveragePercentage(totalMarks, numOfSubjects);
            char grade = gradeCalculator.calculateGrade(averagePercentage);
            gradeCalculator.displayResults(totalMarks, averagePercentage, grade);
            System.out.println("Want to add another records! \n Yes: y \n No: n");
            button = scanner.next().charAt(0);

        }while(button == 'y');
    }
}
