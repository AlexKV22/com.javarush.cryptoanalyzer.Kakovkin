
import Decoding.Decoding;
import Encryption.Encryption;
import HackBruteForce.HackBruteForce;

import java.util.Scanner;

public class Main {
    private static final String START_PROGRAM = new String("Выберите цифру функции программы:\n 1 - Шифрование.\n 2 - Дешифрование. \n 3 - Взлом с помощью Brute Force.");
    private static final String ERROR_MESSAGE = new String("Ошибка. Введите корректное число");

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Начало программы и проверка на ввод числа

        System.out.println(START_PROGRAM);
        int numberChoice = console.nextInt();

        if (numberChoice == 1) {
            //Вызываем  метод шифрования
            Encryption encryption = new Encryption();
            encryption.encryption();
        }

        else if (numberChoice == 2) {
            //Вызываем метод дешифрования
            Decoding decoding = new Decoding();
            decoding.decoding();
        }

        else if (numberChoice == 3) {
            //Вызываем метод взлома с помощью БрутФорс
            HackBruteForce hackBruteForce = new HackBruteForce();
            hackBruteForce.hackBruteForce();
        }

        else {
            System.out.println(ERROR_MESSAGE);
        }

    }

}
