/**
 * Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа
 * в алфавитном порядке по убыванию с учетом регистра;
 *
 * Затем вывести полученный список объектов City в консоль. При реализации сортировки нужно обратить внимание
 * на возможные варианты реализации: Comparator, lambda-выражения.
 *
 * Пример полученного результата для сортировки по двум полям справочника – федеральному округу и наименованию города:
 *
 * City{name='Алдан', region='Якутия', district='Дальневосточный', population=21277, foundation='1924'}
 * City{name='Александровск-Сахалинский', region='Сахалинская область', district='Дальневосточный', population=10613, foundation='1869'}
 * City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}
 *
 * …
 *
 * City{name='Абдулино', region='Оренбургская область', district='Приволжский', population=20663, foundation='1795'}
 * City{name='Агидель', region='Башкортостан', district='Приволжский', population=16365, foundation='1980'}
 * City{name='Агрыз', region='Татарстан', district='Приволжский', population=19299, foundation='1646'}
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
                cityList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                cityList.sort((o1, o2) -> o1.getDistrict().compareTo(o2.getDistrict()));

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
