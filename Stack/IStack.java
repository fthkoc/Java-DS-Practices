package Stack;

public interface IStack<E> {
    E push(E item);
    E peek();
    E pop();
    boolean isEmpty();
}
