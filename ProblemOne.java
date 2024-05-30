//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemOne {
    private static class Graph {
        private int divinagraciaVertices;
        private List<List<Integer>> divinagraciaAdjacencyList;

        public Graph(int divinagraciaVertices) {
            this.divinagraciaVertices = divinagraciaVertices;
            divinagraciaAdjacencyList = new ArrayList<>(divinagraciaVertices);
            for (int i = 0; i < divinagraciaVertices; i++) {
                divinagraciaAdjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int divinagraciaU, int divinagraciaV) {
            divinagraciaAdjacencyList.get(divinagraciaU).add(divinagraciaV);
            divinagraciaAdjacencyList.get(divinagraciaV).add(divinagraciaU);
        }

        public List<Integer> getNeighbors(int divinagraciaV) {
            return divinagraciaAdjacencyList.get(divinagraciaV);
        }

        public int getVertices() {
            return divinagraciaVertices;
        }
    }

    public static void main(String[] args) {
        Scanner divinagraciaSC = new Scanner(System.in);

        // Input: Number of vertices
        System.out.print("Enter the number of vertices: ");
        int divinagraciaVertices = divinagraciaSC.nextInt();

        // Create the graph
        Graph graph = new Graph(divinagraciaVertices);

        // Input: Number of edges
        System.out.print("Enter the number of edges: ");
        int divinagraciaEdgeCount = divinagraciaSC.nextInt();

        // Input: List of edges
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < divinagraciaEdgeCount; i++) {
            int divinagraciaU = divinagraciaSC.nextInt();
            int divinagraciaV = divinagraciaSC.nextInt();
            graph.addEdge(divinagraciaU, divinagraciaV);
        }

        // Check if the graph is connected and find the number of connected components
        boolean[] divinagraciaVisited = new boolean[divinagraciaVertices];
        int divinagraciaComponents = 0;

        for (int i = 0; i < divinagraciaVertices; i++) {
            if (!divinagraciaVisited[i]) {
                divinagraciaComponents++;
                bfs(graph, i, divinagraciaVisited);
            }
        }

        if (divinagraciaComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + divinagraciaComponents);
        }
    }

    private static void bfs(Graph graph, int divinagraciaStart, boolean[] divinagraciaVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(divinagraciaStart);
        divinagraciaVisited[divinagraciaStart] = true;

        while (!queue.isEmpty()) {
            int divinagraciaV = queue.poll();
            for (int divinagraciaNeighbor : graph.getNeighbors(divinagraciaV)) {
                if (!divinagraciaVisited[divinagraciaNeighbor]) {
                    divinagraciaVisited[divinagraciaNeighbor] = true;
                    queue.add(divinagraciaNeighbor);
                }
            }
        }
    }
}
