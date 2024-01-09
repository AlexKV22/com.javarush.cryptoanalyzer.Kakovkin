package HackBruteForce;

import Alphabet.Alphabet;
import Texts.GetCleanText;
import Texts.GetEncryptionText;
import Texts.GetResultText;

import java.util.Arrays;
import java.util.List;

public class HackBruteForce {
    private static final String RESULT = new String("Готово. Проверьте файл");
    public static char[] alphabet;
    public static Character[] alphabet1;
    public static List<Character> alphabetList;
    public static String cleanList;
    public static char[] cleanList1;
    public static String nonCleanList;
    public static String[] plainText;

    public HackBruteForce() {
        //Получаем алфавит и переводим его в массив Character
        alphabet = Alphabet.GetAlphabet();
        alphabet1 = new Character[alphabet.length];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet1[i] = alphabet[i];
        }

        //Переводим массив Сharacter в список
        alphabetList = Arrays.asList(alphabet1);

        //Вызываем исходный текст и переводим его в массив символов
        cleanList = GetCleanText.getCleanText();
        cleanList1 = cleanList.toCharArray();

        //Вызываем зашифрованный текст
        nonCleanList = GetEncryptionText.getEncryptionText();

        plainText = new String[alphabet.length];

    }

    public static void hackBruteForce() {

        char[] message = nonCleanList.toLowerCase().toCharArray();
        for (int key = 0; key < alphabet.length; key++) {
            cleanList1 = new char[message.length];
            for (int i = 0; i < message.length; i++) {
                if (message[i] != ' ') {
                    cleanList1[i] = alphabet[(alphabetList.indexOf(message[i]) + key) % alphabet.length];
                } else {
                    cleanList1[i] = ' ';
                }
            }
            plainText[key] = String.valueOf(cleanList1);
        }

        for (String result : plainText) {
            if (result.equalsIgnoreCase(HackBruteForce.cleanList)) {
                GetResultText.getResultText(result);
                System.out.println(RESULT);
            }
        }
    }
}





