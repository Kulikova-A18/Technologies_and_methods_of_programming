
class MyCalculator {

    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();

        System.out.println("Sum: " + calculator.add(5, 3));
        System.out.println("Difference: " + calculator.subtract(5, 3));
        System.out.println("Product: " + calculator.multiply(5, 3));

        try {
            System.out.println("Quotient: " + calculator.divide(5, 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Power: " + calculator.power(2, 3));
        System.out.println("Logarithm: " + calculator.logarithm(100, 10));
    }

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }

    public double divide(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return x / y;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double logarithm(double argument, double base) {
        if (argument <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("Invalid arguments for logarithm");
        }
        return Math.log(argument) / Math.log(base);
    }
}
