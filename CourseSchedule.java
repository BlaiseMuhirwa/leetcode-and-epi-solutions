package Trees_and_Graphs;
import java.util.*;


/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take
 course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you
 to finish all courses?

*/
class CourseSchedule {
    /* this solution uses topological sort of a directed acyclic graph 
     * It runs in O(V+E) where V is the number of vertices (numCourses) and E is the number of edges 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        int count = 0; /* count items in a topological order */
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
            count++;
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
        return count == numCourses;
        
    }
    

}

