package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Interface for generators
 * contains a {@link #generate(int, OutputStrategy)} method that generates data for a given patient
 */
public interface PatientDataGenerator {
    /** 
     * Generates data for a specific patient
     * @param patientId the id of the patient
     * @param outputStrategy the output strategy used @see {@link com.cardio_generator.outputs.OutputStrategy}
     */
    void generate(int patientId, OutputStrategy outputStrategy);
}
