package interfaces;

import constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface WriteableInterface {
    default void writeText(String result) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_FILE);
        Path path = Path.of(scanner.nextLine());
            if (Files.notExists(path)) {
                throw new RuntimeException(Constants.ERROR_FILE);
            }
        try {
            Files.writeString(path, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Constants.RESULT);
    }

}
