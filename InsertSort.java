public class InsertSort{

public static void insertSortV1(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            //有序区间   [0,i]
            // 无序区间		[i + 1, array.length)
            // 待插入的数据是 array[i + 1]
            // 插入过程在有序区间内查找

            int key = array[i + 1];
            int j;
            for (j = i; j >= 0; j--) {
                if(key >= array[j]) {
                    break;
                }
            }
            //j + 1 放key的位置
            for (int k = i;k > j; k--) {
                array[k + 1] = array[k];
            }
            array[j + 1] = key;
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int key = array[i + 1];
            int j;
            for(j = i; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
}
