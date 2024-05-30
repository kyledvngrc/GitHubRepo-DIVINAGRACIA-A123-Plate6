//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.*;

public class ProblemThree {
    private final int divinagraciaV; // Number of vertices
    private final LinkedList<Integer>[] divinagraciaAdj; // Adjacency list
    private final boolean divinagraciaIsDirected; // Whether the graph is directed

    public ProblemThree(int divinagraciaV, boolean divinagraciaIsDirected) {
        this.divinagraciaV = divinagraciaV;
        this.divinagraciaIsDirected = divinagraciaIsDirected;
        divinagraciaAdj = new LinkedList[divinagraciaV];
        for (int i = 0; i < divinagraciaV; i++) {
            divinagraciaAdj[i] = new LinkedList<>();
        }
    }

    public void addDivinagraciaEdge(int divinagraciaV, int divinagraciaW) {
        divinagraciaAdj[divinagraciaV].add(divinagraciaW);
        if (!divinagraciaIsDirected) {
            divinagraciaAdj[divinagraciaW].add(divinagraciaV); // Add back edge for undirected graph
        }
    }

    private boolean isDivinagraciaCyclicUtilUndirected(int divinagraciaV, boolean[] divinagraciaVisited, int divinagraciaParent) {
        divinagraciaVisited[divinagraciaV] = true;
        for (int divinagraciaI : divinagraciaAdj[divinagraciaV]) {
            if (!divinagraciaVisited[divinagraciaI]) {
                if (isDivinagraciaCyclicUtilUndirected(divinagraciaI, divinagraciaVisited, divinagraciaV)) {
                    return true;
                }
            } else if (divinagraciaI != divinagraciaParent) {
                return true;
            }
        }
        return false;
    }

    private boolean isDivinagraciaCyclicUtilDirected(int divinagraciaV, boolean[] divinagraciaVisited, boolean[] divinagraciaRecStack) {
        if (divinagraciaRecStack[divinagraciaV]) {
            return true;
        }
        if (divinagraciaVisited[divinagraciaV]) {
            return false;
        }
        divinagraciaVisited[divinagraciaV] = true;
        divinagraciaRecStack[divinagraciaV] = true;
        for (int divinagraciaI : divinagraciaAdj[divinagraciaV]) {
            if (isDivinagraciaCyclicUtilDirected(divinagraciaI, divinagraciaVisited, divinagraciaRecStack)) {
                return true;
            }
        }
        divinagraciaRecStack[divinagraciaV] = false;
        return false;
    }

    public boolean isDivinagraciaCyclic() {
        boolean[] divinagraciaVisited = new boolean[divinagraciaV];
        if (divinagraciaIsDirected) {
            boolean[] divinagraciaRecStack = new boolean[divinagraciaV];
            for (int i = 0; i < divinagraciaV; i++) {
                if (isDivinagraciaCyclicUtilDirected(i, divinagraciaVisited, divinagraciaRecStack)) {
                    return true;
                }
            }
        } else {
            for (int divinagraciaU = 0; divinagraciaU < divinagraciaV; divinagraciaU++) {
                if (!divinagraciaVisited[divinagraciaU]) {
                    if (isDivinagraciaCyclicUtilUndirected(divinagraciaU, divinagraciaVisited, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner divinagraciaScanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int divinagraciaV = divinagraciaScanner.nextInt();
        System.out.println("Is the graph directed? (yes/no):");
        boolean divinagraciaIsDirected = divinagraciaScanner.next().equalsIgnoreCase("yes");

        ProblemThree divinagraciaGraph = new ProblemThree(divinagraciaV, divinagraciaIsDirected);

        System.out.println("Enter number of edges:");
        int divinagraciaE = divinagraciaScanner.nextInt();
        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < divinagraciaE; i++) {
            int divinagraciaSrc = divinagraciaScanner.nextInt();
            int divinagraciaDest = divinagraciaScanner.nextInt();
            divinagraciaGraph.addDivinagraciaEdge(divinagraciaSrc, divinagraciaDest);
        }

        if (divinagraciaGraph.isDivinagraciaCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }

        divinagraciaScanner.close();
    }
}
