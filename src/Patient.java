import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

class Patient {
   static final int RETURN      = 0;
   static final int SURNAME     = 1;
   static final int FIRSTNAME   = 2;
   static final int DATEOFBIRTH = 3;

    private int id;
    private String surname;
    private String firstName;
    private final LocalDate dateOfBirth;
    private double weight;
    private double height;

    private final List<Medication> medications = new ArrayList<>();

    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName,
            LocalDate dateOfBirth, double weight, double height) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    String getSurname() {
        return surname;
    }

    String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }// age is calculated by comparing the date of birth with the current date.

    public double getBMI() {
        return weight / (height * height);

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setHeight(double height) {
        this.height = height;
    }

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

    public void showMedications() {
        if (medications.isEmpty()) {
            System.out.println("No medications Registered for " + fullName());
            return;
        }
        for (Medication m : medications) {
            System.out.println(m);
        }
    }

    /**
     * Display patient data.
     */
    void viewData() {
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "First Name:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %d\n", "Age:", getAge());
        System.out.format("%-17s %.2f\n", "Weight(KG):", weight);
        System.out.format("%-17s %.2f\n", "Height(M):", height);
        System.out.format("%-17s %.2f\n", "BMI:", getBMI());

        System.out.println("Medications: ");
        showMedications();
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString());
    }
}
