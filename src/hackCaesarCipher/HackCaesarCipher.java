package hackCaesarCipher;

import alphabet.Alphabet;
import texts.GetCleanText;
import texts.GetEncryptionText;
import texts.GetKey;
import texts.GetResultText;

import java.util.Arrays;

public class HackCaesarCipher {
    private static final String RESULT = new String("Готово. Проверьте файл.");
    public static char[] alphabet;
    public static String nonCleanList;
    public static String cleanList;

    public HackCaesarCipher() {
        //Вызываем алфавит
        alphabet = Alphabet.GetAlphabet();
        //Вызываем метод запроса исходного зашифрованного файла для шифрования
        nonCleanList = GetEncryptionText.getEncryptionText();
        //Вызываем метод запроса текста из исходного файла для шифрования
        cleanList = GetCleanText.getCleanText();
    }

    public void hackcaesarCipher() {
        char[] decodingText = new char[nonCleanList.length()];
        for (int shift = 0; shift < alphabet.length; shift++) {
            for (int i = 0; i < nonCleanList.length(); i++) {
                char currentChar = nonCleanList.toLowerCase().charAt(i);
                int charIndex = Arrays.binarySearch(alphabet, currentChar);
                if (charIndex < 0) {
                    decodingText[i] = currentChar;
                }
                else {
                    decodingText[i] = alphabet[(charIndex - shift + alphabet.length) % alphabet.length];
                    String result = new String(decodingText);
                    if (result.equalsIgnoreCase(cleanList)) {
                        GetResultText.getResultText(result);
                }
            }
            }
        }
    }
}
