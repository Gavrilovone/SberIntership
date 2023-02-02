/**
 * необходимо преобразовать список городов в массив. А затем путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города.
 * Пример полученного результата:
 * [489] = 11 514 330
 */

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReaderClass {
    private void printFileContent(InputStream is) throws IOException {
        try (Scanner scanner = new Scanner(is)) {
            List<City> cityList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(";");
                City city = new City(splitLine);
                cityList.add(city);
            }
            int[] arrayList = new int[cityList.size()];
            for (int i = 0; i < cityList.size(); i++) {
                arrayList[i] = cityList.get(i).getPopulation();
            }
            int index = 0;
            int max = 0;
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] > max) {
                    max = arrayList[i];
                    index = i;
                }
            }
            NumberFormat f = NumberFormat.getInstance();
            System.out.println("[" + index + "]= " + f.format(max));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("problems with the file" + e);
        }
        is.close();
    }

    public static void main(String[] args) throws IOException {
        ReaderClass read = new ReaderClass();
        InputStream is = read.getFileAsIOStream("Задача ВС Java Сбер.csv");
        read.printFileContent(is);


    }

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }
}
