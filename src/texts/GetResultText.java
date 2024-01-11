package texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GetResultText {
    private static final String ASKING_FILE = new String("Укажите путь файла для записи результата:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");
    public static void getResultText(String result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASKING_FILE);
        Path path = Path.of(scanner.nextLine());
        try{
            if (Files.notExists(path)) {
            }
        }
        catch (Exception e) {
            throw new RuntimeException(ERROR);
        }

        try {
            Files.writeString(path, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

