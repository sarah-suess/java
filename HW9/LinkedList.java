public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    //toString methods

    //List methods first

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int size = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            Node<T> current = head;
            while (current != null) {
                size++;
                current = current.getNext();
            }
        }
        return size;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else if (data == null) {
            NullPointerException npe = new NullPointerException("Data passed in is null.");
            throw npe;
        } else {
            Node<T> prev = this.getNode(index-1);
            Node<T> after = this.getNode(index);
            Node<T> add = new Node<T>(data);
            prev.setNext(add);
            add.setNext(after);
        }
    }

    public void addToBack(T d) {
        if (d == null) {
            NullPointerException npe = new NullPointerException("Data passed in is null.");
            throw npe;  
        }
        Node<T> add = new Node<T>(d);
        if (tail != null) {
            tail.setNext(add);
            tail = add;
        } else {
            head = add;
            tail = add;
        }
    }

    public T remove(int index) {
        if (this.isEmpty() || index < 0 || index >= this.size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else {
            Node<T> remove = getNode(index);
            T data = remove.getData();

            Node<T> prev = getNode(index-1);
            Node<T> next = getNode(index);

            prev.setNext(next);
            return data;
        }
    }

    public void removeVoid(int index) {
        if (this.isEmpty() || index < 0 || index >= this.size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else {
            Node<T> remove = getNode(index);
            T data = remove.getData();

            Node<T> prev = getNode(index-1);
            Node<T> next = getNode(index);

            prev.setNext(next);
        }
    }

    public T get(int index) {
        int start = 0;
        if (this.isEmpty() || index < 0 || index >= this.size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else {
            Node<T> current = head;
            while (start != index) {
                start++;
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public Node<T> getNode(int index) {
        int start = 0;
        if (this.isEmpty() || index < 0 || index >= this.size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else {
            Node<T> current = head;
            while (start != index) {
                start++;
                current = current.getNext();
            }
            return current;
        }
    }

    public T set(int index, T data) {
        if (this.isEmpty() || index < 0 || index >= this.size()) {
            IllegalArgumentException iae = new IllegalArgumentException("Invalid index!");
            throw iae;
        } else if (data == null) {
            NullPointerException npe = new NullPointerException("Data passed in is null.");
            throw npe;
        } else {
            Node<T> change = getNode(index);
            T returnData = change.getData();
            change.setData(data);
            return returnData;
        }
    }

    public boolean contains(T d) {
        if (isEmpty()) {
            return false;
        } else if (d == null) {
            NullPointerException npe = new NullPointerException("Null data cannot be in list");
            throw npe;
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData() == d) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void clear() {
        int start = 0;
        if (isEmpty()) {
            return;
        } else {
            while (start != size()) {
                removeVoid(start);
                start++;
            }
        }
    }

    public List<T> reverseLinkedList() {
        List<T> linkedlist= new LinkedList<>();
        return linkedlist;
    }
}