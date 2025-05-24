package com;

import com.cardio_generator.HealthDataSimulator;
import com.data_management.DataStorage;

public class MainClass {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("DataStorage")) {
            DataStorage.main(new String[]{});
        } else {
            try {
                HealthDataSimulator.startSimulation(args);
            } catch (Exception e) {
                System.out.println("Error simulating data");
            }
        }
    }
}
