package texts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GetCleanText {
    private static final String ASKING_FILE = new String("Укажите путь файла с исходным текстом:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");

    public static String getCleanText()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ASKING_FILE);
        Path path = Path.of(scanner.nextLine());
        try {
            if (Files.notExists(path)) {
            }
        }
        catch (Exception e) {
            throw new RuntimeException(ERROR);
        }

        String cleanText;
        try {
            List<String> cleanText1 = Files.readAllLines(path);
            cleanText = String.join("\n", cleanText1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cleanText;
    }
}
