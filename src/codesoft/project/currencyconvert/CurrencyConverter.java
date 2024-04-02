package codesoft.project.currencyconvert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import org.json.JSONObject;
import java.util.*;
import java.util.Scanner;

class CurrencyNotFoundException extends Exception {
    public CurrencyNotFoundException(String msg) {
        System.out.println(msg);
    }
}

public class CurrencyConverter {

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.convertCurrency();
    }

    public void convertCurrency() {
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            try {
                System.out.print("Enter the base currency (e.g., USD): ");
                String baseCurrency = sc.nextLine();
                System.out.print("Enter the target currency (e.g., INR): ");
                String targetCurrency = sc.nextLine();
                System.out.print("Enter the amount to convert: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if ((baseCurrency.equals("") || targetCurrency.equals(""))) {
                    throw new CurrencyNotFoundException("Enter a Valid Currency code");
                } else {
                    double exchangeRate = APIIntegration.fetchExchangeRate(baseCurrency, targetCurrency);
                    double convertedAmount = APIIntegration.convertCurrency(amount, exchangeRate);

                    System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
                    System.out.println("Want to Convert once again \n Enter yes or No");
                    ch = sc.nextLine().charAt(0);
                }

            } catch (CurrencyNotFoundException e) {
                e.printStackTrace();
                System.out.println("Please Enter the valid Currency Code \n Re-enter the value \n Enter yes or no");
                ch = sc.nextLine().charAt(0);
            }

        } while (ch == 'Y' || ch == 'y');
    }
}