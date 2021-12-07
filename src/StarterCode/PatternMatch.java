package StarterCode;
/**************
 * PatterMatch
 * Author: Christian Duncan
 * Modified by: ...
 *
 * Reads in two patterns (nxm array of integers) and
 * returns how many times the second pattern is found inside the first pattern.
 * This code uses a simple brute-force algorithm so the running time
 * is Theta(n^2m^2) [for nxn and mxm pattern arrays]
 **************/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PatternMatch {
    public static final String DEFAULT_FILE = "IO/test0.input";
    public static void main(String[] args) {
        String file = DEFAULT_FILE;
        if (args.length > 0) {
            // Use the file name given at the command line
            file = args[0];
        }

        try {
            File f = new File(file);
            Scanner in = new Scanner(f);
            
            // Read in the first pattern
            int[][] a = readPattern(in);
            
            // Read in the second pattern
            int[][] b = readPattern(in);
            
            int c = countMatches(a, b);
            System.out.println(c);
        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " was not found.");
            System.err.println("  Message: " + e.getMessage());
        }
    }

    /**
     * Count how many times pattern b shows up inside pattern a
     **/
    public static int countMatches(int[][] a, int[][] b) {
        return 0;
    }
            
    /**
     * Read in a pattern from a given Scanner input stream
     **/
    public static int[][] readPattern(Scanner in) {
        // Read in the dimensions
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] pattern = new int[n][m];

        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                pattern[r][c] = in.nextInt();

        return pattern;
    }

    /**
     *  Just a simple way to display a pattern
     *  This is useful more for debugging.
     **/
    public static void printPattern(int[][] pattern) {
        for (int r = 0; r < pattern.length; r++) {
            for (int c = 0; c < pattern[r].length; c++) {
                System.out.print(pattern[r][c] + " ");
            }
            System.out.println();
        }
    }
}
