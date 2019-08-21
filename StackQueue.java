import java.util.Stack;

//用栈实现队列
//用两个栈实现一个队列
public class StackQueue {
    //定义两个栈
    //栈1主要用于元素入队  栈2主要用于元素出队
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        //将所有元素放进1栈
        stack1.push(x);
    }

    public int pop(){
        //从2栈出栈， 若2栈为空 将1栈中元素放入2栈 再从2栈出栈
        if(stack2.empty()) {
            while(!(stack1.empty())){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek(){
        //优先显示栈2顶的元素  若栈2为空 将栈1元素移到栈2
        if(stack2.empty()) {
            while(!(stack1.empty())){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }
}
