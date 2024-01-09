package Encryption;

import Alphabet.Alphabet;
import Texts.GetCleanText;
import Texts.GetKey;
import Texts.GetResultText;

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

        char[] encryptionText = new char[cleanList.length()]; //Переводим исходный текст в массив символов
        for (int i = 0; i < cleanList.length(); i++) {  // Цикл по длине текста:
            char currentChar = cleanList.charAt(i);   // Возвращаем символ исходного текста по индексу
            int charIndex = Arrays.binarySearch(alphabet,currentChar); //Ищем символ в алфавите и возвращаем индекс
            if (charIndex < 0) {                             //Если индекс символа в алфавите меньше нуля, то:
                encryptionText[i] = currentChar;            // Символ исходного текста присваивается элементу массива
            }
            else {                                          //Иначе:
                encryptionText[i] = alphabet[(charIndex + number) % alphabet.length]; // К индексу символа в алфавите прибавляем ключ и делим на количество элементов алфавита
            }
        }
        String result = new String(encryptionText);   // Создаем строку с зашифрованным текстом
        //Вызываем метод записи результата  и передаем строку с зашифрованным текстом
        GetResultText.getResultText(result);
        System.out.println(RESULT);
    }
}

