/**
 * Created by Walingar on 21.03.2017.
 */
// n - count of elements in sequence
// a - sequence
public interface Queue {
    // Inv: (n >= 0) && (a[i] != null for i = 0..n - 1)

    // Pre: (elem != null)
    void enqueue(Object elem);
    //Post: (n' == n + 1) && (a'[i] == a[i] for i = 0..n - 1) && (a'[n] == elem)

    // Pre: n > 0
    Object element();
    // Post: (n' == n) && (a'[i] == a[i] for i = 0...n - 1) && (Result == a[0])

    // Pre: n > 0
    Object dequeue();
    // Post: (n' == n - 1) && (a'[i - 1] == a[i] for i = 1...n - 1) && (Result == a[0])

    // Pre: true
    int size();
    // Post: (n' == n) && (a'[i] == a[i] for i = 0...n - 1) && (Result == n)

    // Pre: true
    boolean isEmpty();
    // Post: (n' == n) && (a'[i] == a[i] for i = 0...n - 1) && (Result == (n == 0))

    // Pre: true
    void clear();
    // Post: n' == 0

    // Pre: true
    Object[] toArray();
    // Post: (n' == n) && (a'[i] == a[i] for i = 0...n - 1) && (Result == [a[0] .. a[n - 1]])
}
