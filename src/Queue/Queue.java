package Queue;


import LinkedList.LList;

public class Queue<T> implements IQueue<T> {

    LList<T> list;

    public Queue() {
        list = new LList();
    }

    @Override
    public void enqueue(T element) {
        list.insertBack(element);
    }

    @Override
    public T dequeue() {
        if(isEmpty()) throw new IllegalAccessError();

        T value = list.deleteFront();
        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new IllegalAccessError();

        return list.find(0);
    }

    @Override
    public void deleteQueue() {

        list.deleteList();

    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
