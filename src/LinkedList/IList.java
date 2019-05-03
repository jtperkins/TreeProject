package LinkedList;

public interface IList<T> {
    void insertFront(T element);
    void insertBack(T element);
    void insertAt(int position, T element);
    T deleteFront();
    T deleteBack();
    T deleteAt(int position);
    void deleteList();
    int size();
    T find(int position);
}
