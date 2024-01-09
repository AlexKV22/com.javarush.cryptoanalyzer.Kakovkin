package Texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class GetEncryptionText {
    private static final String ASKING_FILE = new String("Укажите путь файла с зашифрованным текстом:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");

    public static String getEncryptionText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASKING_FILE);                //Запрашиваем путь к файлу с зашифрованным текстом
        Path path = Path.of(scanner.nextLine());        // Получаем путь из консоли
        try {
            if (Files.notExists(path)) {
            }                                           //Проверка на наличие, если файл не содержится, сообщение об ошибке,
        }                                               //при введении неправильного пути срабатывает ошибка, но константа ERROR не показывается, ПОЧЕМУ??
        catch (Exception e) {
            System.out.println(ERROR);
        }

        String nonСleanText;
        try {
            List < String > nonСleanText1 = Files.readAllLines(path);       //Скидываем текст в список
            nonСleanText = String.join("\n", nonСleanText1);        // Объединяем элементы в строку
        }
            catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nonСleanText;                                               //Возвращаем строку исходного текста для расшифровки
    }
}

