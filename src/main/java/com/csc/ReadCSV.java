package com.csc;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV {
    public List<String[]> readData(String filePath) {
        List<String[]> records = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("cheese_data.csv"));
            String[] values;
            while ((values = reader.readNext()) != null) {
                records.add(values);
            }
        reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return records;
    }
}
