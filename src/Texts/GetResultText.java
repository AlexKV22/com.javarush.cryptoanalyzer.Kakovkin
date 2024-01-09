package Texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GetResultText {
    private static final String ASKING_FILE = new String("Укажите путь файла для записи результата:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");
    public static void getResultText(String result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASKING_FILE);            //Запрашиваем путь к файлу для записи результата
        Path path = Path.of(scanner.nextLine());    //Получаем путь из консоли
        try{                                           //Проверка на наличие, если файл не содержится, сообщение об ошибке,
            if (Files.notExists(path)) {                // при введении неправильного пути срабатывает ошибка, но константа ERROR не показывается, ПОЧЕМУ??
            }
        }
        catch (Exception e) {
            System.out.println(ERROR);
        }

        try {
            Files.writeString(path, result);            //Производим запись в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

