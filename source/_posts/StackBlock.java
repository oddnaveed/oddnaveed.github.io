import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;

public class StackBlock {
    private int s;  // capacity of the stack
    private Object[] stack;
    private int top;  // number of items in the stack
    // index of the top of the stack is (top-1)

    public StackBlock(final int s){
        if(s < 1){
            throw new IllegalArgumentException("Max elements cannot be less than 1, was: " + s);
        }
        this.s = s;
        stack = new Object[s];
        top = 0;
    }

    public boolean isEmpty(){
        return (top == 0);
    }

    public boolean isFull(){
        return (top >= stack.length);
    }

    public void push(Object o) throws Overflow{
        if(isFull()){
            throw new Overflow("the stack is full");
        }
        stack[top] = o;
        top++;
    }

    public Object examine() throws Underflow{
        if(isEmpty())
            throw new Underflow("the stack is empty");
        return stack[top-1];
    }

    public Object pop() throws Underflow{
        if(isEmpty())
            throw new Underflow("the stack is empty");
        top--;
        return stack[top];
    }
}

