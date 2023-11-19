/**
 * Represents the Queue Abstract Data type.
 * @author Melanie
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface Queue<T> {
    /**
     * Checks to see this Queue is empty.
     * If it is empty, throw an IllegalArgumentException
     * @return true if Queue is empty, false if not
     */
    boolean isEmpty();
    /**
     * Adds data to the Queue. Think about what kind of object
     * this data should reside in and where it should go to satisfy
     * the FIFO (first in first out) characteristic of a Queue.
     * If data is null, throw an NullPointerException
     * @param data the data to add to the queue.
     */
    void enqueue(T data);
    /**
     * Removes an object from the Queue and returns the data that
     * object holds. Remember the FIFO characteristic of a Queue.
     * If the Queue is empty, utilize a previous method to handle this case
     * @return the dequeued item
     */
    T dequeue();
}