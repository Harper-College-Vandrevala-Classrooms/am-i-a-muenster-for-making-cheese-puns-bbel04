package com.csc;

//import java.io.BufferedReader;

import java.util.List;

public class CheeseAnalyzer {
  public static void main(String[] args) {
    ReadCSV reader = new ReadCSV();   //object from open csv library
    DataAnalyzer analyzer = new DataAnalyzer();
    DataWriter writer = new DataWriter();

    //store lines read from data set in String List
    List<String[]> records = reader.readData("cheese_data.csv");
    List<String[]> recordsWithoutHeader = records.subList(1, records.size());

    //read and analyze dataset
    analyzer.analyzeData(records);

    StringBuilder cheeseAnalysis = new StringBuilder();

    cheeseAnalysis.append("\nNumber of Cheeses with Pasteurized Milk Treatment: " + analyzer.pasteurizedCounter);
    cheeseAnalysis.append("\nNumber of Cheeses with Raw Milk Treatment: " + analyzer.rawMilkCounter);
    cheeseAnalysis.append("\nNumber of Organic Cheeses with a Moisture Percentage Greater Than 41%: " + analyzer.organicMoistCounter);
    cheeseAnalysis.append("\nNumber of Cheeses produced with cow milk: " + analyzer.animalMilk[0]);
    cheeseAnalysis.append("\nNumber of Cheeses produced with goat milk: " + analyzer.animalMilk[1]);
    cheeseAnalysis.append("\nNumber of Cheeses produced with ewe milk: " + analyzer.animalMilk[2]);
    cheeseAnalysis.append("\nNumber of Cheeses produced with buffalo milk: " + analyzer.animalMilk[3]);
    cheeseAnalysis.append("\nNumber of Lactic Cheeses: " + analyzer.lacticCounter);  //add lactic cheese info to output file

    switch (analyzer.mostCommonAnimal) {
      case 0:
        cheeseAnalysis.append("\nThe most common animal milk used for cheeses produced in Canada is Cow Milk");
        break;
      case 1:
        cheeseAnalysis.append("\nThe most common animal milk used for cheeses produced in Canada is Goat Milk");
        break;
      case 2:
        cheeseAnalysis.append("\nThe most common animal milk used for cheeses produced in Canada is Ewe Milk");
        break;
      case 3:
        cheeseAnalysis.append("\nThe most common animal milk used for cheeses produced in Canada is Buffalo Milk");
        break;
      default:
        cheeseAnalysis.append("\nNo particular animal milk type is most common");
        break;
    }
    System.out.println(cheeseAnalysis);

    //write results to file
    writer.writeData(cheeseAnalysis.toString(), "output.txt");    

    writer.writeData(recordsWithoutHeader, "cheese_without_headers.csv"); //write data without headers to new csv file
  }
}
