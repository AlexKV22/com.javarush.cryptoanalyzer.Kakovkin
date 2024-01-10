package encryption;

import alphabet.Alphabet;
import texts.GetCleanText;
import texts.GetKey;
import texts.GetResultText;

import java.util.Arrays;

public class Encryption  {

    private static final String RESULT = new String("Готово. Проверьте файл.");
    public static char[] alphabet;
    public static String cleanList;
    public static int number;

    public Encryption() {
        //Вызываем алфавит
        alphabet = Alphabet.GetAlphabet();

        //Вызываем метод запроса текста из исходного файла для шифрования
        cleanList = GetCleanText.getCleanText();

        //Вызываем метод запроса введения ключа для шифрования
        number = GetKey.getKey();
    }
    public void encryption() {
        char[] encryptionText = new char[cleanList.length()];
        for (int i = 0; i < cleanList.length(); i++) {
        char currentChar = cleanList.toLowerCase().charAt(i);
        int charIndex = Arrays.binarySearch(alphabet,currentChar);
        if (charIndex < 0) {
        encryptionText[i] = currentChar;
        }
        else {
        encryptionText[i] = alphabet[(charIndex + number) % alphabet.length];
        }
        }
        String result = new String(encryptionText);
        GetResultText.getResultText(result);
        System.out.println(RESULT);
        }
    }














//    char[] encryptionText = new char[cleanList.length()];
//        for (int i = 0; i < cleanList.length(); i++) {
//        char currentChar = cleanList.toLowerCase().charAt(i);
//        int charIndex = Arrays.binarySearch(alphabet,currentChar);
//        if (charIndex < 0) {
//        encryptionText[i] = currentChar;
//        System.out.print(encryptionText[i]);
//        }
//        else {
//        encryptionText[i] = alphabet[(charIndex + number) % alphabet.length];
//        System.out.print(encryptionText[i]);
//        }
//        }
//        String result = new String(encryptionText);
//        GetResultText.getResultText(result);
//        System.out.println(RESULT);
//        }