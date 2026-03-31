import java.time.LocalDate;

public class Consult {

    private String note;
    private User user;
    private LocalDate date;
    public boolean sensitive;

    public Consult(String note, User user, boolean sensitive) {
        this.note = note;
        this.user = user;
        this.date = LocalDate.now();
        this.sensitive = sensitive;
    }

    @Override
    public String toString() {
        return String.format("Datum: %s | Gemaakt door: %s | Notitie: %s",
                date,
                user.getRole(),
                note);
    }


}
