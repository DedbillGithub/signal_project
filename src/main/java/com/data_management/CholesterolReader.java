package com.data_management;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CholesterolReader implements DataReader {

    final private String filePath = "./output/Cholesterol.txt";

    @Override
    public void readData(DataStorage dataStorage) throws IOException {
        File file = new File(filePath);

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            CholesterolLine line = new CholesterolLine(fileScanner.nextLine());
            dataStorage.addPatientData(line.getPatientId(), line.getMeasurementValue(), line.getRecordType() , line.getTimestamp());
        }

        fileScanner.close();
    }
}