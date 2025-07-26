import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String apiKey = "4e38b1f60f4a9d5e1c7c174b";

        System.out.println("Welcome to Real-Time Currency Converter");

        System.out.print("Enter base currency (e.g., USD): ");
        String base = sc.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String target = sc.nextLine().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = sc.nextDouble();

        try
        {
            String apiUrl = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", apiKey, base, target);
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }

            in.close();

            String result = response.toString();
            int rateIndex = result.indexOf("\"conversion_rate\":");
            if (rateIndex != -1)
            {
                String rateStr = result.substring(rateIndex + 18);
                rateStr = rateStr.split(",")[0].replace("}", "").trim();
                double rate = Double.parseDouble(rateStr);

                double convertedAmount = amount * rate;
                System.out.printf("\n%.2f %s = %.2f %s\n", amount, base, convertedAmount, target);
            }
            else
            {
                System.out.println("Failed to get conversion rate.");
            }

        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
