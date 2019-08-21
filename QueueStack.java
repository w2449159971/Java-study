import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈
public class QueueStack {
    //jilu当前队列的的元素个数
    int size;

    Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        size++;
        queue.add(x);
    }

    public int pop(){
        //先把前size-1 个数字  出队再入队
        for(int i = 0; i < queue.size() - 1; i++ ){

            queue.add( queue.poll());
        }
        size++;
        //将“栈顶”元素出栈
        return queue.poll();
    }

    public int top(){
        //先把前size-1 个数字  出队再入队
        for(int i = 1; i <= queue.size() - 1; i++ ){
            queue.add(queue.poll());
        }
        //记录“栈顶”元素 再将元素出队再入队
        int v =queue.element();
        queue.add(queue.poll());

        return v;
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}