package List;

import java.util.Iterator;

public class SingleLinkedList<E> implements Iterable<E>{
    private Node<E> head = null;
    private int size = 0;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E item) {
            this(item, null);
        }

        private Node(E item, Node<E> nodeRef) {
            this.data = item;
            this.next = nodeRef;
        }
    }

    private class SLLIterator implements Iterator<E> {
        Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                E temp = current.data;
                current = current.next;
                return temp;
            }
            else
                return null;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E set(int index, E newValue) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index == 0) {
            addFirst(element);
        }
        else {
            Node<E> prevNode = getNode(index - 1);
            addAfter(prevNode, element);
        }
    }

    public boolean add(E element) {
        add(size, element);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new SLLIterator();
    }

    private Node<E> getNode(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        }
        else
            return null;
    }

    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else
            return null;
    }

    @Override
    public String toString() {
        Node<E> nodeRef = head;
        StringBuilder result = new StringBuilder();

        while (nodeRef != null) {
            result.append(nodeRef.data);
            if (nodeRef.next != null) {
                result.append(" ==> ");
            }
            nodeRef = nodeRef.next;
        }

        return result.toString();
    }
}
