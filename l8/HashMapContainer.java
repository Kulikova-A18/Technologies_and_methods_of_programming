import java.awt.BorderLayout;

// import java.util.HashMap;
// import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.TreeSet;
import java.util.HashSet;

import java.util.Random;

class Main {
    public static class MyTimer {
        private long startTime;

        public void start() {
            startTime = System.currentTimeMillis();
        }

        public long stop() {
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }

        public MyTimer() {
            startTime = System.currentTimeMillis();
        }

        public void reset() {
            startTime = System.currentTimeMillis();
        }

        public long getTimeElapsed() {
            return System.currentTimeMillis() - startTime;
        }
    }

    private static void testAdditionAndSearch(Object container, String containerType) {
        MyTimer timer = new MyTimer();
        XYSeries addSeries = new XYSeries("Время добавления");
        XYSeries searchSeries = new XYSeries("Время поиска");

        Random random = new Random();

        for (int i = 100; i <= 10000; i += 100) {
            timer.start();
            for (int j = 0; j < i; j++) {
                int randomValue = random.nextInt(); // Генерация случайного числа
                if (container instanceof TreeSet) {
                    ((TreeSet<Integer>) container).add(randomValue);
                } else if (container instanceof HashSet) {
                    ((HashSet<Integer>) container).add(randomValue);
                }
            }

            long addTime = timer.stop();
            addSeries.add(i, addTime);

            timer.start();
            for (int j = 0; j < 10000; j++) {
                int keyToSearch = random.nextInt(i); // Генерация случайного ключа для поиска
                if (container instanceof TreeSet) {
                    ((TreeSet<Integer>) container).contains(keyToSearch);
                } else if (container instanceof HashSet) {
                    ((HashSet<Integer>) container).contains(keyToSearch);
                }
            }
            long searchTime = timer.stop();
            searchSeries.add(i, searchTime);
        }

        createChart(addSeries, "Время добавления для " + containerType);
        createChart(searchSeries, "Время поиска для " + containerType);
    }

    private static void createChart(XYSeries series, String title) {
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(title, "Количество элементов",
                "Время (мс)", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            ChartPanel chartPanel = new ChartPanel(chart);
            frame.add(chartPanel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        testAdditionAndSearch(treeSet, "TreeSet");
        testAdditionAndSearch(hashSet, "HashSet");

    }
}
