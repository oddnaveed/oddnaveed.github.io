import CITS2200.*; 

public class ListLinked implements CITS2200.List{
    private Link before;
    private Link after;

    public ListLinked(){
        after = new Link(null, null);
        before = new Link(null, after);
    }

    private class Link{
        private Object item;
        private Link successor;

        public Link(Object e, Link s){
            item = e;
            successor = s;
        }
    }

    private class WindowLinked{
        private Link link;

        public WindowLinked(){
            link = new Link(null, null);
        }
    }


    public boolean isEmpty(){
        return before.successor == after;
    }

    public boolean isBeforeFirst(WindowLinked w){
        return w.link == before;
    }

    public boolean isAfterLast(WindowLinked w){
        return w.link == after;
    }

    /**
     * 
     * @param w
     * @return
     * @throws OutOfBounds if w is over the before first or after last postiion,
     * otherwise deletes and returns the element under w, and places w over the next element
     */
    public Object delete(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w)){
            throw new OutOfBounds("cannot delete at this point");
        }
        Object item = w.link.item;
        Link next = w.link.successor;
        w.link.item = next.item;
        w.link.successor = next.successor;
        if(next == after){
            after = w.link;
        }
        return item;
    }

    /**
     * throws an exeption if w is over the before first or after last position,
     * otherwise repalces the element under w with e and returns the old element
     */
    public Object replace(Object e, WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w))
            throw new OutOfBound("cannot replace at this point");
        Object item = w.link.item;
        w.link.item = e;
        return item;
    }

    public Object examine(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w) || isAfterLast(w))
            throw new OutOfBounds("cannot retrieve data here");
        return w.link.item;
    }

    /**
     * 
     * @param e
     * @param w
     * @throws OutOfBound if w is over the before first position
     * otherwise insert an element before w
     */
    public void insertBefore(Object e, WindowLinked w) throws OutOfBound{
        if(isBeforeFirst(w))
            throw new OutOfBound("cannot insert before this point");
        w.link.successor = new Link(w.link.item, w.link.successor);
        if(isAfterLast(w))
            after = w.link.successor;
        w.link.item = e;
        w.link = w.link.successor; // move the window pointer back to original place
    }

    /**
     * throws OutOfBound if w is over after last position
     * otherwise insert an element after w
     */
    public void insertAfter(Object e, WindowLinked w) throws OutOfBound{
        if(isAfterLast(w))
            throw new OutOfBound("cannot insert after this point");
        w.link.successor = new Link(e, w.link.successor);
    }

    /**
     * 
     * @param w
     * @throws OutOfBounds if w is over before first position,
     * otherwise move w to the previous window position
     */
    public void previous(WindowLinked w) throws OutOfBounds{
        if(isBeforeFirst(w))
            throw new OutOfBound("w is the start of the list");
        Link current = before;
        while(current.successor != w.link){
            current = current.successor;
        }
        w.link = current;
    }

    /**
     * @throws OutOfBounds if w is over after last position
     * otherwise move w to the next window posiiton
     */
    public void next(WindowLinked w) throws OutOfBounds{
        if(isAfterLast(w))
            throw new OutOfBound("w is the end of the list");
        w.link = w.link.successor;
    }

    /**
     * initialises w to the after last position
     */
    public void afterLast(WindowLinked w){
        w.link = after;
    }

    /**
     * initialises w to the before first position
     * @param w
     */
    public void beforeFirst(WindowLinkded w){
        w.link = before;
    }

    public String toString(){
        String a = "";
        Link current = before;
        while(current != null){
            a += current.item + ",";
            current = current.successor;
        }
        return a;
    }
}