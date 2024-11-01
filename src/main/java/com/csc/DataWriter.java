package com.csc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {
    DataAnalyzer analyzer = new DataAnalyzer();
    
    public void writeData(String results, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName); //write results to output.txt
            writer.write(results);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(List<String[]> results, String fileName) { //overload function
        try {
            FileWriter writer = new FileWriter(fileName); //write results to chosen file
            for (String[] line : results) {
                writer.write(String.join(",", line) + "\n");  //concatenate line into a single string
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
