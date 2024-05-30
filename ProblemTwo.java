//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemTwo {

    public static void main(String[] args) {
        Scanner divinagraciaSC = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int divinagraciaNumVertices = divinagraciaSC.nextInt();

        int[][] divinagraciaAdjacencyMatrix = new int[divinagraciaNumVertices][divinagraciaNumVertices];
        System.out.println("Enter the adjacency matrix:");
        for (int divinagraciaI = 0; divinagraciaI < divinagraciaNumVertices; divinagraciaI++) {
            for (int divinagraciaJ = 0; divinagraciaJ < divinagraciaNumVertices; divinagraciaJ++) {
                divinagraciaAdjacencyMatrix[divinagraciaI][divinagraciaJ] = divinagraciaSC.nextInt();
            }
        }

        Map<String, Integer> divinagraciaEdgeCount = new HashMap<>();
        for (int divinagraciaI = 0; divinagraciaI < divinagraciaNumVertices; divinagraciaI++) {
            for (int divinagraciaJ = 0; divinagraciaJ < divinagraciaNumVertices; divinagraciaJ++) {
                if (divinagraciaAdjacencyMatrix[divinagraciaI][divinagraciaJ] != 0) {
                    String divinagraciaEdge = divinagraciaI < divinagraciaJ ? divinagraciaI + "-" + divinagraciaJ : divinagraciaJ + "-" + divinagraciaI;
                    divinagraciaEdgeCount.put(divinagraciaEdge, divinagraciaEdgeCount.getOrDefault(divinagraciaEdge, 0) + divinagraciaAdjacencyMatrix[divinagraciaI][divinagraciaJ]);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> divinagraciaEntry : divinagraciaEdgeCount.entrySet()) {
            System.out.println("Edge " + divinagraciaEntry.getKey() + " appears " + divinagraciaEntry.getValue() + " times.");
        }

        divinagraciaSC.close();
    }
}
