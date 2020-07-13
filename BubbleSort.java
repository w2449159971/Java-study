class BubbleSort{
    //冒泡排序改进： 增加一个标志位判断本轮比较是否进行了交换
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            //范围[0, array.length - i]
            boolean sorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            //某一轮比较没有进行交换 即已经有序 可直接跳出
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
    
    //冒泡排序的基本实现
    public static void bubbleSortNormal(int[] array){
        int i,j;
        for(i=0;i<array.length-1;i++)
        {
            for(j=0;j<array.length-1-i;j++)
            {
                if(array[j]>array[j+1])
                {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    public static void main(String[] args){
        int[] array = {12, 3,2,7,4,1,8,6,9};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
