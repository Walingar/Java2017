// n - count of elements in sequence
// a[i] - sequence
public class ArrayQueue {
    // Inv: (n >= 0) && (a[i] != null for i = 0 .. n - 1)
    private static int size = 0;
    private Object[] elements = new Object[5];
    private int head = 0;
    private int tail = 0;
    
    //Pre: true
    public String toStr() {
        StringBuilder builder = new StringBuilder();
        builder.append("'");
        for(int i = 0; i < size - 1; i++) {
            builder.append("'");
            builder.append(elements[i].toString());
            builder.append("', ");
        }
        if (size > 0) {
            builder.append("'" + elements[size - 1].toString() + "'");     
        }
        builder.append("]");           
        return builder.toString();    
    }
    //Post: R = ['head', ..., 'tail'] && (a' == a) && (n' == n)
    
    // Pre: element != null
    public void enqueue(Object element) {
        assert element != null;
        ensureCapacity(++size + 1);
        elements[head] = element;
        head = (head + 1) % elements.length;
    }
    // Post: (n' == n + 1) && (a'[i] == a[i] for i = 0 .. n - 1) && (a'[n] == element)

    // Pre: capacity >= 0
    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(i + tail) % elements.length];
        }
        elements = newElements;
        tail = 0;
        head = size - 1;
    }
    // Post: (capacity <= elements.length && elements' == elements) ||
    // (capacity > elements.length && elements'.length == (elements.length + 1) * 2) && (n' == n) && (a' = a)

    // Pre: n > 0
    public Object dequeue() {
        assert size > 0;
        size--;
        Object temp = elements[tail];
        tail = (tail + 1) % elements.length;
        return temp;
    }
    // Post: (n' = n - 1) && (a'[i - 1] == a[i] for i = 1 .. n - 1) && (R == a[0])

    // Pre: n > 0
    public Object element() {
        assert size > 0;
        return elements[tail];
    }
    // Post: (n' == n) && (a' = a) && (R == a[0])

    // Pre: true
    public boolean isEmpty() {
        return size == 0;
    }
    // Post: ((size == 0 && R == true) || (size != 0 && R == false)) && (n' == n) && (a' == a)

    // Pre: true
    public int size() {
        return size;
    }
    // Pre: (R == n) && (n' == n) && (a' == a)

    // Pre: true
    public void clear() {
        size = head = tail = 0;
    }
    // Post: n == 0
}
