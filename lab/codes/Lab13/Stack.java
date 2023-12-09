import java.util.ArrayList;
public class Stack<E> {
    private ArrayList<E> items = new ArrayList<E>();
    public void push(E item) {
        items.add(item);
    }
    public E pop() {
        return items.remove(items.size()-1);
    }
    public boolean hasItems() {
        if(items.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}