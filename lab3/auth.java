import java.util.HashMap;

class AuthenticationEngine {
    private HashMap<String, User> users; // Хранит пользователей и их данные

    public AuthenticationEngine() {
        users = new HashMap<>(); // Инициализация хранилища пользователей
    }

    // Регистрация нового пользователя
    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password)); // Создание нового пользователя
            System.out.println("Пользователь " + username + " успешно зарегистрирован.");
        } else {
            System.out.println("Пользователь " + username + " уже существует.");
        }
    }

    // Вход пользователя в систему
    public boolean loginUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.checkPassword(password)) {
                System.out.println("Пользователь " + username + " успешно вошел в систему.");
                return true;
            }
        }
        System.out.println("Ошибка входа. Неверное имя пользователя или пароль.");
        return false;
    }

    // Изменение пароля пользователя
    public void changePassword(String username, String newPassword) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.changePassword(newPassword);
            System.out.println("Пароль успешно изменен для пользователя " + username);
        } else {
            System.out.println("Пользователь " + username + " не найден.");
        }
    }
}
