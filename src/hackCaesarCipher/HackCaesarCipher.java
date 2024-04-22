package hackCaesarCipher;
import constants.Constants;
import interfaces.ReadableInterface;
import interfaces.WriteableInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class HackCaesarCipher implements interfaces.Alphabet, ReadableInterface, WriteableInterface {
    private char[] alphabet;
    private String codeText;
    private String result;
    private Path path;

    public HackCaesarCipher() {
        alphabet = getAlphabet();
        codeText = getText();
    }

    public void hackCaesarCipher() {
        path = getPathOfWriteResult();
        char[] decodingText = new char[codeText.length()];
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < codeText.length(); j++) {
                char currentChar = codeText.toLowerCase().charAt(j);
                int charIndex = Arrays.binarySearch(alphabet, currentChar);
                if (charIndex < 0) {
                    decodingText[j] = currentChar;
                    System.out.println("Символ " + decodingText[j] + " не найден в алфавите и не будет взломан.");
                }
                else {
                    decodingText[j] = alphabet[(charIndex - i + alphabet.length) % alphabet.length];
                }
            }
            result = new String(decodingText);
            try {
                Files.writeString(path, result + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(Constants.ERROR_WRITING_FILE);
        }
    }
        System.out.println(Constants.RESULT);
}

    public Path getPathOfWriteResult() {
        System.out.println(Constants.ASKING_FILE);
        Scanner scanner = new Scanner(System.in);
        Path pathOfWrite = Path.of(scanner.nextLine());
        if (Files.notExists(pathOfWrite)) {
            throw new RuntimeException(Constants.ERROR_FILE);
        }
        return pathOfWrite;
    }
}
