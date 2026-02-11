/**
 * Represents one row from your dataset.
 *
 * TODO:
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat)
 *  - Add at least 3 private attributes based on your CSV columns
 *  - Write a constructor that initializes all attributes
 *  - Add getter methods for the attributes you need in your analysis
 *  - Override toString() to display the object's data
 *  - Add Javadoc comments for the class and all methods
 */
public class WorldData {

    /**
     * The name of the country
     */
    private String country;

    /**
     * The birth rate of the country
     */
    private double birthRate;

    /**
     * The life expectancy of the country
     */
    private double lifeExpectancy;

    /**
     * Constructor that initializes all attributes
     * 
     * @param country the name of the country
     * @param birthRate the birth rate of the country
     * @param lifeExpectancy the life expectancy of the country
     */
    public WorldData(String country, double birthRate, double lifeExpectancy) {
        this.country = country;
        this.birthRate = birthRate;
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Gets the country name
     * 
     * @return the country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the birth rate
     * 
     * @return the birth rate
     */
    public double getBirthRate() {
        return birthRate;
    }

    /**
     * Gets the life expectancy
     * 
     * @return the life expectancy
     */
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Finds the maximum birth rate from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the maximum birth rate
     */
    public static double maxBirthRate(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double max = data[0].birthRate;
        for (WorldData d : data) {
            if (d.birthRate > max) {
                max = d.birthRate;
            }
        }
        return max;
    }

    /**
     * Finds the minimum birth rate from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the minimum birth rate
     */
    public static double minBirthRate(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double min = data[0].birthRate;
        for (WorldData d : data) {
            if (d.birthRate < min) {
                min = d.birthRate;
            }
        }
        return min;
    }

    /**
     * Calculates the average birth rate from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the average birth rate
     */
    public static double averageBirthRate(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double sum = 0;
        for (WorldData d : data) {
            sum += d.birthRate;
        }
        return sum / data.length;
    }

    /**
     * Finds the maximum life expectancy from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the maximum life expectancy
     */
    public static double maxLifeExpectancy(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double max = data[0].lifeExpectancy;
        for (WorldData d : data) {
            if (d.lifeExpectancy > max) {
                max = d.lifeExpectancy;
            }
        }
        return max;
    }

    /**
     * Finds the minimum life expectancy from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the minimum life expectancy
     */
    public static double minLifeExpectancy(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double min = data[0].lifeExpectancy;
        for (WorldData d : data) {
            if (d.lifeExpectancy < min) {
                min = d.lifeExpectancy;
            }
        }
        return min;
    }

    /**
     * Calculates the average life expectancy from an array of WorldData objects
     * 
     * @param data the array of WorldData objects
     * @return the average life expectancy
     */
    public static double averageLifeExpectancy(WorldData[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        double sum = 0;
        for (WorldData d : data) {
            sum += d.lifeExpectancy;
        }
        return sum / data.length;
    }

    /**
     * Returns a string representation of the WorldData object
     * 
     * @return a formatted string with country, birth rate, and life expectancy
     */
    @Override
    public String toString() {
        return "Country: " + country + ", Birth Rate: " + birthRate + ", Life Expectancy: " + lifeExpectancy;
    }

    /**
    * Counts how many WorldData objects have a birth rate above a given value
    *
    * @param data the array of WorldData objects
    * @param threshold the minimum birth rate to count
    * @return how many objects meet the condition
    */
    public static int countBirthRateAbove(WorldData[] data, double threshold) {
        if (data == null || data.length == 0) {
            return 0;
        }

        int count = 0;
        for (WorldData d : data) {
            if (d.getBirthRate() > threshold) {
                count++;
            }
        }
        return count;
    }

    /**
    * Compares birth rate and life expectancy for each country
    * Counts how many times birth rate is higher vs. life expectancy
    *
    * @param data the array of WorldData objects
    * @return a formatted summary of the comparison
    */
    public static String compareBirthRateAndLife(WorldData[] data) {
        if (data == null || data.length == 0) {
            return "No data available.";
        }

        int birthHigher = 0;
        int lifeHigher = 0;

        for (WorldData d : data) {
            if (d.getBirthRate() > d.getLifeExpectancy()) {
                birthHigher++;
            } else if (d.getLifeExpectancy() > d.getBirthRate()) {
                lifeHigher++;
            }
        }

        return "Birth rate higher: " + birthHigher +
            "\nLife expectancy higher: " + lifeHigher;
    }

}