package more_problems;

import java.util.*;

public class IteratorImplementation {
    private static List<List<Integer>> testCase = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        testCase.add(new LinkedList<>(Arrays.asList(1, 4, 5, 8, 9)));
        testCase.add(new LinkedList<>(Arrays.asList(3, 4, 4, 6)));
        testCase.add(new LinkedList<>(Arrays.asList(0, 2, 8)));

        ComplexIterator iterator = new ComplexIterator(testCase);
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" ");
        }
    }

}

class ComplexIterator implements Iterator {
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.get(0) - b.get(0));
    public ComplexIterator(List<List<Integer>> input) {
        if (input == null || input.size() == 0) return;
        for(List<Integer> list : input) {
            if (list != null) pq.add(list);
        }
    }
    @Override
    public boolean hasNext() {
        return pq.size() > 0;
    }

    @Override
    public Integer next() {
        Integer output = null;
        if (hasNext()) {
            List<Integer> current = pq.poll();
            output = current.get(0);
            current.remove(0);
            if (current != null && current.size() > 0) pq.add(current);
        }
        return output;
    }
}
