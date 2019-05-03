package Queue;

public interface IQueue<T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    void deleteQueue();
    boolean isEmpty();
}
