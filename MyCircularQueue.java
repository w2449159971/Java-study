public class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        array = new int[k];
    }

    //入队
    public boolean enQueue (int value) {
        if (array.length == size) {
            return false;
        }

        array[rear] = value;
        rear = (rear + 1) % array.length;
        size ++;
        return true;
    }

    //出队
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        front = (front + 1) % array.length;
        size --;
        return true;
    }

    //返回队首
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return array[front];
    }

    //返回队尾
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        int index = (rear - 1 + array.length) % array.length;
        return array[index];
    }

    //判断队空
    public boolean isEmpty() {
        return size == 0;
    }

    //判断队满
    public boolean isFull() {
        return size == array.length;
    }
}
