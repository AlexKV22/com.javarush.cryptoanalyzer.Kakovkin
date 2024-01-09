package Texts;

import java.util.Scanner;

public class GetKey {

    private static final String ASKING_KEY = new String("Укажите ключ для шифрования, только целое число:");
    private static final String ERROR = new String("Ошибка. Файл не найден.");
    public static int getKey() {
        System.out.println(ASKING_KEY);
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            System.out.println(ERROR);
        }
        int number = console.nextInt();
        return number;
    }
}
