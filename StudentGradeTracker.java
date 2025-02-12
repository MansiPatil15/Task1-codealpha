import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Welcome to the Student Grade Tracker!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student's grade");
            System.out.println("2. Display all grades");
            System.out.println("3. Calculate average grade");
            System.out.println("4. Find highest and lowest grades");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's grade (0-100): ");
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                    }
                    break;

                case 2:
                    System.out.println("\nAll Grades:");
                    if (grades.isEmpty()) {
                        System.out.println("No grades entered yet.");
                    } else {
                        for (int i = 0; i < grades.size(); i++) {
                            System.out.println("Student " + (i + 1) + ": " + grades.get(i));
                        }
                    }
                    break;

                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades to calculate average.");
                    } else {
                        double average = calculateAverage(grades);
                        System.out.println("Average Grade: " + average);
                    }
                    break;

                case 4:
                    if (grades.isEmpty()) {
                        System.out.println("No grades to find highest and lowest.");
                    } else {
                        int highest = findHighestGrade(grades);
                        int lowest = findLowestGrade(grades);
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to calculate the average of the grades
    private static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    private static int findHighestGrade(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    private static int findLowestGrade(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
