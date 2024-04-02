package codesoft.project.currencyconvert;

//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIIntegration extends CurrencyConverter{
    private static final String API_KEY = "a0174065dbc9ed9964f3c418";
    public static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        double exchangeRate = 0;
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

//            JSONObject jsonResponse = new JSONObject(response.toString());
//            exchangeRate = jsonResponse.getJSONObject("conversion_rates").getDouble(targetCurrency);
//
//            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRate;
    }
    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
