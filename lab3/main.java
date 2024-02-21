import java.util.Scanner;

// Класс, представляющий точку входа в программу
class Main {
    public static void main(String[] args) {
        AuthenticationEngine authEngine = new AuthenticationEngine();
        Scanner scanner = new Scanner(System.in);

        // Бесконечный цикл для работы с пользовательским вводом
        while (true) {
            System.out.println("1. Зарегистрировать пользователя");
            System.out.println("2. Войти");
            System.out.println("3. Изменить пароль");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // считывание символа новой строки

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String regPassword = scanner.nextLine();
                    authEngine.registerUser(regUsername, regPassword);
                    break;
                case 2:
                    System.out.print("Введите имя пользователя: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String loginPassword = scanner.nextLine();
                    authEngine.loginUser(loginUsername, loginPassword);
                    break;
                case 3:
                    System.out.print("Введите имя пользователя: ");
                    String changeUsername = scanner.nextLine();
                    System.out.print("Введите новый пароль: ");
                    String newPassword = scanner.nextLine();
                    authEngine.changePassword(changeUsername, newPassword);
                    break;
                case 4:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
