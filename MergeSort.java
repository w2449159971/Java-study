import java.util.Arrays;

public class MergeSort {
    public static void mergeSort (int[] array) {
        //在数组中从下标为0位置到下标最大位置区间内开始排序
       mergeSort1(array, 0, array.length);
    }

    private static void mergeSort1(int[] array, int low, int high) {
        //区间长度小于等于1就可停止划分
        int length = high - low;
        if (length <= 1) {
            return;
        }
        //将区间从中间分成两个小区间
        //分别对两个小区间进行归并
        int mid = (low + high) / 2;
        mergeSort1(array, low, mid);
        mergeSort1(array, mid, high);
        merge(array, low, mid, high);
    }

    //将已排好的数组合并起来
    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        //用左右两个引用遍历两个已排好序的数组 并进行比较 按顺序存入新的数组中
        int left = low;
        int right = mid;
        int extraLength =0;

        while(left < mid && right < high){
            if (array[left] <= array[right]) {
                extra[extraLength++] = array[left++];
            } else {
                extra[extraLength++] = array[right++];
            }
        }
        //一个已排好数组已经全部存入新数组而另一个还没有存完
        // 将这个数组的元素全部存入新数组 存入时顺序一定是已排好的
        while (left < mid) {
            extra[extraLength++] = array[left++];
        }
        while(right < high) {
            extra[extraLength++] = array[right++];
        }
        //将元素搬移回原数组
        for(int i = 0; i < length; i++){
            array[low + i] = extra[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 5, 1, 4, 8, 3, 7, 15, 6, 14, 9};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}