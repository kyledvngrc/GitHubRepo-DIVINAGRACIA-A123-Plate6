//DIVINAGRACIA, KYLE ASHLEY O.
import java.util.Scanner;

public class ProblemEight {
    public static void main(String[] args) {
        Scanner divinagraciaScanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int divinagraciaN = divinagraciaScanner.nextInt();

        int[][] divinagraciaGraph1 = new int[divinagraciaN][divinagraciaN];
        int[][] divinagraciaGraph2 = new int[divinagraciaN][divinagraciaN];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < divinagraciaN; i++) {
            for (int j = 0; j < divinagraciaN; j++) {
                divinagraciaGraph1[i][j] = divinagraciaScanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < divinagraciaN; i++) {
            for (int j = 0; j < divinagraciaN; j++) {
                divinagraciaGraph2[i][j] = divinagraciaScanner.nextInt();
            }
        }

        System.out.println(areDivinagraciaIsomorphic(divinagraciaGraph1, divinagraciaGraph2) ? 
            "The graphs are isomorphic." : "The graphs are not isomorphic.");
        
        divinagraciaScanner.close();
    }

    public static boolean areDivinagraciaIsomorphic(int[][] divinagraciaGraph1, int[][] divinagraciaGraph2) {
        int divinagraciaN = divinagraciaGraph1.length;
        if (divinagraciaN != divinagraciaGraph2.length) {
            return false;
        }

        int[] divinagraciaPermutation = new int[divinagraciaN];
        for (int i = 0; i < divinagraciaN; i++) {
            divinagraciaPermutation[i] = i;
        }

        return isDivinagraciaIsomorphicUtil(divinagraciaGraph1, divinagraciaGraph2, divinagraciaPermutation, 0);
    }

    private static boolean isDivinagraciaIsomorphicUtil(int[][] divinagraciaGraph1, int[][] divinagraciaGraph2, int[] divinagraciaPermutation, int divinagraciaIndex) {
        int divinagraciaN = divinagraciaGraph1.length;
        if (divinagraciaIndex == divinagraciaN) {
            return isValidDivinagraciaPermutation(divinagraciaGraph1, divinagraciaGraph2, divinagraciaPermutation);
        }

        for (int i = divinagraciaIndex; i < divinagraciaN; i++) {
            divinagraciaSwap(divinagraciaPermutation, divinagraciaIndex, i);
            if (isDivinagraciaIsomorphicUtil(divinagraciaGraph1, divinagraciaGraph2, divinagraciaPermutation, divinagraciaIndex + 1)) {
                return true;
            }
            divinagraciaSwap(divinagraciaPermutation, divinagraciaIndex, i);
        }
        return false;
    }

    private static boolean isValidDivinagraciaPermutation(int[][] divinagraciaGraph1, int[][] divinagraciaGraph2, int[] divinagraciaPermutation) {
        int divinagraciaN = divinagraciaGraph1.length;
        for (int i = 0; i < divinagraciaN; i++) {
            for (int j = 0; j < divinagraciaN; j++) {
                if (divinagraciaGraph1[i][j] != divinagraciaGraph2[divinagraciaPermutation[i]][divinagraciaPermutation[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void divinagraciaSwap(int[] divinagraciaArr, int divinagraciaI, int divinagraciaJ) {
        int divinagraciaTemp = divinagraciaArr[divinagraciaI];
        divinagraciaArr[divinagraciaI] = divinagraciaArr[divinagraciaJ];
        divinagraciaArr[divinagraciaJ] = divinagraciaTemp;
    }
}
