/**
* Этот класс вычисляет приближение числа Пи, используя формулу Базельской
* задачи и различные уровни точности.
*/
class Main {
public static void main(String[] args) {
// Перебор различных уровней точности
for (int i = 2; i <= 6; i += 2) {
double e = Math.pow(10, -i); // уровень точности
long startTime = System.currentTimeMillis();
double pi = Math.sqrt(6 * calculatePi(e)); // Вычисление приближение числа Пи
long endTime = System.currentTimeMillis();

// Вывод результатов
System.out.println("Приближение Пи с e = 10^(-" + i + "): " + pi);
System.out.println("Необходимое количество терминов: " +
calculateNumTerms(e));
System.out.println("Затраченное время: " + (endTime - startTime) + " ms\n");
}
}

/**
* Сумма членов для аппроксимации числа Пи, используя формулу
* Базельской задачи.
*/
public static double calculatePi(double e) {
double sum = 1.0;
double term;
int n = 2;

// Вычисление сумму до тех пор, пока член не станет меньше указанной
точности.
do {
term = 1.0 / (n * n);
sum += term;
n++;
} while (term >= e);

return sum;
}

/**
* Рассчет количества членов, необходимых для достижения указанной точности.
*/
public static long calculateNumTerms(double e) {
double term;
int n = 2;
long numTerms = 1;

// Количество членов, необходимых для достижения указанной точности.
do {
term = 1.0 / (n * n);
n++;
numTerms++;
} while (term >= e);

return numTerms;
}
}
