
import decoding.Decoding;
import encryption.Encryption;
import hackCaesarCipher.HackCaesarCipher;
import constants.Constans;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner console = new Scanner(System.in);
        System.out.println(Constans.START_PROGRAM);
        switch (console.nextInt()) {
            case 1 : { new Encryption().encryption();
                       console.close();
                       break;
            }

            case 2 : { new Decoding().decoding();
                       console.close();
                       break;
            }

            case 3 : { new HackCaesarCipher().hackCaesarCipher();
                       console.close();
                       break;
            }
            default: System.err.println(Constans.ERROR_MESSAGE);
        }
    }
}
