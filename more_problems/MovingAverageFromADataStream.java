package more_problems;
import java.util.*;

/*
Given a stream of integers and a window size, calculate the moving average
 of all integers in the sliding window.
 Example:
    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1
    m.next(10) = (1 + 10) / 2
    m.next(3) = (1 + 10 + 3) / 3
    m.next(5) = (10 + 3 + 5) / 3

*/
/*
class MovingAverage {
    private LinkedList<Integer> input;
    private int windowSize;
    public MovingAverage(int size) {
        this.input = new LinkedList<>();
        this.windowSize = size;
    }
    
    public double next(int val) {
        input.add(val);
        if (this.input.size() < this.windowSize) {
            double size = 0;
            double sum = 0;
            Iterator<Integer> iter = input.listIterator(0);
            while (iter.hasNext()) {
                sum += iter.next();
                size++;
            }
            return sum/size;
        }
            
        double size = 0;
        double sum = 0;
        Iterator<Integer> iter = input.listIterator(input.size() - this.windowSize);
        while (iter.hasNext()) {
            sum += iter.next();
            size++;
        }
        return sum/size;
    }
}
*/
class MovingAverageFromADdataStream {
    private final Queue<Integer> window;
    private final int maxSize;
    private double sum = 0.0;

    public MovingAverage(int maxSize) {
        this.window = new ArrayDeque<>(maxSize + 1);
        this.maxSize = maxSize;
    }
    
    public double next(int val) {
        window.add(val);
        sum += val;
        if (window.size() > maxSize) {
            sum -= window.poll();
        }
        return sum / window.size();
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */