package Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ListStack<E> implements IStack<E>{
    private List<E> theData;

    public ListStack() {
        theData = new ArrayList<E>();
    }

    @Override
    public E push(E item) {
        theData.add(item);
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData.get(theData.size() - 1);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return theData.remove(theData.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return theData.size() == 0;
    }
}
