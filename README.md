[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22617052)
# AP CSA Mini‑Project: Data Analysis with Arrays & File Input
### Using CSV Files • Arrays of Objects • Algorithms • Data Ethics & Quality

---

## 📌 Project Overview
In this mini‑project, you will choose a dataset (CSV file), design a **custom class** to represent each row, read the dataset using the **Scanner** class, store all data as **objects** in an ArrayList or array, and answer a **guiding question** by analyzing the data.

This project reinforces:

- Arrays & ArrayLists  
- File input with `Scanner`  
- Class design (attributes, constructors, methods)  
- Algorithms (min, max, average, filtering)  
- Data quality & ethics  
- Documentation using **Javadoc**  
- Creating a **UML class diagram**  

By the end, you will produce insights and answer your original question using your program.

---

## 🎯 Your Task
You will:

1. **Choose a dataset** (teacher provided or public).  
2. **Write a guiding question** for your dataset.  
3. **Design a Java class** with ≥ 3 attributes.  
4. **Use `Scanner` to read a CSV file**, parse rows, and construct objects.  
5. **Store all objects** in an array or ArrayList.  
6. **Analyze the dataset** using algorithms you create.  
7. **Print insights** and answer your guiding question.  
8. **Document your code** with Javadoc.  
9. **Create a UML class diagram** representing your custom class.  

Optional stretch challenges are included at the bottom!

---

## 🧪 Example Questions You Might Ask
Your dataset might allow you to answer things like:

- *"Which Pokémon type has the highest average Attack?"*  
- *"Which U.S. state had the lowest obesity rate in 2020?"*  
- *"What country had the highest CO₂ emissions in 2000?"*  
- *"What is the average HP for Fire-type Pokémon?"*  

Think simple, clear, and answerable.

---

## 📁 Project Structure
Your repository should follow this structure:
```
/src
    App.java
    WorldData.java
/data
    WorldIndicators2000 (1).csv
README.md   ← this file
UML_Diagram.png (or UML_Diagram.pdf)
```

---

## 🧩 Step 1 — Choose Your Dataset

**Dataset Name:**  
World Indicators 2000 (birth rate & life expectancy)

**Source / Link:**  
Teacher‑provided CSV located at `.vscode/WorldIndicators2000 (1).csv`  
(typically derived from a public world indicators dataset)

**What this dataset contains (2–3 sentences):**  
Each row corresponds to a country and includes a variety of demographic indicators for the year 2000.  
For this project we extract the country name, birth rate, and life‑expectancy.

---

## ❓ Step 2 — Write Your Guiding Question

Your guiding question should be something you can answer using your dataset.

**My guiding question:**  
What are the minimum, maximum, and average birth rates and life expectancies for countries in the dataset,  

---

## 🧱 Step 3 — Design Your Class

You must create a class that represents **one row** of your dataset.

### ✔ Your class must include:

- **At least 3 private attributes**  
- **A constructor** that takes all attributes as parameters  
- **Getter methods** for attributes you plan to analyze  
- **`toString()`** for easy printing  
- Any additional analysis/helper methods as needed  

### ✏ Include your class diagram

```
classDiagram
    class WorldData {
        - String country
        - double birthRate
        - double lifeExpectancy
        + WorldData(String country, double birthRate, double lifeExpectancy)
        + String getCountry()
        + double getBirthRate()
        + double getLifeExpectancy()
        + static double maxBirthRate(WorldData[] data)
        + static double minBirthRate(WorldData[] data)
        + static double averageBirthRate(WorldData[] data)
        + static double maxLifeExpectancy(WorldData[] data)
        + static double minLifeExpectancy(WorldData[] data)
        + static double averageLifeExpectancy(WorldData[] data)
        + static int countBirthRateAbove(WorldData[] data, double threshold)
        + static String compareBirthRateAndLife(WorldData[] data)
        + String toString()
    }
```


---<img width="612" height="333" alt="MAPS drawio" src="https://github.com/user-attachments/assets/fff2eec1-560e-4b70-a8d2-2ad3f95368e2" />


## 📥 Step 4 — Read Your CSV File Using Scanner

In `App.java`, you must:

- Create a `File` object  
- Use `Scanner` to read the file  
- Skip the header row (if needed)  
- Read each line  
- Split by commas using `.split(",")`  
- Trim whitespace  
- Parse numbers using `Integer.parseInt()` or `Double.parseDouble()`  
- Construct objects  
- Add them to an ArrayList or array  

### Column → Attribute Map

| Attribute Name      | CSV Column Name         | Column Index # | Notes                          |
|---------------------|-------------------------|----------------|--------------------------------|
| country             | Country                 | 0              | `string`                           |
| birthRate           | Birth Rate              | 2       `double`             |
| lifeExpectancy      | Life Expectancy         | 15             | `double`; |

---

## 📊 Step 5 — Analyze Your Data

You must write **at least two algorithms** to analyze your dataset.

### Required: Choose 2 or more algorithms
- [x] Minimum value of attribute  
- [x] Maximum value of attribute  
- [x] Average of attribute  
- [ ] Filter by category  
- [x] Count items matching a condition  

**Algorithms I will implement:**

1. `maxBirthRate`, `minBirthRate`, `averageBirthRate` (and same for life expectancy)  
2. `countBirthRateAbove(data, 0.03)` + `compareBirthRateAndLife(data)`

Optional extras:  
- Sorting  
- Top/bottom N items  
- Grouping by category  
- Comparison between groups  

---

## 🧠 Step 6 — Insights & Answer to Your Question

After analyzing your objects, print:

- ✔ How many rows were loaded  
- ✔ Your algorithm results  
- ✔ A clear answer to your guiding question  

**My findings:**  
- Loaded **`dataCount`** countries (actual number depends on CSV).  
- Birth rate statistics:  
  - max = `WorldData.maxBirthRate(finalData)`  
  - min = `WorldData.minBirthRate(finalData)`  
  - avg = `WorldData.averageBirthRate(finalData)`  
- Life expectancy statistics:  
  - max = `WorldData.maxLifeExpectancy(finalData)`  
  - min = `WorldData.minLifeExpectancy(finalData)`  
  - avg = `WorldData.averageLifeExpectancy(finalData)`  
- There are `WorldData.countBirthRateAbove(finalData, 0.03)` countries with birth rate > 0.03.  
- Comparison: birth rate higher vs life expectancy higher counts reported by `compareBirthRateAndLife`.

*(The program prints the actual numerical values when run.)*

**My answer to the guiding question:**  
The dataset contains a wide range of birth rates and life expectancies; the computed min, max, and average 
values quantify that spread. Only a handful of countries exceed a birth rate of 0.03, and in virtually 
every country life expectancy is numerically higher than birth rate (as the comparison method shows).

---

## 📝 Step 7 — Documentation Requirements

### ✔ Javadoc Comments
You MUST use Javadoc for:

- Every **class**  
- Every **method**  
- Every **parameter**  
- Every **return value**  

Example:
```java
/**
 * Returns the highest HP among all Pokémon.
 * @param list the ArrayList of Pokémon objects
 * @return highest HP value in the dataset
 */
public static int findMaxHP(ArrayList<Pokemon> list) {
    // implementation
}
```

### ✔ UML Class Diagram
Add a UML diagram showing:

- Class name
- Attributes
- Methods
- Visibility (private/public)

Save as `UML_Diagram.png` or `.pdf` in the repo.

---

## 🛡 Step 8 — Data Ethics & Quality Reflection
Write a short reflection (3–5 sentences):

- What data-quality issues did you find?
- Could your dataset be biased?
- How might incomplete or inaccurate data affect results?
- How trustworthy are your insights?

**My reflection:**  
The CSV has many blank or malformed rows that are skipped by the scanner, which illustrates data‑quality 
issues; the analysis ignores those entries.  The selection of indicators (female life expectancy only) 
is biased and doesn’t represent males or overall averages.  Missing countries or incorrect birth‑rate values 
would skew the statistics, so results should be considered approximations.  I would not claim broad 
global conclusions without verifying and cleaning the source dataset first.

---

## ⭐ Optional Challenges (Not Required but Fun!)

### 🔹 User Input
Allow the user to choose:

- Which attribute to analyze
- Which category to filter
- What statistics they want to calculate

### 🔹 Additional Algorithms

- Sorting objects
- Multiple comparisons
- Generating summaries
- Exporting results to a file

### 🔹 Data Cleaning

- Skip rows with missing values
- Detect invalid entries
- Normalize units

---

## ✅ Submission Checklist

- [x] Dataset selected  
- [x] Guiding question written  
- [x] Class created with ≥3 attributes  
- [x] File reading implemented  
- [x] ArrayList/array of objects created  
- [x] At least 2 analysis algorithms implemented  
- [x] Findings printed  
- [x] Javadoc comments added  
- [x] UML diagram included  
- [x] Reflection completed  
- [x] Code compiles & runs

---

Good luck, and have fun exploring your dataset! 🚀  
You're now doing real data analysis — just like professional software engineers.

<img width="612" height="333" alt="MAPS drawio" src="https://github.com/user-attachments/assets/c40afd48-a8a0-48f2-a642-09a581cfbce1" />
