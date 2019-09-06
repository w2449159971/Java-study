import java.util.HashMap;
import java.util.Map;

public class SingleNumber {


    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组中每一个数 计算出现了几次
        for (int n: nums) {
            int c = map.getOrDefault(n,0);
            map.put(n,c+1);
        }

        //判断数字出现了几次
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int n = entry.getKey();
            int c = entry.getValue();
            if (c == 1) {
                return n;
            }
        }
        return -1;
    }
}