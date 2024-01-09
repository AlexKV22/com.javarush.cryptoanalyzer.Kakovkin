package Decoding;

import Alphabet.Alphabet;
import Texts.GetEncryptionText;
import Texts.GetKey;
import Texts.GetResultText;

import java.util.Arrays;

public class Decoding  {

    private static final String RESULT = new String("Готово. Проверьте файл.");
    public static char[] alphabet;
    public static String nonCleanList;
    public static int number;

    public Decoding() {

        //Вызываем алфавит
        alphabet = Alphabet.GetAlphabet();
        //Вызываем метод запроса исходного зашифрованного файла для шифрования
        nonCleanList = GetEncryptionText.getEncryptionText();
        //Вызываем метод запроса введения ключа для шифрования
        number = GetKey.getKey();
    }

    public void decoding() {

        char[] decodingText = new char[nonCleanList.length()];        // Все то же самое, что и в процессе шифрования, только для дешифровки мы не плюсуем, а вычитаем ключ
        for (int i = 0; i < nonCleanList.length(); i++) {
            char currentChar = nonCleanList.charAt(i);
            int charindex = Arrays.binarySearch(alphabet,currentChar);
            if (charindex < 0) {
                decodingText[i] = currentChar;
            }
            else {
                decodingText[i] = alphabet[(charindex - number) % alphabet.length];
            }
        }
        String result = new String(decodingText);

        //Вызывваем метод записи результата
        GetResultText.getResultText(result);
        System.out.println(RESULT);
    }
}
