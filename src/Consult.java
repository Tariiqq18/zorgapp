import java.time.LocalDate;

public class Consult {

    private String note;
    private User user;
    private LocalDate date;

    public Consult(String note, User user) {
        this.note = note;
        this.user = user;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Datum: %s | Gemaakt door: %s | Notitie: %s",
                date,
                user.getRole(),
                note);
    }


}
