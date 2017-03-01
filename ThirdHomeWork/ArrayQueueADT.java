// n - count of elements in sequence
// a[i] - sequence
public class ArrayQueueADT {
    // Inv: (n >= 0) && (a[i] != null for i = 0 .. n - 1)
    private int size = 0;
    private Object[] elements = new Object[5];
    private int head = 0;
    private int tail = 0;
    
    //Pre: true && queue != null
    public static String toStr(ArrayQueueADT queue) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < queue.size - 1; i++) {
            builder.append("'");
            builder.append(queue.elements[i].toString());
            builder.append("', ");
        }
        if (queue.size > 0) {
            builder.append("'" + queue.elements[queue.size - 1].toString() + "'");     
        }
        builder.append("]");           
        return builder.toString();    
    }
    //Post: R = ['head', ..., 'tail'] && (a' == a) && (n' == n)
    
    // Pre: element != null && queue != null
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;
        ensureCapacity(queue, ++queue.size + 1);
        queue.elements[queue.head] = element;
        queue.head = (queue.head + 1) % queue.elements.length;
    }
    // Post: (n' == n + 1) && (a'[i] == a[i] for i = 0 .. n - 1) && (a'[n] == element)

    // Pre: capacity > 0 && queue != null
    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity <= queue.elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < queue.size; i++) {
            newElements[i] = queue.elements[(i + queue.tail) % queue.elements.length];
        }
        queue.elements = newElements;
        queue.tail = 0;
        queue.head = queue.size - 1;
    }
    // Post: (capacity <= elements.length && elements' == elements) ||
    // (capacity > elements.length && elements'.length == (elements.length + 1) * 2) && (n' == n) && (a' = a)

    // Pre: n > 0 && queue != null
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;
        queue.size--;
        Object temp = queue.elements[queue.tail];
        queue.tail = (queue.tail + 1) % queue.elements.length;
        return temp;
    }
    // Post: (n' = n - 1) && (a'[i - 1] == a[i] for i = 1 .. n - 1) && (R == a[0])

    // Pre: n > 0 && queue != null
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[queue.tail];
    }
    // Post: (n' == n) && (a' = a) && (R == a[0])

    // Pre: true && queue != null
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }
    // Post: ((size == 0 && R == true) || (size != 0 && R == false)) && (n' == n) && (a' == a)

    // Pre: true && queue != null
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }
    // Pre: (R == n) && (n' == n) && (a' == a)

    // Pre: true && queue != null
    public static void clear(ArrayQueueADT queue) {
        for (int i = queue.tail; i < queue.head; i++) {
            queue.elements[i] = null;
        }
        queue.size = 0;
        queue.head = 0;
        queue.tail = 0;
    }
    // Post: n == 0
}
