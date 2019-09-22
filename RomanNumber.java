import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RomanNumber {
    // I:1  V:5  X:10  L:50  C:100 D:500  M:1000
    public static int romanToInt(String s) {
        //用一个 map 记录罗马数字对应的值
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //记录特殊的罗马数字 如 IV：4
        HashMap<Character, List<Character>> special = new HashMap<>();
        special.put('I', Arrays.asList('V','X'));
        special.put('X', Arrays.asList('L','C'));
        special.put('C', Arrays.asList('D','M'));
        int n = 0;
        //按字符来一个一个判断它们的值
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断是否为特殊的罗马数字
            if (i < s.length() - 1){
                char next = s.charAt(i + 1);
                if (special.containsKey(c)) {  
                    if (special.get(c).contains(next)) {
                        //计算特殊值
                        int nextInt = map.get(next);
                        int curInt = map.get(c);
                        n += (nextInt - curInt);
                        i++;
                        continue;
                    }
                }
            }
            //计算罗马数字的值
            int curInt = map.get(c);
            n += curInt;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));     // 1
        System.out.println(romanToInt("II"));    // 2
        System.out.println(romanToInt("III"));   // 3
        System.out.println(romanToInt("IV"));    // 4
        System.out.println(romanToInt("VI"));    // 6
        System.out.println(romanToInt("IX"));    // 9
        System.out.println(romanToInt("MCMXCIV"));   // 1994
        System.out.println(romanToInt("MMMCMXCIX")); // 3999
    }
}
