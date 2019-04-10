package Stack;

import java.util.Arrays;

public class ArrayStack<E> implements IStack<E>{
    private int capacity;
    private int size;
    private E[] array;

    public ArrayStack() {
        this(64);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = (E[]) new Object[this.capacity];
    }

    @Override
    public E push(E item) {
        if (size == capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public E peek() {
        return array[size - 1];
    }

    @Override
    public E pop() {
        return array[--size];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
