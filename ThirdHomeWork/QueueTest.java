
public class QueueTest {
    public static void fill(ArrayQueue queue, ArrayQueueADT queueADT) {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.enqueue(i);
            ArrayQueueADT.enqueue(queueADT, i);
            queue.enqueue(i);
        }
    }

    public static void dump(ArrayQueue queue, ArrayQueueADT queueADT) {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(ArrayQueueModule.size() + " " + ArrayQueueModule.element() + " " + ArrayQueueModule.dequeue());
            System.out.println(ArrayQueueADT.size(queueADT) + " " + ArrayQueueADT.element(queueADT) + " " + ArrayQueueADT.dequeue(queueADT));
            System.out.println(queue.size() + " " + queue.element() + " " + queue.dequeue());
        }
    }

    public static void main(String[] args) {
        ArrayQueueADT queueADT = new ArrayQueueADT();
        ArrayQueue queue = new ArrayQueue();
        fill(queue, queueADT);
        dump(queue, queueADT);
    }
}