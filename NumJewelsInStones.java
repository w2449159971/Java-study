import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones (String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char ch : J.toCharArray()) {
            jewels.add(ch);
        }
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (jewels.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}