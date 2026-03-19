import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientManager {

    private final List<Patient> patients = new ArrayList<>();

    public PatientManager() {
        patients.add(new Patient(10001, "Van Puffelen", "Pierre",
                LocalDate.of(2000, 2, 28), 80, 1.88));

        patients.add(new Patient(10002, "Van Hekken", "Piet",
                LocalDate.of(2000, 3, 1), 95, 1.92));

        patients.add(new Patient(10003, "Schoonhoven", "Tariq",
                LocalDate.of(2005, 2, 19), 75, 1.90));

        patients.add(new Patient(10004, "Pietersen", "Johan",
                LocalDate.of(2000, 4, 1), 88, 1.79));

        patients.add(new Patient(10005, "Vermeer", "Kenneth",
                LocalDate.of(1985, 12, 14), 79, 1.83));
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showAllPatients() {
        System.out.println("======Patient List======");
        for (Patient p : patients) {
            System.out.printf("Patient ID: %d | %s\n",
                    p.getId(),
                    p.fullName());
        }
    }

    public Patient getPatientById(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
