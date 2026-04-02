import java.time.LocalDate;

public class Consult {

    private String note;
    private User user;
    private LocalDate date;
    private boolean isSensitive;

    public Consult(String note, User user, boolean isSensitive) {
        this.note = note;
        this.user = user;
        this.date = LocalDate.now();
        this.isSensitive = isSensitive;
    }

    public boolean isSensitive() {
        return isSensitive;
    }

    @Override
    public String toString() {
        return String.format("Datum: %s | Gemaakt door: %s | Notitie: %s",
                date,
                user.getRole(),
                note);
    }


}
