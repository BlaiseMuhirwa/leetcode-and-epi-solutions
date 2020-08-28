package Trees_and_Graphs;
import java.util.*;

public class DijkstraShortestPathAlgorithm {
    private int[] dist;
    private Set<Integer> explored;
    private int vertices;
    private List<List<Vertex>> adj; 
    private PriorityQueue<Vertex> heap;

    public DijkstraShortestPathAlgorithm(int vertices) {
        this.vertices = vertices;
        dist = new int[vertices];
        explored = new HashSet<Integer>();
        heap = new PriorityQueue<Vertex>(vertices, new Vertex());
    }

    public void dijkstra(List<List<Vertex>> adj, int src) {
        this.adj = adj;
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        while (explored.size() != vertices) {
            /* remove the min distance vertex from the priority queue */
            int minVertex = heap.remove().getNode();
            /* adding the node whose distance is finalized */
            explored.add(minVertex);
            processNeighbors(minVertex);
        }
    }

    public void processNeighbors(int vertex) {
        int edgeDistance = -1;
        int newDistance = -1;

        /* all neighbors of vertex */
        for (int i = 0; i < adj.get(vertex).size(); i++) {
            Vertex v = adj.get(vertex).get(i);
            
            /* if current vertext hasn't already been processed */
            if (!explored.contains(v.getNode())) {
                edgeDistance = v.getWeight();
                newDistance = dist[vertex] + edgeDistance;
                
                /* if new distance is cheaper in terms of weight */
                if (newDistance < dist[v.getNode()]) {
                    dist[v.getNode()] = newDistance;
                }
                heap.add(new Vertex(v.getNode(), dist[v.getNode()]));
            }
        }
    }
    private static void main(String[] args) {
        int V = 5; 
        int source = 0; 
  
        // Adjacency list representation of the  
        // connected edges 
        List<List<Vertex> > adj = new ArrayList<List<Vertex> >(); 
  
        // Initialize list for every node 
        for (int i = 0; i < V; i++) { 
            List<Vertex> item = new ArrayList<Vertex>(); 
            adj.add(item); 
        } 
  
        // Inputs for the DPQ graph 
        adj.get(0).add(new Vertex(1, 9)); 
        adj.get(0).add(new Vertex(2, 6)); 
        adj.get(0).add(new Vertex(3, 5)); 
        adj.get(0).add(new Vertex(4, 3)); 
  
        adj.get(2).add(new Vertex(1, 2)); 
        adj.get(2).add(new Vertex(3, 4)); 
  
        // Calculate the single source shortest path 
        DijkstraShortestPathAlgorithm dpq = new DijkstraShortestPathAlgorithm(V); 
        dpq.dijkstra(adj, source); 
  
        // Print the shortest path to all the nodes 
        // from the source node 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]);
    }
}

class Vertex implements Comparator<Vertex> {
    private int node;
    private int weight;

    public Vertex() {
    }
    public Vertex(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Vertex v1, Vertex v2) {
        if (v1.getWeight() < v2.getWeight()) {
            return -1;
        } else if (v1.getWeight() > v2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
     * @return int return the node
     */
    public int getNode() {
        return node;
    }
    /**
     * @return int return the weight
     */
    public int getWeight() {
        return weight;
    }


}