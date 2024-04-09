/*
Вариант 7
Создать класс базовый класс «вещественное число».
Элементы класса (поля имеют статус доступа protected):  
поле, задающее значение числа;
конструктор для инициализации поля;
метод для вычисления модуля числа;
метод для печати параметров объекта.
Создать производный класс «комплексное число».
Элементы класса:  
дополнительно поле, задающее значение мнимой части числа;
конструктор для инициализации полей;
переопределенный метод для вычисления модуля числа (модуль числа – корень квадратный из суммы квадратов вещественной и мнимой частей числа);
переопределенный метод для печати параметров, внутри вызвать метод печати из базового класса.

Создать по 1 объекту каждого из классов. Объявить переменную - ссылку, имеющею тип базового класса, вначале настроить 
ее на объект базового класса, вызвать метод базового класса через ссылку на объект. Затем настроить ее на объект 
производного класса, вызвать метод производного класса через ссылку на объект, определить какой метод вызывается 
(базового или производного классов, написать в комментариях).
*/
public class Main {

    // Внутренний класс RealNumber для представления действительных чисел
    public static class RealNumber {
        protected double value;

        // Конструктор класса RealNumber
        public RealNumber(double value) {
            this.value = value;
        }

        // Метод для вычисления абсолютного значения действительного числа
        public double calculateAbsoluteValue() {
            return Math.abs(value);
        }

        // Метод для вывода параметров действительного числа
        public void printParameters() {
            System.out.println("Действительное число: " + value);
        }
    }

    // Внутренний класс ComplexNumber для представления комплексных чисел
    public static class ComplexNumber extends RealNumber {
        protected double imaginaryPart;

        // Конструктор класса ComplexNumber
        public ComplexNumber(double realValue, double imaginaryPart) {
            super(realValue);
            this.imaginaryPart = imaginaryPart;
        }

        // Переопределенный метод для вычисления абсолютного значения комплексного числа
        @Override
        public double calculateAbsoluteValue() {
            return Math.sqrt(Math.pow(value, 2) + Math.pow(imaginaryPart, 2));
        }

        // Переопределенный метод для вывода параметров комплексного числа
        @Override
        public void printParameters() {
            super.printParameters();
            System.out.println("Мнимая часть: " + imaginaryPart);
        }
    }

    // Основной метод main для запуска программы
    public static void main(String[] args) {
        RealNumber realNum = new RealNumber(5.5);
        realNum.printParameters();

        RealNumber complexNum = new ComplexNumber(3.0, 4.0);
        complexNum.printParameters();

        if (complexNum != null && complexNum instanceof ComplexNumber) {
            ComplexNumber complexNumInstance = (ComplexNumber) complexNum;
            System.out
                    .println("Абсолютное значение комплексного числа: " + complexNumInstance.calculateAbsoluteValue());
        } else {
            System.out.println("Объект не является экземпляром ComplexNumber.");
        }
    }
}
