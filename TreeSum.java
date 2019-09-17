import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TreeSum {
    public static List<List<Integer>> treeSum (int[] nums) {
        //先将nums 排好序 方便后续操作
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //利用i j k 三个指引
        //i从第一个开始 到nums.length - 2  j 从i后一个开始 k从最后一个开始
        //如果nums[i] + nums[j] + nums[k] > 0 则 k--
        //如果nums[i] + nums[j] + nums[k] < 0 则 j++
        //如果等于0 则将三个数记录下来
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);

                    //为避免有重复的解 判断如果 i, j, k 要移动到的下一个数和当前相同  则多移动一次
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }

                while (j < k && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> r = treeSum(nums);
        System.out.println(r);
    }
}
