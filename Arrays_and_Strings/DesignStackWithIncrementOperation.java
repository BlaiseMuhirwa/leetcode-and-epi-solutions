package Arrays_and_Strings;

/**
 * Design a stack which supports the following operations.
 *
 * Implement the CustomStack class:
 *
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum
 * number of elements in the stack or do nothing if the stack reached the maxSize.
 *
 * void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
 * int pop() Pops and returns the top of stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val.
 * If there are less than k elements in the stack, just increment all the elements in the stack.
 */
public class DesignStackWithIncrementOperation {
    int[] stack;
    int index = 0;
    public DesignStackWithIncrementOperation(int maxSize) {
        this.stack = new int[maxSize];
        //this.size = maxSize;
    }

    public void push(int x) {
        if (index != stack.length) {
            this.stack[index] = x;
            index++;
        }
    }

    public int pop() {
        if (index == 0) return -1;
        int output = stack[index - 1];
        index--;
        return output;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < stack.length; i++) {
            if (k == 0) break;
            stack[i] += val;
            k--;
        }
    }
}
