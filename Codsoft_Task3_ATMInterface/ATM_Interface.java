import java.util.Scanner;

public class ATM_Interface
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface");

        System.out.print("Please set your 4-digit PIN: ");
        int user_pin = sc.nextInt();

        System.out.print("Enter your initial balance: Rs.");
        int balance = sc.nextInt();

        System.out.println("Thank you!");

        System.out.print("Do you want to continue? (Y/N): ");
        char proceed = sc.next().charAt(0);

        if (Character.toUpperCase(proceed) != 'Y')
        {
            System.out.println("Session ended. Goodbye!");
            sc.close();
            return;
        }

        System.out.print("Enter your PIN to continue: ");
        int entered_pin = sc.nextInt();

        if (entered_pin != user_pin)
        {
            System.out.println("Incorrect PIN. Access Denied.");
            sc.close();
            return;
        }

        int choice;

        do
        {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Your current balance is: Rs." + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs.");
                    int deposit = sc.nextInt();
                    if (deposit > 0)
                    {
                        balance = balance + deposit;
                        System.out.println("Amount deposited successfully.");
                    }
                    else
                    {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs.");
                    int withdraw = sc.nextInt();
                    if (withdraw > 0 && withdraw <= balance)
                    {
                        balance = balance - withdraw;
                        System.out.println("Please collect your cash.");
                    }
                    else
                    {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 to 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}
