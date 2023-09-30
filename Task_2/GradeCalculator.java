package Task_2;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of subjects: ");
        int numSubjects = sc.nextInt();

        int marks[] = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
        String grade = assignGrade(averagePercentage);

        System.out.println("\nYour Total Marks: " + totalMarks);
        System.out.println("Your Average Percentage: " + averagePercentage + "%");
        System.out.println("Your Grade: " + grade);
        
        sc.close();
    }

    public static String assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 45) {
            return "C";
        } else if (averagePercentage >= 30) {
            return "D";
        } else {
            return "F";
        }
    }
}

