import java.util.Arrays;

public class Heaps {
    /**
     * 前提：除了index和她的孩子外，其他位置已满足堆的性质
     * <p>
     * 经过向下调整，最终成为一个堆
     * @param array 被看作堆的数组
     * @param size  数组中被看作堆的值的个数
     * @param index 要调整位置得下标
     */
 //向下调整
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) { return; }
            int max = left;
            if (left + 1 < size) {
                if (array[left + 1] > array[left]) {
                    max = left + 1;
                }
            }
            if (array[index] >= array[max]) { return; }
            swap(array, index, max);
            index = max;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

//根据给定的一个数组  创建大堆
    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--){
            heapify(array,size,i);
        }
    }

//向上调整
    public static void adjustUp(int[] array, int index) {
        while(index > 0){
            int parent = (index - 1) / 2;
            if (array[index] > array[parent]) {
                swap(array,index,parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { -1, 8, 4, 6, 7, 2, 3, 1, 0 };
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));
        int[] array1 = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
        creatHeap(array1,array1.length);
        System.out.println(Arrays.toString(array1));
    }
}
