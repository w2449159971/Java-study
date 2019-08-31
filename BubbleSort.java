class BubbleSort{
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            //ÎÞÐòÇø¼ä [0, array.length - i]
            boolean sorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break ;
            }
        }
  }
    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}