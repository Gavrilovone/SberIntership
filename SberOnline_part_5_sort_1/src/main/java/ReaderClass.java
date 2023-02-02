/**
 * Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;
 * Затем вывести полученный список объектов City в консоль. При реализации сортировки нужно обратить
 * внимание на возможные варианты реализации: Comparator, lambda-выражения.
 *
 * Пример полученного результата для сортировки по наименованию:
 *
 * City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation='1867'}
 * City{name='Абакан', region='Хакасия', district='Сибирский', population=165183, foundation='1931'}
 * City{name='Абдулино', region='Оренбургская область', district='Приволжский', population=20663, foundation='1795'}
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderClass {
    private void printFileContent(InputStream is) throws IOException {

        try (Scanner scanner = new Scanner(is)) {
            List<City> cityList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(";");

                cityList.add(new City(splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5]));
                cityList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

            }
            for (City st : cityList) {
                System.out.println(st);
            }

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
