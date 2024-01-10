package texts;

import alphabet.Alphabet;

import java.io.IOException;
import java.util.Scanner;

public class GetKey {

    private static final String ASKING_KEY = new String("Укажите ключ для шифрования, только целое число от 0 до " + (Alphabet.GetAlphabet().length -1));
    private static final String ERROR = new String("Ошибка. Неверный ввод.");
    public static int getKey()  {
        System.out.println(ASKING_KEY);
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            System.out.println(ERROR);
        }
        int number = console.nextInt();
        if (number < 0 && number > Alphabet.GetAlphabet().length - 1) {
            System.out.println(ERROR);
        }
        return number;
    }
}
