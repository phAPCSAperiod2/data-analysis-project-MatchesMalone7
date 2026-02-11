import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Main application for the Data Analysis Mini‑Project.
 * Analyzes world indicators data including birth rates and life expectancy.
 */
public class App {

    public static void main(String[] args) {
        // File path to the CSV dataset
        File file = new File(".vscode/WorldIndicators2000 (1).csv");

        // Check if file exists
        if (!file.exists()) {
            System.out.println("Error: File not found at " + file.getAbsolutePath());
            return;
        }

        // Array to store WorldData objects
        WorldData[] worldDataArray = new WorldData[500]; // Buffer size for data
        int dataCount = 0;

        try {
            // Read file using Scanner
            Scanner scanner = new Scanner(file);

            // Skip header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Loop through rows and parse CSV data
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Split by comma
                String[] parts = line.split(",");

                // Extract country, birth rate, and life expectancy
                // Column 0: Country
                // Column 2: Birth Rate
                // Column 15: Life Expectancy Female
                // Column 16: Life Expectancy Male
                
                if (parts.length > 16) {
                    try {
                        String country = parts[0].trim();
                        double birthRate = Double.parseDouble(parts[2].trim());
                        
                        // Use female life expectancy (column 15)
                        double lifeExpectancy = Double.parseDouble(parts[15].trim());

                        // Create new WorldData object
                        WorldData data = new WorldData(country, birthRate, lifeExpectancy);
                        worldDataArray[dataCount] = data;
                        dataCount++;

                    } catch (NumberFormatException e) {
                        // Skip rows with invalid data
                        continue;
                    }
                }
            }

            scanner.close();

            // Resize array to actual size
            WorldData[] finalData = new WorldData[dataCount];
            for (int i = 0; i < dataCount; i++) {
                finalData[i] = worldDataArray[i];
            }

            // Print insights
            System.out.println("=== World Data Analysis ===\n");
            System.out.println("Number of countries loaded: " + dataCount);
            System.out.println();

            // Birth Rate Analysis
            System.out.println("--- Birth Rate Statistics ---");
            System.out.printf("Maximum Birth Rate: %.4f\n", WorldData.maxBirthRate(finalData));
            System.out.printf("Minimum Birth Rate: %.4f\n", WorldData.minBirthRate(finalData));
            System.out.printf("Average Birth Rate: %.4f\n", WorldData.averageBirthRate(finalData));
            System.out.println();

            // Life Expectancy Analysis
            System.out.println("--- Life Expectancy Statistics ---");
            System.out.printf("Maximum Life Expectancy: %.2f years\n", WorldData.maxLifeExpectancy(finalData));
            System.out.printf("Minimum Life Expectancy: %.2f years\n", WorldData.minLifeExpectancy(finalData));
            System.out.printf("Average Life Expectancy: %.2f years\n", WorldData.averageLifeExpectancy(finalData));
            System.out.println();

            // Additional Analysis
            System.out.println("--- Additional Insights ---");
            int highBirthRateCount = WorldData.countBirthRateAbove(finalData, 0.03);
            System.out.println("Countries with birth rate > 0.03: " + highBirthRateCount);
            System.out.println();

            // Comparison Analysis
            System.out.println("--- Birth Rate vs Life Expectancy Comparison ---");
            System.out.println(WorldData.compareBirthRateAndLife(finalData));

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }

}