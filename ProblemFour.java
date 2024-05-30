//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemFour {
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

        // Calculate degrees of vertices
        Map<Integer, Integer> divinagraciaVertexDegrees = calculateDivinagraciaDegrees(divinagraciaEdges);

        // Print the degree of each vertex
        for (Map.Entry<Integer, Integer> divinagraciaEntry : divinagraciaVertexDegrees.entrySet()) {
            System.out.println("Vertex " + divinagraciaEntry.getKey() + " has degree " + divinagraciaEntry.getValue());
        }

        divinagraciaScanner.close();
    }

    private static Map<Integer, Integer> calculateDivinagraciaDegrees(List<int[]> divinagraciaEdges) {
        Map<Integer, Integer> divinagraciaVertexDegrees = new HashMap<>();

        for (int[] divinagraciaEdge : divinagraciaEdges) {
            int divinagraciaVertex1 = divinagraciaEdge[0];
            int divinagraciaVertex2 = divinagraciaEdge[1];

            // Increment degree for both vertices involved in the edge
            divinagraciaVertexDegrees.put(divinagraciaVertex1, divinagraciaVertexDegrees.getOrDefault(divinagraciaVertex1, 0) + 1);
            divinagraciaVertexDegrees.put(divinagraciaVertex2, divinagraciaVertexDegrees.getOrDefault(divinagraciaVertex2, 0) + 1);
        }

        return divinagraciaVertexDegrees;
    }
}
