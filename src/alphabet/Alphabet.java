package alphabet;

import java.util.Arrays;

public class Alphabet {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', ':', '!', '?', ' '};

    public static char[] GetAlphabet() {
        Arrays.sort(ALPHABET);
        return ALPHABET;
    }
}


//, '.', ',', '«', '»', '"', ':', '!', '?', ' '