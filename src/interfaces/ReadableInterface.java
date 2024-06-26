package interfaces;

import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public interface ReadableInterface {
     default String getText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_READ_FILE);
        Path path = Path.of(scanner.nextLine());
            if (Files.notExists(path)) {
                throw new RuntimeException(Constants.ERROR_FILE);
            }
        String finalText;
        try {
            List<String> cleanText = Files.readAllLines(path);
            finalText = String.join("\n", cleanText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return finalText;
    }
}
