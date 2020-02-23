package leetcode;

import java.util.*;

public class LetterCombinations {
    static Map<Character, List<String>> letters = new HashMap<>();
    static List<String> results = new ArrayList<>();
    static String source;

    public List<String> letterCombinations(String digits) {
        source = digits;
        letters.clear();
        results.clear();
        if (digits.equals("")) return results;
        letters.put('2', Arrays.asList("a", "b", "c"));
        letters.put('3', Arrays.asList("d", "e", "f"));
        letters.put('4', Arrays.asList("g", "h", "i"));
        letters.put('5', Arrays.asList("j", "k", "l"));
        letters.put('6', Arrays.asList("m", "n", "o"));
        letters.put('7', Arrays.asList("p", "q", "r", "s"));
        letters.put('8', Arrays.asList("t", "u", "v"));
        letters.put('9', Arrays.asList("w", "x", "y", "z"));

        putLetter(0, "");
        return results;
    }

    private void putLetter(int idx, String tmp) {
        if (idx == source.length()) {
            results.add(tmp);
            return;
        }
        for (String s : letters.get(source.charAt(idx))) {
            putLetter(idx + 1, tmp + s);
        }
    }
}
