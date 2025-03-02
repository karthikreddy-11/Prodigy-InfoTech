package com.scraper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class ScraperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScraperApplication.class, args);
    }

    @Override
    public void run(String... args) {
String url = "https://jsonplaceholder.typicode.com/posts"; // Use the URL for scraping


        List<Product> products = WebScraper.scrapeProducts(url);
        String filePath = "data/scraped_data.csv"; // Specify the file path for saving
        DataProcessor.saveToCSV(products, filePath);
    }
}
