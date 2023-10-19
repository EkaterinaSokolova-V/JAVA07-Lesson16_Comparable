import java.lang.reflect.Array;
import java.util.Arrays;

public class Anagramma {
    public static void main(String[] args) {
        //str1, str2, (int)a(97)-z(122)
        //amma mama - true
        //aaam mama - false

//        char c = 'a';
//        System.out.println((int)c);
        System.out.println(isAnagramma("amma", "mama"));
        System.out.println(isAnagramma("aama", "mama"));
    }
    static boolean isAnagramma(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] arr = new int[26];

        for (int i = 0; i < chars1.length; i++) {
            arr[(int)chars1[i] - (int)'a'] += 1;
            arr[(int)chars2[i] - (int)'a'] -= 1;
        }

        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
