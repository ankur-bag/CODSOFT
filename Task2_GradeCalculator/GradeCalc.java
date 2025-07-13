import java.util.Scanner;

public class GradeCalc
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator");

        System.out.print("Enter the number of subjects: ");
        int sub_count = sc.nextInt();
        sc.nextLine(); 

        String[] subjects = new String[sub_count];
        int[] marks = new int[sub_count];
        int total_marks = 0;

      
        for (int i = 0; i < sub_count; i++)
        {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
        }

        
        for (int i = 0; i < sub_count; i++)
        {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = sc.nextInt();
            total_marks = total_marks + marks[i];
        }

        double avg_percent = (double) total_marks / sub_count;

        char grade;

        if (avg_percent >= 90)
        {
            grade = 'A';
        }
        else if (avg_percent >= 80)
        {
            grade = 'B';
        }
        else if (avg_percent >= 70)
        {
            grade = 'C';
        }
        else if (avg_percent >= 60)
        {
            grade = 'D';
        }
        else
        {
            grade = 'F';
        }

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + total_marks);
        System.out.printf("Average Percentage: %.2f%%\n", avg_percent);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
