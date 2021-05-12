import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) throws Exception {
        String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        Map<Character,Integer> numberOfLetter = new HashMap<>();
        int count = 0;
        if (!str.matches("[A-Z]")) {
            throw new Exception("Invalid symbol");
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                    numberOfLetter.put(str.charAt(i), count);
                }
            }
        }
        System.out.println(numberOfLetter);
    }
}
