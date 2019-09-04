import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        //ÖØ¸´ÔªËØ
        set.add("hello");
        set.add("i");
        set.add("love");
        set.add("java");
        System.out.println(set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}