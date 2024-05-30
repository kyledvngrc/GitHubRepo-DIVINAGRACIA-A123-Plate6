//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemFive {
    public static void main(String[] args) {
        Scanner divinagraciaScanner = new Scanner(System.in);

        // List to store edges
        List<int[]> divinagraciaEdges = new ArrayList<>();

        // Prompt user for edges
        System.out.println("Enter edges in the format 'vertex1 vertex2' (type 'done' to finish):");
        while (true) {
            String divinagraciaInput = divinagraciaScanner.nextLine();
            if (divinagraciaInput.equalsIgnoreCase("done")) {
                break;
            }
            String[] divinagraciaVertices = divinagraciaInput.split(" ");
            int divinagraciaVertex1 = Integer.parseInt(divinagraciaVertices[0]);
            int divinagraciaVertex2 = Integer.parseInt(divinagraciaVertices[1]);
            divinagraciaEdges.add(new int[]{divinagraciaVertex1, divinagraciaVertex2});
        }

        // Check if the graph is bipartite
        boolean isDivinagraciaBipartite = isBipartite(divinagraciaEdges);

        // Print the result
        if (isDivinagraciaBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        divinagraciaScanner.close();
    }

    private static boolean isBipartite(List<int[]> divinagraciaEdges) {
        Map<Integer, List<Integer>> divinagraciaGraph = new HashMap<>();
        
        // Build the adjacency list
        for (int[] divinagraciaEdge : divinagraciaEdges) {
            divinagraciaGraph.putIfAbsent(divinagraciaEdge[0], new ArrayList<>());
            divinagraciaGraph.putIfAbsent(divinagraciaEdge[1], new ArrayList<>());
            divinagraciaGraph.get(divinagraciaEdge[0]).add(divinagraciaEdge[1]);
            divinagraciaGraph.get(divinagraciaEdge[1]).add(divinagraciaEdge[0]);
        }

        // Map to store the color of each vertex (-1 indicates no color)
        Map<Integer, Integer> divinagraciaColor = new HashMap<>();
        for (int divinagraciaVertex : divinagraciaGraph.keySet()) {
            divinagraciaColor.put(divinagraciaVertex, -1);
        }

        // Check bipartiteness for each component of the graph
        for (int divinagraciaVertex : divinagraciaGraph.keySet()) {
            if (divinagraciaColor.get(divinagraciaVertex) == -1) {
                if (!bfsCheck(divinagraciaGraph, divinagraciaVertex, divinagraciaColor)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(Map<Integer, List<Integer>> divinagraciaGraph, int divinagraciaStart, Map<Integer, Integer> divinagraciaColor) {
        Queue<Integer> divinagraciaQueue = new LinkedList<>();
        divinagraciaQueue.add(divinagraciaStart);
        divinagraciaColor.put(divinagraciaStart, 0); // Start coloring with color 0

        while (!divinagraciaQueue.isEmpty()) {
            int divinagraciaVertex = divinagraciaQueue.poll();
            int currentColor = divinagraciaColor.get(divinagraciaVertex);
            int nextColor = 1 - currentColor; // Alternate color between 0 and 1

            for (int neighbor : divinagraciaGraph.get(divinagraciaVertex)) {
                if (divinagraciaColor.get(neighbor) == -1) { // If the neighbor is not colored
                    divinagraciaColor.put(neighbor, nextColor);
                    divinagraciaQueue.add(neighbor);
                } else if (divinagraciaColor.get(neighbor) == currentColor) {
                    return false; // Found a conflict
                }
            }
        }

        return true;
    }
}
