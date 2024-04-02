package codesoft.project.markscalculator;

import java.util.*;

public abstract class GradeCalculator {
    protected abstract int inputMarks(Scanner scanner, int[] marks);
    protected abstract double calculateAveragePercentage(int totalMarks, int numOfSubjects);
    protected abstract char calculateGrade(double averagePercentage);
    protected abstract void displayResults(int totalMarks, double averagePercentage, char grade);
}

