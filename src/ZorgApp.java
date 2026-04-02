import java.util.Scanner;

class ZorgApp {
    public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);

    LoginManager loginManager = new LoginManager();
    User user = loginManager.login(scanner);

    if (user == null) {
        return;
    }
            Administration admin = new Administration(user);
            Menu menu = new Menu();
            menu.runMenu(admin);
        }
    }

