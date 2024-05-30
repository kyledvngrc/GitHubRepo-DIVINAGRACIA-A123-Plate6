//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemSeven {
    public static void main(String[] args) {
        Scanner divinagraciaScanner = new Scanner(System.in);

        // List to store edges and their multiplicities
        List<int[]> divinagraciaEdges = new ArrayList<>();
        List<Integer> divinagraciaEdgeCounts = new ArrayList<>();

        // Prompt user for edges and their multiplicities
        System.out.println("Enter edges in the format 'vertex1 vertex2 count' (type 'done' to finish):");
        int divinagraciaMaxVertex = 0;
        while (true) {
            String divinagraciaInput = divinagraciaScanner.nextLine();
            if (divinagraciaInput.equalsIgnoreCase("done")) {
                break;
            }
            String[] divinagraciaVertices = divinagraciaInput.split(" ");
            int divinagraciaVertex1 = Integer.parseInt(divinagraciaVertices[0]);
            int divinagraciaVertex2 = Integer.parseInt(divinagraciaVertices[1]);
            int divinagraciaCount = Integer.parseInt(divinagraciaVertices[2]);
            divinagraciaEdges.add(new int[]{divinagraciaVertex1, divinagraciaVertex2});
            divinagraciaEdgeCounts.add(divinagraciaCount);
            divinagraciaMaxVertex = Math.max(divinagraciaMaxVertex, Math.max(divinagraciaVertex1, divinagraciaVertex2));
        }

        // Calculate the total number of edges (considering multiplicities)
        int divinagraciaTotalEdges = 0;
        for (int count : divinagraciaEdgeCounts) {
            divinagraciaTotalEdges += count;
        }

        // Construct incidence matrix
        int[][] divinagraciaIncidenceMatrix = new int[divinagraciaMaxVertex + 1][divinagraciaTotalEdges];
        int edgeIndex = 0;
        for (int i = 0; i < divinagraciaEdges.size(); i++) {
            int[] divinagraciaEdge = divinagraciaEdges.get(i);
            int divinagraciaVertex1 = divinagraciaEdge[0];
            int divinagraciaVertex2 = divinagraciaEdge[1];
            int divinagraciaCount = divinagraciaEdgeCounts.get(i);
            for (int j = 0; j < divinagraciaCount; j++) {
                divinagraciaIncidenceMatrix[divinagraciaVertex1][edgeIndex] = 1;
                divinagraciaIncidenceMatrix[divinagraciaVertex2][edgeIndex] = 1;
                edgeIndex++;
            }
        }

        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i <= divinagraciaMaxVertex; i++) {
            for (int j = 0; j < divinagraciaTotalEdges; j++) {
                System.out.print(divinagraciaIncidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        divinagraciaScanner.close();
    }
}
