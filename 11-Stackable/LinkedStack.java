import java.util.LinkedList;

public class LinkedStack implements IStackable {
    LinkedList <Integer> list= new LinkedList<Integer>();
    
    public int size () {
        return list.size();
    }

    public void push (int x ) {
        list.add(0,x);
    }
    
    public int pop () {
        int x = list.get(0);
        list.remove(0);
        return x;
    }
}
