import java.util.Scanner;

public class LoginManager {

    public User login(Scanner scanner) {
        System.out.println("==== LOGIN ====");
        System.out.println("1: Huisarts");
        System.out.println("2: Apotheker");
        System.out.println("3: Fysiotherapeut");
        System.out.println("4: Tandarts");
        System.out.print("Kies je rol: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ongeldige input");
            scanner.next();
            return null;
        }

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
               return new User(1, "Huisarts", UserRoles.HUISARTS);

            case 2:
                return new User(2, "Apotheker", UserRoles.APOTHEKER);

            case 3:
                return new User(3, "Fysiotherapeut", UserRoles.FYSIOTHERAPEUT);

            case 4:
                return new User(4, "Tandarts", UserRoles.TANDARTS);
            default:
                System.out.println("Ongeldige Gebruiker");
                return null;

        }
    }
}
