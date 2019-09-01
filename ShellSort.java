import java.util.Arrays;

public class ShellSort { 
   private static void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length - gap; i++) {
            int key = array[i + gap];
            int j;
            for (j = i; j >= 0 && key < array[j]; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    public static void shellSort (int[] array) {
        int gap = array.length;
        while(true) {
            gap = gap / 3 + 1;
            insertSortWithGap(array,gap);
            if(gap == 1) {
                return;
            }
        }
    }
}