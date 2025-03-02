package com.scraper;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataProcessor {
    public static void saveToCSV(List<Product> products, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"Product Name", "Price", "Rating"};
            writer.writeNext(header);

            for (Product product : products) {
                writer.writeNext(new String[]{product.getName(), product.getPrice(), product.getRating()});
            }
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
