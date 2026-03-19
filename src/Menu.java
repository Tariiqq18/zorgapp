import java.util.Scanner;

class Menu {
    static final int STOP = 0;
    static final int VIEW = 1;
    static final int PATIENTLIST = 2;
    static final int EDIT = 3;
    static final int ADDMED = 4;
    static final int UPDATEDOSAGE = 5;
    static final int REMOVEMED = 6;
    static final int SHOWMEDS = 7;
    static final int ENTERID = 8;

    void runMenu(Administration admin) {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", admin.currentPatient.fullName());

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
                        admin.currentPatient.viewData();
                        break;

                    case PATIENTLIST :
                        admin.patientManager.showAllPatients();
                        break;

                    case ENTERID:
                        System.out.println("Enter patient ID:");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                            break;
                        }
                        int id = scanner.nextInt();
                        Patient selected = admin.patientManager.getPatientById(id);
                        if (selected != null) {
                            admin.currentPatient = selected;
                            System.out.println("Patient selected.");
                        } else {
                            System.out.println("Pat ient ID not found.");
                        }
                        break;

                    case EDIT:
                        scanner.nextLine();
                        System.out.println("New weight: ");
                        admin.currentPatient.setWeight(scanner.nextDouble());

                        scanner.nextLine();
                        System.out.println("New height: ");
                        admin.currentPatient.setHeight(scanner.nextDouble());


                        scanner.nextLine();
                        System.out.println("Patient updated :)");
                        break;

                    case ADDMED:
                        scanner.nextLine();

                        System.out.println("Medication name: ");
                        String name = scanner.nextLine();

                        System.out.println("Dosage: ");
                        String dosage = scanner.nextLine();

                        admin.currentPatient.addMedication(name, dosage);

                        System.out.println("Medication added :)");
                        break;

                    case UPDATEDOSAGE:
                        scanner.nextLine();

                        System.out.println("Medication name: ");
                        String medName = scanner.nextLine();

                        System.out.println("New dosage:");
                        String newDosage = scanner.nextLine();
                        admin.currentPatient.updateMedicationDosage(medName, newDosage);
                        break;


                    case REMOVEMED:
                        scanner.nextLine();

                        System.out.println("Medication to be removed: ");
                        String medNameDelete = scanner.nextLine();

                        admin.currentPatient.removeMedication(medNameDelete);
                        break;

                    case SHOWMEDS:
                        admin.currentPatient.showMedications();
                        break;

                    default:
                        System.out.println("Please enter a valid menu number.");
                        break;
                }
            }
        }
    }
