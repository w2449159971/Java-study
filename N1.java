import java.util.Arrays;

public class N1 {
    //TwoSum
    //给定一个数组和一个目标值
    //在数组中找出相加等于目标值的两个数  返回这两个值的数组下标
    //假设一个数组中只会出现一组答案
    public static int[] twoSum (int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
}