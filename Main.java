package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class contains method, which call method of class Primary.
 * Class contains main method.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /**Input string*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        /**Classified instances of classes*/
        NoDigits noDigits  = new NoDigits(str);
        OnlyDigits onlyDigits = new OnlyDigits(str);
        MoreFiveWords moreFiveWords = new MoreFiveWords(str);
        WordFromVocabulary wordFromVocabulary = new WordFromVocabulary(str);

        print(noDigits);
        print(onlyDigits);
        print(moreFiveWords);
        print(wordFromVocabulary);
    }

    /**Method, which call method of class Primary.*/
    public static void print(Primary p) {
        System.out.println(p.checkMethod());
    }
}
