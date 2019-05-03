package Stack;

import LinkedList.LList;

public class Stack<T> implements IStack<T> {

    private LList<T> list;

    public Stack() {
        list = new LList<T>();
    }
    @Override
    public void push(T element) {
        list.insertFront(element);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new IllegalAccessError();

        return list.deleteFront();
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new IllegalAccessError();

        return list.find(0);
    }

    @Override
    public void deleteStack() {
        list.deleteList();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
