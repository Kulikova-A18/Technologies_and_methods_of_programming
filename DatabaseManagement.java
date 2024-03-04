import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Iterator;

class Department {
    public String name;
    public String description;
    public Map<String, Double> positions;

    public Department(String name, String description) {
        if (!isValidNameDescription(name)) {
            // throw new IllegalArgumentException("Invalid full name");
            System.out.println("Недопустимое название");
            name = "null";
        }
        if (!isValidDescription(description)) {
            // throw new IllegalArgumentException("Invalid full name");
            System.out.println("Недопустимый текст");
            description = "null";
        }
        this.name = name;
        this.description = description;
        this.positions = new HashMap<>();
    }

    public void addPosition(String position, double rate) {
        positions.put(position, rate);
    }

    private boolean isValidNameDescription(String namedescription) {
        return !namedescription.isEmpty();
    }

    private boolean isValidDescription(String description) {
        return !description.isEmpty();
    }

}

class Employee {
    public String fullName;
    public int birthYear;
    public String position;
    public double rate;
    public String hireDate;
    public String SNILS;

    public Employee(String fullName, int birthYear, String position, double rate, String hireDate, String SNILS) {
        if (!isValidFullName(fullName)) {
            // throw new IllegalArgumentException("Invalid full name");
            System.out.println("Недопустимое полное имя");
            fullName = "null";
        }
        if (birthYear < 1900 || birthYear > 2024) {
            // throw new IllegalArgumentException("Invalid birth year");
            System.out.println("Неверный год рождения");
            birthYear = 1900; // default 1900
        }
        if (!isValidPosition(position)) {
            // throw new IllegalArgumentException("Invalid position");
            System.out.println("Неверная позиция");
            position = "null";
        }
        if (rate <= 0) {
            // throw new IllegalArgumentException("Invalid rate");
            System.out.println("Неверная ставка");
            rate = 0;
        }
        if (!isValidDate(hireDate)) {
            // throw new IllegalArgumentException("Invalid hire date");
            System.out.println("Неверная дата приема на работу");
            hireDate = "null";
        }
        if (!isValidSNILS(SNILS)) {
            // throw new IllegalArgumentException("Invalid SNILS");
            System.out.println("Неверный СНИЛС");
            SNILS = "null";
        }

        this.fullName = fullName;
        this.birthYear = birthYear;
        this.position = position;
        this.rate = rate;
        this.hireDate = hireDate;
        this.SNILS = SNILS;
    }

    // Методы валидации данных
    private boolean isValidFullName(String fullName) {
        // return Pattern.matches("[A-Za-z ]+", fullName);
        return !fullName.isEmpty();
    }

    private boolean isValidPosition(String position) {
        return !position.isEmpty();
    }

    private boolean isValidDate(String date) {
        return Pattern.matches("\\d{2}/\\d{2}/\\d{4}", date);
    }

    private boolean isValidSNILS(String SNILS) {
        return Pattern.matches("\\d{3}-\\d{3}-\\d{3} \\d{2}", SNILS);
    }

}

class DatabaseManagement {
    private List<Employee> employees;
    private List<Department> departments;

    public DatabaseManagement() {
        employees = new ArrayList<>();
        departments = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws IllegalArgumentException {
        if (employee == null) {
            // throw new IllegalArgumentException("Сотрудник не может быть нулевым
            // (null)");
            System.out.println("Сотрудник не может быть нулевым (null)");
        }
        employees.add(employee);
    }

    public void addDepartment(Department department) throws IllegalArgumentException {
        if (department == null) {
            // throw new IllegalArgumentException("Отдел не может быть нулевым (null)");
            System.out.println("Отдел не может быть нулевым (null)");
        }
        departments.add(department);
    }

    public void printEmployees() {
        System.out.println("\nСотрудники:\n");
        for (Employee employee : employees) {
            System.out.println("* Данные *");
            System.out.println("ФИО сотрудника: " + employee.fullName);
            System.out.println("Год рождения: " + employee.birthYear);
            System.out.println("Введите СНИЛС: " + employee.SNILS);
            System.out.println("Введите Должность: " + employee.position);
            System.out.println("Дата приема на работу: " + employee.hireDate);
            System.out.println("Ставка: " + employee.rate);
        }
    }

    public void printDepartments() {
        System.out.println("Отделы:");
        for (Department department : departments) {
            System.out.println("Имя: " + department.name + ", Описание: " + department.description);
            System.out.println("Позиции:");
            for (Map.Entry<String, Double> entry : department.positions.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
        }
    }

    public void searchEmployeeByFullName(String fullName) {
        for (Employee employee : employees) {
            if (employee.fullName.equals(fullName)) {
                System.out.println("Сотрудник найден:\n" + employee);
                return;
            }
        }
        System.out.println("Сотрудник с полным именем '" + fullName + "' не найдено.");
    }

    public void searchEmployeeBySnils(String snils) {
        for (Employee employee : employees) {
            if (employee.SNILS.equals(snils)) {
                System.out.println("Сотрудник найден:\n" + employee);
                return;
            }
        }
        System.out.println("Сотрудник со СНИЛС '" + snils + "' не найдено.");
    }

    public void updateEmployeeDataBySnils(String snils, String newFullName, String newPosition) {
        for (Employee employee : employees) {
            if (employee.SNILS.equals(snils)) {
                employee.fullName = newFullName;
                employee.position = newPosition;
                System.out.println("Данные о сотрудниках успешно обновлены.");
                return;
            }
        }
        System.out.println("Сотрудник со СНИЛС '" + snils + "' не найдено.");
    }

    public void deleteEmployeeBySnils(String snils) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.SNILS.equals(snils)) {
                iterator.remove();
                System.out.println("\"Сотрудник со СНИЛС '" + snils + "' успешно удалено.");
                return;
            }
        }
        System.out.println("Сотрудник со СНИЛС '" + snils + "' не найдено.");
    }

    public void addDepartment(String departmentName, String departmentName2) {
        departments.add(new Department(departmentName, departmentName2));
        System.out.println("Отделение '" + departmentName + "' успешно добавлено.");
    }

    public void printAllDepartments() {
        System.out.println("\n* Список всех отделов:");
        for (Department department : departments) {
            System.out.println(department.name);
        }
    }

    public void searchDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.name.equals(departmentName)) {
                System.out.println("Отдел найден:\n" + department);
                return;
            }
        }
        System.out.println("Отдел с названием '" + departmentName + "' не найдено.");
    }

    public void updateDepartmentDataByName(String departmentName, String newLocation) {
        for (Department department : departments) {
            if (department.name.equals(departmentName)) {
                department.description = newLocation;
                System.out.println("Данные отдела успешно обновлены.");
                return;
            }
        }
        System.out.println("Отдел с названием '" + departmentName + "' не найдено.");
    }

    public void deleteDepartmentByName(String departmentName) {
        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.name.equals(departmentName)) {
                iterator.remove();
                System.out.println("Отделение '" + departmentName + "' успешно удалено.");
                return;
            }
        }
        System.out.println("Отдел с названием '" + departmentName + "' не найдено.");
    }

    /*
     * Основные операции интерфейса БД (реализовать в методах классах,
     * можно не все, минимально, чтобы можно было вводить данные в БД и
     * вывести их):
     * - ввод данных о новом сотруднике (полных данных или частичных: ФИО, год
     * рождения и СНИЛС);
     * - вывод списка всех сотрудников (краткая информация: ФИО, год
     * рождения,СНИЛС);
     * - поиск и вывод полных данных о сотруднике (сотрудниках) (поиск по ФИО, поиск
     * по СНИЛС);
     * - поиск по СНИЛС и изменение некоторых данных о сотруднике (изменение ФИО,
     * должности в структурном подразделении);
     * - поиск по СНИЛС и удаление сотрудника из БД;
     * - ввод данных о новом структурном подразделении (полностью или частично);
     * - вывод списка всех подразделения (названия);
     * - поиск по названию и изменение некоторых данных о структурном подразделении;
     * - поиск по названию и удаление подразделения из БД (сотрудники этого
     * подразделения не удаляются, остаются в БД за штатом).
     */

    public static void main(String[] args) {
        DatabaseManagement db = new DatabaseManagement();
        Scanner scanner = new Scanner(System.in);

        // Бесконечный цикл для работы с пользовательским вводом
        while (true) {
            String fullName;
            int birthYear;
            String ssn;
            String position;
            String _hireDate;
            int rate;
            String namedescription;
            String description;

            System.out.println("----- МЕНЮ -----");
            System.out.println(
                    "1. ввод данных о новом сотруднике (ФИО, год рождения и СНИЛС);");
            System.out.println("2. вывод списка всех сотрудников (краткая информация: ФИО, год рождения,СНИЛС);");
            System.out.println(
                    "3. поиск и вывод полных данных о сотруднике (сотрудниках) (поиск по ФИО, поиск по СНИЛС);");
            System.out.println(
                    "4. поиск по СНИЛС и изменение некоторых данных о сотруднике (изменение ФИО, должности в структурном подразделении);");
            System.out.println("5. поиск по СНИЛС и удаление сотрудника из БД;");
            System.out.println("6. ввод данных о новом структурном подразделении (полностью или частично);");
            System.out.println("7. вывод списка всех подразделения (названия);");
            System.out.println("8. поиск по названию и изменение некоторых данных о структурном подразделении;");
            System.out.println(
                    "9. поиск по названию и удаление подразделения из БД (сотрудники этого подразделения не удаляются, остаются в БД за штатом).");
            System.out.println(
                    "10. выход");
            System.out.println("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите ФИО сотрудника (Куликова Алёна Владимировна): ");
                    fullName = scanner.nextLine();
                    fullName = scanner.nextLine();

                    System.out.print("Введите год рождения (2000): ");
                    birthYear = scanner.nextInt();
                    birthYear = scanner.nextInt();

                    System.out.print("Введите СНИЛС (123-456-789 00): ");
                    ssn = scanner.nextLine();
                    ssn = scanner.nextLine();

                    System.out.print("Введите Должность (программист): ");
                    position = scanner.nextLine();
                    position = scanner.nextLine();

                    System.out.print("Дата приема на работу (01/01/2020): ");
                    _hireDate = scanner.nextLine();
                    _hireDate = scanner.nextLine();

                    System.out.print("Введите ставку (1.0): ");
                    rate = scanner.nextInt();
                    rate = scanner.nextInt();
                    // public Employee(String fullName, int birthYear, String position, double rate,
                    // String hireDate, String SNILS)
                    db.addEmployee(new Employee(fullName, birthYear, position, rate, _hireDate, ssn));
                    break;
                case 2:
                    db.printEmployees();
                    break;
                case 3:
                    System.out.println(
                            "1. поиск по ФИО");
                    System.out.println(
                            "2. поиск по СНИЛС");
                    System.out.print("Выберите действие: ");
                    if (scanner.nextInt() == 1) {
                        System.out.print("Введите ФИО сотрудника (Куликова Алёна Владимировна): ");
                        fullName = scanner.nextLine();
                        fullName = scanner.nextLine();
                        db.searchEmployeeByFullName(fullName);
                    } else {
                        System.out.print("Введите СНИЛС (123-456-789 00): ");
                        ssn = scanner.nextLine();
                        ssn = scanner.nextLine();
                        db.searchEmployeeBySnils(ssn);
                    }
                    break;
                case 4:
                    System.out.print("Введите СНИЛС (123-456-789 00): ");
                    ssn = scanner.nextLine();
                    ssn = scanner.nextLine();
                    System.out.print("Введите ФИО сотрудника (Куликова Лёна Вадовна): ");
                    fullName = scanner.nextLine();
                    fullName = scanner.nextLine();
                    System.out.print("Введите Должность (дизайнер): ");
                    position = scanner.nextLine();
                    position = scanner.nextLine();
                    db.updateEmployeeDataBySnils(ssn, fullName, position);
                    break;
                case 5:
                    System.out.print("Введите СНИЛС (123-456-789 00): ");
                    ssn = scanner.nextLine();
                    ssn = scanner.nextLine();
                    db.deleteEmployeeBySnils(ssn);
                    break;
                case 6:
                    System.out.print("Введите название структурного подразделения (Отдел кадров): ");
                    namedescription = scanner.nextLine();
                    namedescription = scanner.nextLine();
                    System.out.print("Введите подробности структурного подразделения (Отдел кадров МГТУ): ");
                    description = scanner.nextLine();
                    description = scanner.nextLine();
                    db.addDepartment(namedescription, description);
                    break;
                case 7:
                    db.printAllDepartments();
                    break;
                case 8:
                    System.out.print("Введите название структурного подразделения (Отдел кадров): ");
                    namedescription = scanner.nextLine();
                    namedescription = scanner.nextLine();
                    db.searchDepartmentByName(namedescription);
                    break;
                case 9:
                    System.out.print("Введите название структурного подразделения (Отдел кадров): ");
                    namedescription = scanner.nextLine();
                    namedescription = scanner.nextLine();
                    System.out
                            .print(
                                    "Введите подробности структурного подразделения (Отдел кадров МГТУ им. Баумана): ");
                    description = scanner.nextLine();
                    description = scanner.nextLine();
                    db.updateDepartmentDataByName(namedescription, description);
                    break;
                case 10:
                    System.out.println("Выход...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            // scanner.close();
        }
    }
}
