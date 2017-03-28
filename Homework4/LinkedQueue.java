/**
 * Created by Walingar on 21.03.2017.
 */
public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;

    protected void enqueueImpl(Object elem) {
        if (size == 0) {
            head = tail = new Node(null, elem);
        } else {
            tail.next = new Node(null, elem);
            tail = tail.next;
        }
    }

    protected Object elementImpl() {
        return head.value;
    }

    protected void dequeueImpl() {
        head = head.next;
        if (size == 0) {
            tail = null;
        }
    }

    protected void clearImpl() {
        head = tail = null;
    }

    private class Node {
        private Node next;
        private Object value;

        private Node(Node newNext, Object newValue) {
            next = newNext;
            value = newValue;
        }
    }

    public Object[] toArray() {
        Object[] totalArray = new Object[size];
        Node now = head;
        for (int i = 0; i < size; i++) {
            totalArray[i] = now.value;
            now = now.next;
        }
        return totalArray;
    }
}
