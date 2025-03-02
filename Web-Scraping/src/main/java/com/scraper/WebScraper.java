package com.scraper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public static List<Product> scrapeProducts(String url) {
        List<Product> productList = new ArrayList<>();

        try {
            // Create a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            reader.close();

            // Parse the JSON response
            JSONArray products = new JSONArray(jsonResponse.toString());
            for (int i = 0; i < products.length(); i++) {
                JSONObject product = products.getJSONObject(i);
                String name = product.getString("title"); // Adjust based on JSON structure
                String price = "N/A"; // Price not available in JSONPlaceholder
                String body = product.getString("body"); // Extract body from JSON

                String rating = product.optString("rating", "No rating"); // Adjust based on JSON structure

                productList.add(new Product(name, price, rating));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

}
