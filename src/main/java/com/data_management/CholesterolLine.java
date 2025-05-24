package com.data_management;

public class CholesterolLine {
    private int patientId;
    private double measurementValue;
    private String recordType;
    private long timestamp;

    public CholesterolLine(String line) {
        String segments[] = line.split(",");
        int length = segments.length;
        String[] stringValues = new String[length];

        for (int i = 0; i < length; i++) {
            stringValues[i] = segments[i].split(": ")[1];
        }
        
        patientId = Integer.parseInt(stringValues[0]);
        measurementValue = Double.parseDouble(stringValues[3]);
        recordType = stringValues[2];
        timestamp = Long.parseLong(stringValues[1]);
    }

    public int getPatientId() {
        return patientId;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public String getRecordType() {
        return recordType;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}