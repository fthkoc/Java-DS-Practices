package List;

import java.util.Arrays;

public class ArrayList<E> {
    /** The default initial capacity. */
    private static final int INITIAL_CAPACITY = 256;

    /** Underlying data array. */
    private E[] theData;

    /** Current size. */
    private int size = 0;

    /** Current capacity. */
    private int capacity = 0;

    /** Constructor */
    public ArrayList() {
        this.capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[this.capacity];
    }

    public boolean add(E item) {
        if (this.size == this.capacity) {
            increaseListCapacity();
        }
        theData[size] = item;
        this.size++;
        return true;
    }

    public boolean add(int index, E item) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (this.size == this.capacity) {
            increaseListCapacity();
        }
        for (int i = size; i > index; i++) {
            theData[i] = theData[i - 1];
        }
        theData[index] = item;
        size++;
        return true;
    }

    public E get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public E set(int index, E newValue) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public E remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this.capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E result = theData[index];
        for (int i = index; i <= size; i++) {
            theData[i] = theData[i + 1];
        }
        size--;
        return result;
    }

    private void increaseListCapacity() {
        this.capacity *= 2;
        this.theData = Arrays.copyOf(this.theData, this.capacity);
    }
}
