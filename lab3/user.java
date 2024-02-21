import java.security.MessageDigest;

// Класс, представляющий пользователя
class User {
    private String username; // Имя пользователя
    private String passwordHash; // Хэш пароля

    // Конструктор для создания пользователя с заданным именем и паролем
    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password); // Хэширование пароля
    }

    // Метод для получения имени пользователя
    public String getUsername() {
        return username;
    }

    // Метод для проверки введенного пароля
    public boolean checkPassword(String password) {
        return hashPassword(password).equals(passwordHash);
    }

    // Метод для изменения пароля пользователя
    public void changePassword(String newPassword) {
        this.passwordHash = hashPassword(newPassword);
    }

    // Метод для хэширования пароля с использованием SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
