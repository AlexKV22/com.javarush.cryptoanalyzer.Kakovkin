package decoding;

import alphabet.Alphabet;
import texts.GetEncryptionText;
import texts.GetKey;
import texts.GetResultText;

import java.util.Arrays;

public class Decoding  {

    private static final String RESULT = new String("Готово. Проверьте файл.");
    public static char[] alphabet;
    public static String nonCleanList;
    public static int number;

    public Decoding()  {

        //Вызываем алфавит
        alphabet = Alphabet.GetAlphabet();
        //Вызываем метод запроса исходного зашифрованного файла для шифрования
        nonCleanList = GetEncryptionText.getEncryptionText();
        //Вызываем метод запроса введения ключа для шифрования
        number = GetKey.getKey();
    }

    public void decoding() {

        char[] decodingText = new char[nonCleanList.length()];
        for (int i = 0; i < nonCleanList.length(); i++) {
            char currentChar = nonCleanList.toLowerCase().charAt(i);
            int charIndex = Arrays.binarySearch(alphabet,currentChar);
            if (charIndex < 0) {
                decodingText[i] = currentChar;
                System.out.println("Символ " + decodingText[i] + " не найден в алфавите и не будет расшифрован.");
            }

            else {
                decodingText[i] = alphabet[(charIndex - number + alphabet.length) % alphabet.length];
            }
        }
        String result = new String(decodingText);

        GetResultText.getResultText(result);
        System.out.println(RESULT);
    }
}










//decodingText[i] = (char) (charIndex - number < 0 ? Math.abs(alphabet.length + (charIndex - number)) : (charIndex - number) % alphabet.length);
//                decodingText[i] = alphabet[(charIndex - number) % alphabet.length];