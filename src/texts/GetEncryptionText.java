package texts;

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
        System.out.println(ASKING_FILE);
        Path path = Path.of(scanner.nextLine());
        try {
            if (Files.notExists(path)) {
            }
        }
        catch (Exception e) {
            throw new RuntimeException(ERROR);
        }

        String nonСleanText;
        try {
            List < String > nonСleanText1 = Files.readAllLines(path);
            nonСleanText = String.join("\n", nonСleanText1);
        }
            catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nonСleanText;
    }
}

