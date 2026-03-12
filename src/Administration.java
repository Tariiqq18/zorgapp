import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Administration {
    static final int STOP = 0;
    static final int VIEW = 1;
    static final int PATIENTLIST = 2;
    static final int EDIT = 3;
    static final int ADDMED = 4;
    static final int UPDATEDOSAGE = 5;
    static final int REMOVEMED = 6;
    static final int SHOWMEDS = 7;
    static final int ENTERID = 8;

    Patient currentPatient;            // The currently selected patient
    User currentUser;               // the current user of the program.
    List<Patient> patients = new ArrayList<>();


    /**s
     * Constructor
     */
    Administration(User user) {


        currentUser = user;
        patients.add(new Patient(10001, "Van Puffelen", "Pierre",
                LocalDate.of(2000, 2, 28), 80, 1.88));

        patients.add(new Patient(10002, "Van Hekken", "Piet",
                LocalDate.of(2000, 3, 1), 95, 1.92));

        patients.add(new Patient( 10003, "Schoonhoven","Tariq",
                LocalDate.of(2005,  2, 19), 75, 1.90));

        patients.add(new Patient(10004, "Pietersen", "Johan",
                LocalDate.of(2000, 4, 1), 88, 1.79));

        patients.add(new Patient(10005, "Vermeer", "Kenneth",
                LocalDate.of(1985, 12, 14),79, 1.83 ));

        currentPatient = patients.get(1); // default patient is the first one in the list


        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());
    }
    void showAllPatients() {
        System.out.println("======Patient List======");
        for (Patient p : patients) {
            System.out.printf("Patient ID: %d | %s\n",
                    p.getId(),
                    p.fullName());
        }
    }


    void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", currentPatient.fullName());

            /*
             Print menu on screen
            */
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View current patient data\n", VIEW);
            System.out.format("%d:  Show patient list\n", PATIENTLIST);
            System.out.format("%d:  Edit patient data\n", EDIT);
            System.out.format("%d:  Add medication\n", ADDMED);
            System.out.format("%d:  Update medication dosage\n", UPDATEDOSAGE);
            System.out.format("%d:  Remove medication\n", REMOVEMED);
            System.out.format("%d:  Show medications\n", SHOWMEDS);
            System.out.format("%d:  Enter patient ID\n", ENTERID);
            System.out.print("enter #choice: ");

        if(!scanner.hasNextInt()) {
            System.out.println("Invalid input. please enter a number. ");
            {
                scanner.next();
                return;
            }
        }

            int choice = scanner.nextInt();
                switch (choice) {

                    case STOP: // interrupt the loop
                        nextCycle = false;
                        break;

                    case VIEW:
                        currentPatient.viewData();
                        break;

                    case PATIENTLIST :
                        showAllPatients();
                        break;

                    case ENTERID:
                        System.out.println("Enter patient ID:");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                            break;
                        }
                        int id = scanner.nextInt();
                        boolean found = false;
                        for (Patient p : patients) {
                            if (p.getId() == id) {
                                currentPatient = p;
                                found = true;
                                System.out.println("Patient selected.");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Patient ID not found.");
                        }
                        break;

                    case EDIT:
                        scanner.nextLine();
                        System.out.println("New weight: ");
                        currentPatient.setWeight(scanner.nextDouble());

                        scanner.nextLine();
                        System.out.println("New height: ");
                        currentPatient.setHeight(scanner.nextDouble());


                        scanner.nextLine();
                        System.out.println("Patient updated :)");
                        break;

                    case ADDMED:
                        scanner.nextLine();

                        System.out.println("Medication name: ");
                        String name = scanner.nextLine();

                        System.out.println("Dosage: ");
                        String dosage = scanner.nextLine();

                        currentPatient.addMedication(name, dosage);

                        System.out.println("Medication added :)");
                        break;

                    case UPDATEDOSAGE:
                        scanner.nextLine();

                        System.out.println("Medication name: ");
                        String medName = scanner.nextLine();

                        System.out.println("New dosage:");
                        String newDosage = scanner.nextLine();
                        currentPatient.updateMedicationDosage(medName, newDosage);
                        break;


                    case REMOVEMED:
                        scanner.nextLine();

                        System.out.println("Medication to be removed: ");
                        String medNameDelete = scanner.nextLine();

                        currentPatient.removeMedication(medNameDelete);
                        break;

                    case SHOWMEDS:
                        currentPatient.showMedications();
                        break;

                    default:
                        System.out.println("Please enter a valid menu number.");
                        break;
                }
            }
        }
    }

