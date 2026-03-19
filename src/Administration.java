class Administration {
    Patient currentPatient;            // The currently selected patient
    User currentUser;               // the current user of the program.
    PatientManager patientManager = new PatientManager();

    /**s
     * Constructor
     */
    Administration(User user) {
        currentUser = user;

        currentPatient = patientManager.getPatientById(10002); // default patient is the first one in the list
        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());
    }
}
