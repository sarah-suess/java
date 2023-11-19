/**
* Class that builds singly-Linked list of Nodes.
* @author mfrank40
* @version 11.0.16.1
* @param <T> parameter type
*/
public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    /**
    *No-arguement constructor that sets head and tail to null.
    */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
    *Returns string representation of the class.
    *@return string representation of the class
    */
    public String toString() {
        if (this.head == null) {
            return "";
        }
        String str = "[";
        Node<T> temp = this.head;
        while (temp.getNext() != null) {
            str = str.concat(temp.getData() + "] --> [");
            temp = temp.getNext();
        }
        str = str.concat(temp.getData() + "]");
        return str;
    }
    /**
    *Checks to see this Queue is empty.
    *@return true of false value
    */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
    /**
    *Adds data to the Queue.
    *@param data in generic form T
    */
    public void enqueue(T data) {
        if (data == null) {
            throw new NullPointerException("Data passed in is null.");
        }
        addToBack(data);
    }
    /**
    *Removed an object from the Queue.
    *@return data that removed object holds
    */
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Empty queue.");
        }
        return remove(0);
    }
    /**
    *Returns the size of the List.
    *@return return size of the list
    */
    public int size() {
        Node<T> temp = this.head;
        int size = 0;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }
    /**
    *Adds data to the List at the specified index.
    *@param index to add the data at
    *@param data in generic form T
    */
    public void add(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (data == null) {
            throw new NullPointerException("Data passed in is null.");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else if (index >= size()) {
            addToBack(data);
        } else {
            Node<T> currentNode = this.head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> temp = currentNode.getNext();
            currentNode.setNext(newNode);
            (currentNode.getNext()).setNext(temp);
        }
    }
    /**
    *Adds data to the back of the List.
    *@param data in generic form T
    */
    public void addToBack(T data) {
        if (data == null) {
            throw new NullPointerException("Data passed in is null.");
        }
        Node<T> newNode = new Node<>(data);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    /**
    *Removes the object at the specified index and returns the data that object holds.
    *@param index of specified object to be removed
    *@return data that object holds
    */
    public T remove(int index) {
        if (isEmpty() || (index < 0 || index >= size())) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (index == 0) {
            Node<T> temp = this.head;
            this.head = temp.getNext();
            if (this.head == null) {
                this.tail = null;
            }
            return temp.getData();
        } else if (index == (size() - 1)) {
            Node<T> currentNode = this.head;
            for (int i = 0; i < (size() - 2); i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> temp = this.tail;
            this.tail = currentNode;
            this.tail.setNext(null);
            return temp.getData();
        } else {
            Node<T> previous = this.head;
            for (int i = 1; i < index; i++) {
                previous = previous.getNext();
            }
            Node<T> currentNode = previous.getNext();
            previous.setNext(currentNode.getNext());
            return currentNode.getData();
        }
    }
    /**
    *Retrieves the data from the specified index and returns it.
    *@param index of data at specified point
    *@return data from specified index
    */
    public T get(int index) {
        if (isEmpty() || (index < 0 || index >= size())) {
            throw new IllegalArgumentException("Invalid index!");
        }
        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }
    /**
    *Replaces the data of the object at the specified index with the passed in data
    *and returns the data that was previously at that index.
    *@param index of data at specified point
    *@param data in generic form T
    *@return data previously at the index
    */
    public T set(int index, T data) {
        if (isEmpty() || (index < 0 || index >= size())) {
            throw new IllegalArgumentException("Invalid index!");
        } else if (data == null) {
            throw new NullPointerException("Data passed in is null.");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            T temp = this.head.getData();
            this.head.setData(newNode.getData());
            return temp;
        } else if (index == (size() - 1)) {
            T temp = this.tail.getData();
            this.tail.setData(newNode.getData());
            return temp;
        } else {
            Node<T> currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            T temp = currentNode.getData();
            currentNode.setData(newNode.getData());
            return temp;
        }
    }
    /**
    *Checks to see if the List contains the passed in data .
    *@param data in generic form T
    *@return true or false value
    */
    public boolean contains(T data) {
        if (data == null) {
            throw new NullPointerException("Null data cannot be in list.");
        }
        Node<T> currentNode = this.head;
        for (int i = 0; i < size(); i++) {
            if (currentNode.getData().equals(data)) {
                return true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }
    /**
    *Removes all elements from the List.
    */
    public void clear() {
        while (size() > 0) {
            remove(0);
        }
    }
    /**
    Returns a new List object containing the items in the List in a reverse order.
    *@return new List object
    */
    @Override
    public List<T> reverseLinkedList() {
        List<T> tempList = new LinkedList<>();
        if (isEmpty()) {
            return tempList;
        }
        if (size() == 1) {
            tempList.add(0, this.head.getData());
            return tempList;
        }
        Node<T> currentNode = this.head;
        for (int i = (size() - 1); i >= 0; i--) {
            tempList.add(i, currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return tempList;
    }
}