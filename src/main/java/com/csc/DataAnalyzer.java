package com.csc;

import java.util.List;
import java.util.regex.Matcher;  //add new regex import
import java.util.regex.Pattern;  //add new regex import

public class DataAnalyzer {
    int pasteurizedCounter = 0;
    int rawMilkCounter = 0;
    int organicMoistCounter = 0;
    int lacticCounter = 0;   // lactic counter
    int[] animalMilk = new int[]{0,0,0,0};
    int mostCommonAnimal = animalMilk[0];

    public void analyzeData(List<String[]> records) {
        for (String[] values : records) {

            Pattern pattern = Pattern.compile("lactic", Pattern.CASE_INSENSITIVE); //look for pattern "lactic"
            Matcher matcher = pattern.matcher(values[4]);  //look for match in values[4], FlavourEn

            boolean lacticFound = matcher.find();   
            if (lacticFound) {
                lacticCounter++;  //increment lactic counter if "lactic" is found in FlavorEn
            }

            if (values[6].equals("1") && !values[3].isEmpty()) {
                if (Double.parseDouble(values[3]) > 41.0) {
                  organicMoistCounter++;
                }
            }
      
            //determine milk treatment type
            if (values[9].equals("Pasteurized")) {
                pasteurizedCounter++;
            }
            else if (values[9].equals("Raw Milk")) {
                rawMilkCounter++;
            }
              
            //determine animal milk type
            if (values[8].equals("Cow")) {
                animalMilk[0]++;
            }
            else if (values[8].equals("Goat")) {
                animalMilk[1]++;
            }
            else if (values[8].equals("Ewe")) {
                animalMilk[2]++;
            }
            else if (values[8].equals("Buffalo Cow")) {
                animalMilk[3]++;
            }
        }
        mostCommonAnimal = getMostCommonAnimal();
    }

    private int getMostCommonAnimal() { //determine counter with greatest value
        int max = 0;
        for (int i = 1; i < animalMilk.length; i++) {
            if (animalMilk[i] > animalMilk[max]) {
              max = i;
            }
        }
        return max;
    }
}
