package Trees_and_Graphs;
import java.util.*;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have
 to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return 
the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them.
 If it is impossible to finish all courses, return an empty array.
*/
class CourseSchedule2 {
    /* for time and space complexity, refer to course schedule 1 */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer> courses = new ArrayList<>();
        Arrays.fill(inDegree, 0);
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            /* we care only about which course has a prerequisite */
            /* thus we are increasing the number of prerequisite for that course */
            inDegree[prerequisites[i][0]]++;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        /* add sink vertices to the stack */
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            courses.add(current);
            for (int i = 0; i < prerequisites.length; i++) {
                /* check if current is a prerequisite of a course */
                if (prerequisites[i][1] == current) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }

            }
        }
        if (courses.size() != numCourses) {
            return new int[0];
        }
        int[] orderedCourses = convertToArray(courses);
        return orderedCourses;
    }
    
    private int[] convertToArray(ArrayList<Integer> courses) {
        int[] arr = new int[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            arr[i] = courses.get(i);
        }
        return arr;
    }
}









