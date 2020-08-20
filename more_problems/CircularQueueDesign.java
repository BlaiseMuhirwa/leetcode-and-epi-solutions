package more_problems;
import java.util.*;

/*
Design your implementation of the circular queue. The circular queue is a linear data
 structure in which the operations are performed based on FIFO (First In First Out)
  principle and the last position is connected back to the first position to make a circle.
   It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front
 of the queue. In a normal queue, once the queue becomes full, we cannot insert the next
  element even if there is a space in front of the queue. But using the circular queue,
   we can use the space to store new values.

Your implementation should support following operations:

MyCircularQueue(k): Constructor, set the size of the queue to be k.
Front: Get the front item from the queue. If the queue is empty, return -1.
Rear: Get the last item from the queue. If the queue is empty, return -1.
enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular queue is empty or not.
isFull(): Checks whether the circular queue is full or not.
*/
public class CircularQueueDesign {
    private int[] queue;
    private int head;
    private int count;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        int tail = (this.head + this.count) % queue.length;
        queue[tail] = value;
        count++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        this.head = (this.head + 1) % this.queue.length;
        this.count--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0) return -1;
        return this.queue[this.head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0) return -1;
        int tail = (this.head + this.count -1) % this.queue.length;
        return this.queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.count == 0);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
       return (this.count == this.queue.length);
    }
}