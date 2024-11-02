package com.csc;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.opencsv.CSVReader;


public class ReadCSV {
    public List<String[]> readData(String filePath) {
        List<String[]> records = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("cheese_data.csv"));   //initialize reader object
            String[] values;
            try {
                while ((values = reader.readNext()) != null) { //surround with try/catch
                    records.add(values);     //add the read in values to string array list
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return records;
    }
}
