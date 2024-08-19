import java.util.ArrayList;
public class Queue<E> {
    private ArrayList<E> items = new ArrayList<E>();
    public void enqueue(E item) {
        items.add(item);
    }
    public E dequeue() {
        return items.remove(0);
    }
    public boolean hasItems() {
        if(items.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}