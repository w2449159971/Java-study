import java.util.Stack;

public class MinStack {
    //定义两个栈分别用于存每个元素  和最小元素
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack(){
    }

    public void push(int x){
        normal.push(x);
        //判断如果最小栈为空则将当前元素压入最小栈
        if (min.empty()) {
            min.push(x);
        } else {   //如最小栈不为空 则判断最小栈中当前元素 和要压入的元素的大小  将小的一个压入最小栈
            int m = min.peek();
            if (x <= m){
                min.push(x);
            } else {
                min.push(m);
            }
        }
    }

    public void pop(){
        normal.pop();
        min.pop();
    }

    public int top(){
        return normal.peek();
    }

    public int getMin(){
        return min.peek();
    }

}