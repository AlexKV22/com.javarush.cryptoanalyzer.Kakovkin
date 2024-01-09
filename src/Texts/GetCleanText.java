package Texts;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GetCleanText {
    private static final String ASKING_FILE = new String("Укажите путь файла с исходным текстом:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");

    public static String getCleanText()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASKING_FILE);                //Запрашиваем путь файла
        Path path = Path.of(scanner.nextLine());       // Получаем путь из консоли
        try {
            if (Files.notExists(path)) {                //Проверка на наличие, если файл не содержится, сообщение об ошибке,
                                                        // при введении неправильного пути срабатывает ошибка, но константа ERROR не показывается, ПОЧЕМУ??
            }
        }
        catch (Exception e) {
            System.out.println(ERROR);
        }

        String cleanText;
        try {
            List<String> cleanText1 = Files.readAllLines(path);    //Скидываем текст файла в список
            cleanText = String.join("\n", cleanText1);     // Объединяем элементы в строку
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cleanText;                           // Возвращаем строку исходного текста для шифрования
    }
}
