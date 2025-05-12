package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class for outputting a specific input into a given directory
 */
public class FileOutputStrategy implements OutputStrategy { // fixed : first letter of the class should be capitalized

    private String baseDirectory; // Non-constant field names are written in lowerCamelCase.

    public final ConcurrentHashMap<String, String> FILE_MAP = new ConcurrentHashMap<>(); //fixed : Constant names use UPPER_SNAKE_CASE

    /**
     * Constructor for FileOutputStrategy
     * @param baseDirectory directory of the output files
     */
    public FileOutputStrategy(String baseDirectory) {
        this.baseDirectory = baseDirectory; //fixed : removed blank line
    }

    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {
            // Create the directory
            Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        }
        // Set the FilePath variable
        String filePath = FILE_MAP.computeIfAbsent(label, k -> Paths.get(baseDirectory, label + ".txt").toString()); // fixed : Non-constant field names are written in lowerCamelCase.

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}