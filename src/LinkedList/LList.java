package LinkedList;

import java.util.Iterator;

public class LList<T> implements IList<T>, Iterable<T> {

    private Node head;
    private Node tail;
    private int count;

    public LList() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void insertFront(T element) {
        if (element == null) throw new IllegalArgumentException();

        // Make a new node
        Node node = new Node(element);

        // Refer node next to head
        node.next = head;

        head = node;

        // If list was empty then tail will be null
        if (tail == null) tail = head;

        count++;
    }

    @Override
    public void insertBack(T element) {
        if (element == null) throw new IllegalArgumentException();

        // Make a new node
        Node node = new Node(element);

        // Refer last node to new node if list is not empty
        if (tail != null) {
            tail.next = node;
            // Move tail to node
            tail = node;
        }
        else { // list was empty
            tail = node;
            head = node;
        }

        count++;
    }

    @Override
    public void insertAt(int position, T element) {
        if (position < 0 || position > count)
            throw new IndexOutOfBoundsException();
        if (element == null) throw new IllegalArgumentException();

        if (position == 0) {
            insertFront(element);
            return;
        }
        if (position == count) {
            insertBack(element);
            return;
        }

        // Make a new node
        Node node = new Node(element);

        // curr will point to the node inserting after
        Node curr = head;
        for(int i = 1; i < position; i++) {
            curr = curr.next;
        }

        // insert node after curr
        node.next = curr.next;
        curr.next = node;

        count++;
    }

    @Override
    public T deleteFront() {
        if (count == 0) throw new IllegalAccessError();

        // Get the value of the node at the front
        T val = head.value;

        head = head.next;
        if (head == null)
            tail = null;
        count--;
        return val;
    }

    @Override
    public T deleteBack() {
        if (count == 0) throw new IllegalAccessError();

        // Get the value of the node at the back
        T val = tail.value;

        // Check if one node
        if(count == 1) {
            head = null;
            tail = null;
            count = 0;
            return val;
        }

        // More than one node
        // curr will point to the node before tale
        Node curr = head;
        for(int i = 1; i < count - 1; i++) {
            curr = curr.next;
        }
        tail = curr;
        tail.next = null;
        count--;
        return val;
    }

    @Override
    public T deleteAt(int position) {
        if (count == 0) throw new IllegalAccessError();

        if (position < 0 || position > count - 1)
            throw new IndexOutOfBoundsException();

        if (position == 0) return deleteFront();
        if (position == count - 1) return deleteBack();

        // curr will point to the node before deleting
        Node curr = head;
        for(int i = 1; i < position; i++) {
            curr = curr.next;
        }

        T value = curr.next.value;

        // delete node after curr
        curr.next = curr.next.next;

        count--;

        return value;
    }

    @Override
    public void deleteList() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public T find(int position) {
        if (position >= count) throw new IndexOutOfBoundsException();

        // curr will point to the node that we want
        Node curr = head;
        for(int i = 0; i < position; i++) {
            curr = curr.next;
        }

        return curr.value;
    }

    @Override
    public ListIterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        Node curr = head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            if(curr == null) throw new IllegalAccessError();
            T val = curr.value;
            curr = curr.next;
            return val;
        }
    }

    private class Node {

        T value;
        Node next;

        Node() {
            value = null;
            next = null;
        }

        Node(T value) {
            this.value = value;
            next = null;
        }
    }
}
