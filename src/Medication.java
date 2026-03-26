public class Medication {
    private final String name;
    private String dosage;

    public Medication(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    public String getName() {
        return name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public boolean isPainKiller() {
        return name.equalsIgnoreCase("paracetamol") ||
                name.equalsIgnoreCase("ibuprofen") ||
                name.equalsIgnoreCase("Diclofenac");
    }

    @Override
    public String toString() {
        return name + " | Dosage: " + dosage;
    }
}
