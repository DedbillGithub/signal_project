package com.cardio_generator.generators;

import java.util.Random; // fixed : There are no other blank lines between import statements.
import com.cardio_generator.outputs.OutputStrategy;

/**
 * Class for generating alerts for patients
 * Alerts can be resolved or triggered
 */
public class AlertGenerator implements PatientDataGenerator {

    public static final Random RANDOM_GENERATOR = new Random(); // fixed : Constant names use UPPER_SNAKE_CASE
    private boolean[] alertStates; // false = resolved, true = pressed // fixed : Non-constant field names are written in lowerCamelCase.

    /**
     * Constructor for AlertGenerator
     * @param patientCount number of patients
     */
    public AlertGenerator(int patientCount) {
        alertStates = new boolean[patientCount + 1];
    }

    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            if (alertStates[patientId]) {
                if (RANDOM_GENERATOR.nextDouble() < 0.9) { // 90% chance to resolve
                    alertStates[patientId] = false;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "resolved");
                }
            } else {
                double lambda = 0.1; // Average rate (alerts per period), adjust based on desired frequency // fixed : Non-constant field names are written in lowerCamelCase.
                double p = -Math.expm1(-lambda); // Probability of at least one alert in the period
                boolean alertTriggered = RANDOM_GENERATOR.nextDouble() < p;

                if (alertTriggered) {
                    alertStates[patientId] = true;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "triggered");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while generating alert data for patient " + patientId);
            e.printStackTrace();
        }
    }
}
