import java.util.Random;

public class ExceptionDemo {
    
    static Random random = new Random();
    public static void a() {
        if (random.nextInt(5) == 0) {
            throw new RuntimeException("来自 a");
        }
    }
    public static void b() {
        a();
        if (random.nextInt(6) == 1) {
            throw new RuntimeException("来自 b");
        }
    }
    public static void c() {
        b();
        if (random.nextInt(6) == 2) {
            throw new RuntimeException("来自 c");
        }
    }
    public static void d() {
        c();
        if (random.nextInt(6) == 3) {
            throw new RuntimeException("来自 d");
        }
    }
    public static void e() {
        d();
        if (random.nextInt(6) == 4) {
            throw new RuntimeException("来自 e");
        }
    }

    public static void main(String[] args) {
        try {
            e();
            System.out.println("很幸运");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("=====================");
    }
}
