import java.util.Scanner;

public class CurrencyConverter
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter");

        System.out.print("Enter amount in Rs.: ");
        double amount_in_rs = sc.nextDouble();

        System.out.println("\nSelect currency to convert into:");
        System.out.println("1. US Dollar (USD)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. British Pound (GBP)");
        System.out.println("4. Japanese Yen (JPY)");
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        double converted = 0;
        String currency = "";

        switch (choice)
        {
            case 1:
                converted = amount_in_rs / 83.00;
                currency = "USD";
                break;

            case 2:
                converted = amount_in_rs / 90.00;
                currency = "EUR";
                break;

            case 3:
                converted = amount_in_rs / 105.00;
                currency = "GBP";
                break;

            case 4:
                converted = amount_in_rs / 0.58;
                currency = "JPY";
                break;

            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        System.out.printf("\nRs. %.2f = %.2f %s\n", amount_in_rs, converted, currency);

        sc.close();
    }
}
