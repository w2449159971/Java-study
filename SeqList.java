//Sequence List
//顺序表中保存的元素类型谁是int
import java.util.Arrays;
public class SeqList { 
//属性
    private int[] array;  //保存数据
	private int size;     //保存array中已经有的数据个数
	
	//构造方法
    public SeqList(){
		//初始化部分
		//1.初始化array给一个固定大小
		//2.初始化size
		array = new int[11];
		size = 0;
	}
	
	//支持的方法
	//头插
	public void pushFront(int element) {
		//先不考虑array放不下
		//考虑array放不下
		ensureCapacity();
		//1.从后往前遍历 
		for(int i = size - 1; i >= 0; i--) {
			array[i+1] = array[i];
		}
		array[0] = element;
		size++;
	}
	
	//尾插
	public void pushBack(int element) {
		//先不考虑array放不下
		
		//考虑array放不下
		ensureCapacity();
		array[size++] = element;
	}
	
	//中间插入，给定下标
	public void insert(int index,int element) {
		//先不考虑array放不下
		//index的合法性
		if(index < 0 || index > size) {
			System.out.printf("index不合法");
		}
		//考虑array放不下
		ensureCapacity();
		
		for(int i = size-1; i >= index; i--) {
			array[i+1] = array[i];
		}
		array[index] = element;
		size ++;
	}
	
	//头删
	public void popFront() {
		//先不考虑size=0；
		
		//考虑size=0;
		if(size == 0) {
			System.out.println("顺序表为空无法删除");
			return ;
		}
		for(int i = 1; i <= size-1; i++) {
			array[i-1] = array[i];
		}
		array[--size] = 0;
	}
	
	//尾删
	public void popBack() {
		//先不考虑size=0；
		
		//考虑size=0;
		if(size == 0) {
			System.out.println("顺序表为空无法删除");
			return ;
		}
		array[--size] = 0;
	}
	
	public void erase(int index) {
		//先不考虑size=0；
		
		//考虑size=0;
		if(size == 0) {
			System.out.println("顺序表为空无法删除");
			return ;
		}
		//index的合法性
		if(index < 0 || index > size-1) {
			System.out.printf("下标不合法");
		}
		for(int i = index; i <= size-1; i++) {
			array[i] = array[i+1];
		}
		size --;
	}
	
	//查找
	public int indexOf(int element){
		for(int i = 0; i < size; i++) {
			if(array[i] == element){
				return i;
			}
		}
		return -1;
	}
	
	//根据下表获取元素
	public int get(int index) {
		if(index < 0 || index > size-1) {
			System.out.printf("index不合法");
			return -1;
		}
			return array[index];	
	}
	
	//给定下标，修改所在元素的值
	public int set(int index, int element) {
		array[index] = element;
		return 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int capacity() {
		return array.length;
	}
	
	//便于打印
	public String toString(){
		return Arrays.toString(Arrays.copyOf (array,size));
	}
	
	public void remove(int element) {
		int index = indexOf(element);
		if(index != -1) {
			erase(index);
		}
	}
	
	public void removeAll(int element) {
		/*int index;
		while((index = indexOf(element)) != -1) {
			erase(index);
		}*/
		
/*		int[] newArray = new int[size];
		int j = 0;
		for(int i = 0; i < size; i++) {
			if(array[i] != element) {
				newArray[j++] = array[i];
			}
		}
		//最后剩下的数又j个
		//把数据放回去，更新size
		for(int i = 0; i < j; i++) {
			array[i] = newArray[i];
		}
		size = j; */
		
		int j = 0;
		for(int i = 0; i < size; i++) {
			if(array[i] != element) {
				array[j++] = array[i];
			}
		}
		size = j;
	
	}
	
	//内部使用的方法
	//无论是否需要扩容 调用次保证空间够用
	private void ensureCapacity(){
		if(size < array.length) {  //无需扩容
			return ;
		}
		//扩容
		int newCapacity = array.length + array.length/2;
		int[] newArray = new int[newCapacity];
		for(int i = 0;i < array.length;i++) {
			newArray[i] = array[i];
		}
		this.array = newArray;
	}
	

	public static void main(String[] args) {
		SeqList seqList = new SeqList();
		
		System.out.println(seqList.toString());
		//尾插123；
		seqList.pushBack(1);
		seqList.pushBack(2);
		seqList.pushBack(3);
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//头插10 20 30 
		seqList.pushFront(10);
		seqList.pushFront(20);
		seqList.pushFront(30);
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		
		//中间插入 
		seqList.insert(2,100);
		seqList.insert(4,200);
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//头删
		seqList.popFront();
		seqList.popFront();
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//尾删
		seqList.popBack();
		seqList.popBack();
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//中间删除
		seqList.erase(2);
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//查找
		System.out.println("下标为"+seqList.indexOf(1));
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//获取元素
		System.out.printf("下标为%d的元素是%d%n",2,seqList.get(2));
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());
		
		//修改所在元素的值
		seqList.set(2,233);
		System.out.println(seqList.toString());
	}
}