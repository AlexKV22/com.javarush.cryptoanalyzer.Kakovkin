package interfaces;

import java.util.Arrays;

public interface Alphabet {
     char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', ':', '!', '?', ' ', '(', ')'};

     default char[] getAlphabet() {
         Arrays.sort(ALPHABET);
         return ALPHABET;
     }
}
