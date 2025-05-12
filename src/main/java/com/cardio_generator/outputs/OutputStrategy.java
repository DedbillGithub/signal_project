package com.cardio_generator.outputs;

/**
 * Interface for the strategy used when outputting patient data
 * contains a {@link #output(int, long, String, String)} method that is responsible for outputting given data
 */
public interface OutputStrategy {
    /**
     * Outputs the given parameters
     * @param patientId id of the patient
     * @param timestamp timestamp of the measurment
     * @param label label of the measurement
     * @param data value of the measurement
     */
    void output(int patientId, long timestamp, String label, String data);
}
