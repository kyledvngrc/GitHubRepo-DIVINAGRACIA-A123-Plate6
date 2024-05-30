//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemSix {
    public static void main(String[] args) {
        Scanner divinagraciaScanner = new Scanner(System.in);

        // List to store edges
        List<int[]> divinagraciaEdges = new ArrayList<>();

        // Prompt user for edges
        System.out.println("Enter edges in the format 'vertex1 vertex2' (type 'done' to finish):");
        int divinagraciaMaxVertex = 0;
        while (true) {
            String divinagraciaInput = divinagraciaScanner.nextLine();
            if (divinagraciaInput.equalsIgnoreCase("done")) {
                break;
            }
            String[] divinagraciaVertices = divinagraciaInput.split(" ");
            int divinagraciaVertex1 = Integer.parseInt(divinagraciaVertices[0]);
            int divinagraciaVertex2 = Integer.parseInt(divinagraciaVertices[1]);
            divinagraciaEdges.add(new int[]{divinagraciaVertex1, divinagraciaVertex2});
            divinagraciaMaxVertex = Math.max(divinagraciaMaxVertex, Math.max(divinagraciaVertex1, divinagraciaVertex2));
        }

        // Construct adjacency matrix
        int[][] divinagraciaAdjacencyMatrix = new int[divinagraciaMaxVertex + 1][divinagraciaMaxVertex + 1];

        for (int[] divinagraciaEdge : divinagraciaEdges) {
            int divinagraciaVertex1 = divinagraciaEdge[0];
            int divinagraciaVertex2 = divinagraciaEdge[1];
            divinagraciaAdjacencyMatrix[divinagraciaVertex1][divinagraciaVertex2]++;
        }

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i <= divinagraciaMaxVertex; i++) {
            for (int j = 0; j <= divinagraciaMaxVertex; j++) {
                System.out.print(divinagraciaAdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        divinagraciaScanner.close();
    }
}
