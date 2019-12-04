import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "I");
        map.put(3, "love");
        map.put(5, "java");
        System.out.println(map);
        //根据key获取value
        System.out.println(map.get(2));
        //map 中不存在的key返回 null
        System.out.println(map.get(101));
        //map中不存在的key 返回默认值
        System.out.println(map.getOrDefault(101,"like"));
        //默认值不会放入map中
        System.out.println(map);

        //打印所有key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        //打印所有value
        for (String value : map.values()) {
            System.out.println(value);
        }
        //按 key - value 映射关系打印   打印的顺序是随机的 
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
