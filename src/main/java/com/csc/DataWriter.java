package com.csc;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    DataAnalyzer analyzer = new DataAnalyzer();
    
    public void writeData(String results) {
        try {
            FileWriter writer = new FileWriter("output.txt"); //write results to output.txt
            writer.write(results);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
