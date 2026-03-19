import java.util.ArrayList;
import java.util.List;


public class MedicationManager {

    private final List<Medication> medications = new ArrayList<>();

    public void addMedication(String name, String dosage) {
        medications.add(new Medication(name, dosage));
    }

    public void updateMedicationDosage(String name, String newDosage) {
        for (Medication m : medications) {
            if (m.getName().equalsIgnoreCase(name)) {
                m.setDosage(newDosage);
                System.out.println("Dosage updated for " + name);
                return;
            }
        }
        System.out.println("Medication not found ");
    }

    public void removeMedication(String name) {
        for (Medication m : medications) {
            if (m.getName().equalsIgnoreCase(name)) {
                medications.remove(m);
                System.out.println("Medication has been Removed.");
                return;
            }
        }
        System.out.println("This Medication has not been found.");
    }

    public void showMedications() {
        if (medications.isEmpty()) {
            System.out.println("No medications Registered for this patient");
            return;
        }
        for (Medication m : medications) {
            System.out.println(m);
        }

    }

    public void showPainkillers() {
        for (Medication m : medications) {
            if (m.getName().toLowerCase().contains("paracetamol") ||
                    m.getName().toLowerCase().contains("ibuprofen")) {
                System.out.println(m);
            }

        }
    }


}
