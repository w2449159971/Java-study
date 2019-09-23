import java.util.Arrays;

public class PrevPermOpt{
    //交换两个数的位置得到一个比原来的数字小中最大的一个数组
    //如果存在这样的交换 返回交换后的数组
    //若不存在则返回原数组
    public static int[] prevPermOpt1(int[] A) {
        //从后往前遍历找到第一个升序  将第一个升序的数字最为要交换的数
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                //找出再要交换数字后面第一个比它小中最大的数
                int max = i + 1;
                for (int j = i + 2; j < A.length; j++) {
                    if (A[j] < A[i] && A[j] > A[max]) {
                        max = j;
                    }
                }
                //交换两个数
                int t = A[i];
                A[i] = A[max];
                A[max] = t;
                return A;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 5, 5, 2, 3, 4, 4, 5, 6, 8 };
        System.out.println(Arrays.toString(prevPermOpt1(A)));
    }
}
