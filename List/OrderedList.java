package List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class OrderedList<E extends Comparable> implements Iterable<E> {
    private LinkedList<E> theList;

    public void add(E item) {
        ListIterator<E> it = theList.listIterator();
        while (it.hasNext()) {
            if (item.compareTo(it.next()) < 0) {
                it.previous();
                it.add(item);
                return;
            }
        }
        it.add(item);
    }

    public E get(int index) {
        return theList.get(index);
    }

    public int size() {
        return theList.size();
    }

    public boolean remove(E item) {
        return theList.remove(item);
    }

    @Override
    public Iterator<E> iterator() {
        return theList.iterator();
    }
}
