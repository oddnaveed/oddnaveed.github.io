import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic implements Deque {
    private int left, right, size, capacity;
    private Object[] queue;

    public DequeCyclic(final int s){
        left = right = size = 0;
        queue = new Object[s];
        capacity = s;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == capacity);
    }

    public void pushLeft(Object c) throws Overflow{
        if(isFull()){
            throw new Overflow("the queue is full");
        }
        else if(left == 0 && right == 0 && size == 0){
            queue[0] = c;  // empty queue
        }else{
            left = (left + 1) % queue.length;
            queue[left] = c;
        }
        size++;
    }

    public void pushRight(Object c) throws Overflow{
        if (isFull()) {
            throw new Overflow("the queue is full");
        }
        else if(left == 0 && right == 0 && size == 0){
            queue[0] = c;  //empty queue
        }
        else {
            right = (right+queue.length-1) % queue.length;
            queue[right] = c;
        }
        size++;
    }

    public Object peekLeft() throws Underflow{
        if(isEmpty()){
            throw new Underflow("the queue is empty");
        }
        return queue[left];
    }

    public Object peekRight() throws Underflow{
        if(isEmpty()){
            throw new Underflow("the queue is empty");
        }
        return queue[right];
    }

    public Object popLeft() throws Underflow{
        if(isEmpty()){
            throw new Underflow("the queue is empty");
        }
        Object temp;
        temp = queue[left];
        queue[left] = null;
        left = (left+queue.length-1) % queue.length;
        size--;
        return temp;
    }
    
    public Object popRight() throws Underflow{
        if(isEmpty()){
            throw new Underflow("the queue is empty");
        }
        Object temp;
        temp = queue[right];
        queue[right] = null;
        right = (right+1) % queue.length;
        size--;
        return temp;
    }
}