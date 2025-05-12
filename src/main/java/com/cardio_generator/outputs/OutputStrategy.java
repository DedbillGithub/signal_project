package com.cardio_generator.outputs;

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
