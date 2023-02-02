/**
 * Необходимо реализовать поиск количества городов в разрезе регионов. Необходимо определить количество городов в каждом регионе.
 *Пример полученного результата:
 *
 * Вологодская область - 15
 * Татарстан - 22
 * Хабаровский край – 7
 * ...
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ReaderClass {
    private void printFileContent(InputStream is) throws IOException {
        try (Scanner scanner = new Scanner(is)) {
            List<City> cityList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(";");
                City city = new City(splitLine);
                cityList.add(city);
            }
            Map<String, Long> result = cityList.stream().map(City::getRegion)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            result.forEach((region, numb)->System.out.println(region + " - " + numb));

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
