package interfaces;

import constants.Constans;

import java.util.Scanner;

public interface Key extends Alphabet {
    default int getKey()  {
        System.out.println("Укажите ключ для шифрования, только целое число от 0 до " + (getAlphabet().length -1));
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            throw new IllegalArgumentException(Constans.ERROR_MESSAGE);
        }
        int number = console.nextInt();
        if (number < 0 || number > getAlphabet().length -1) {
            throw new IllegalArgumentException(Constans.ERROR_MESSAGE);
        }
        return number;
    }
}
