import java.util.Scanner;

class ZorgApp {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        System.out.println("==== LOGIN ====");
        System.out.println("1: Huisarts");
        System.out.println("2: Apotheker");
        System.out.println("3: Fysiotherapeut");
        System.out.println("4: Tandarts");
        System.out.print("Kies je rol: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ongeldige input");
            return;
        }

        int choice = scanner.nextInt();

        User user = null;

        switch (choice) {
            case 1:
                user = new User(1, "Huisarts", UserRoles.HUISARTS);
                break;
            case 2:
                user = new User(2, "Apotheker", UserRoles.APOTHEKER);
                break;
            case 3:
                user = new User(3, "Fysiotherapeut", UserRoles.FYSIOTHERAPEUT);
                break;
            case 4:
                user = new User(4, "Tandarts", UserRoles.TANDARTS);
                break;

            default:
                System.out.println("Ongeldige Gebruiker");
                return;

        }

        Administration admin = new Administration(user);
        Menu menu = new Menu();
        menu.runMenu(admin);

    }
}
