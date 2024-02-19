import java.util.Scanner;

class SecurityDevice {
    private String name;
    private int securityClass;

    // Конструктор класса SecurityDevice
    public SecurityDevice(String name, int securityClass) {
        this.name = name;
        this.securityClass = securityClass;
    }

    // Метод для проверки возможности использования устройства для заданного класса
    // защиты
    public boolean canUseForSecurityClass(int targetSecurityClass) {
        return this.securityClass <= targetSecurityClass;
    }

    // Метод для печати параметров устройства
    public void printDetails() {
        System.out.println("Имя:\t" + name);
        System.out.println("Класс защищенности:\t" + securityClass);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("количество защищаемых устройств: ");
        int numDevices = scanner.nextInt();
        SecurityDevice[] devices = new SecurityDevice[numDevices]; // создание массива устройств

        // Ввод данных о каждом устройстве
        for (int i = 0; i < numDevices; i++) {
            String name = "N" + (i + 1); // генерация
            System.out.println("* (сгенерировано) имя устройства " + (i + 1) + "/" + numDevices + ": " + name);
            // String name = scanner.next(); // пишется от руки

            System.out.print("* (ввести) класс безопасности устройства " + (i + 1) + "/" + numDevices + " (1-7): ");
            int securityClass = scanner.nextInt();
            devices[i] = new SecurityDevice(name, securityClass);
        }
        System.out.println("\n--- список устройств ----");
        for (SecurityDevice device : devices) {
            device.printDetails();
        }

        System.out.println("\n--- вывод ----");
        System.out.print("класс безопасности (1-7): ");
        int targetSecurityClass = scanner.nextInt();

        System.out.println("устройства безопасности, которые можно использовать для класса безопасности "
                + targetSecurityClass + ":");

        // Вывод устройств, которые можно использовать для заданного класса защиты
        for (SecurityDevice device : devices) {
            if (device.canUseForSecurityClass(targetSecurityClass)) {
                device.printDetails();
            }
        }
    }
}