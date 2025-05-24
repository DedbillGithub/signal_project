package data_management;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.data_management.CholesterolReader;
import com.data_management.DataStorage;
import com.data_management.Patient;

class patientRecordsTest {

    @Test
    void testpatientRecords() {
        CholesterolReader reader = new CholesterolReader();
        
        DataStorage storage = new DataStorage();
        storage.addPatientData(1, 154.1876915984697, "Cholesterol", 1714376789050L);
        storage.addPatientData(1, 151.55277551201326, "Cholesterol", 1714376789051L);

        try {
            Patient patient = storage.getPatient(1);
            int oldPatientRecordSize = patient.getAllRecords().size();
            reader.readData(storage);

            assertNotEquals(patient.getAllRecords().size(), oldPatientRecordSize);
        } catch (Exception e) {
            System.out.println("Error reading data");
        }
        
    }

}