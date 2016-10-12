package test;

/**
 * Class contains method, which checks for the presence of words from the vocabulary.
 * Extends class Primary.
 */
public class WordFromVocabulary extends Primary {
    /**Constructor call super*/
    WordFromVocabulary(String str) {
        super(str);
    }

    String[] vocabulary = {"One", "Two", "Three", "Four", "Five"};

    /**
     * Method return true if match from vocabulary is found.
     * Case insensitive
     */
    @Override
    protected boolean checkMethod() {
        boolean b = false;
        for (String string : vocabulary) {
            if (str.contains(string)) {
                b = true;
                break;
            }
        }
        System.out.print("Words from vocabylary: ");
        return b;
    }
}
