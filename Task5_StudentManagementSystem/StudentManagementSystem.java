import java.util.*;

public class StudentManagementSystem
{
    static class Student
    {
        String name;
        int roll;
        String course;

        Student(String name, int roll, String course)
        {
            this.name = name;
            this.roll = roll;
            this.course = course;
        }

        void display()
        {
            System.out.println("Name   : " + name);
            System.out.println("Roll   : " + roll);
            System.out.println("Course : " + course);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        boolean running = true;

        System.out.println("Welcome to the Student Management System");

        while (running)
        {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice)
            {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    studentList.add(new Student(name, roll, course));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (studentList.isEmpty())
                    {
                        System.out.println("No students found.");
                    }
                    else
                    {
                        System.out.println("Student List:");
                        for (Student s : studentList)
                        {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;

                    for (Student s : studentList)
                    {
                        if (s.roll == searchRoll)
                        {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = sc.nextInt();
                    boolean removed = studentList.removeIf(s -> s.roll == deleteRoll);

                    if (removed)
                        System.out.println("Student deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
