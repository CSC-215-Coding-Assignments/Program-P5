package StarterCode;
/**************
 * PatterMatch
 * Author: Christian Duncan
 * Modified by: Emily Balboni
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
    public static final String DEFAULT_FILE = "resources/IO/test3.input";
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
     * does this by checking every value in a [][] to see if the values in b [][] are a match
     * if there is a match numCheck keeps track, if the amount of matches is equal to the amount of
     * numbers in b[][] then the match count variable increases and the numCheck resets to zero to start the next comparison
     **/
    public static int countMatches(int[][] a, int[][] b) {
        int count = 0;
        int numCheck = 0;
        for(int n =0; n < a.length - b.length + 1;n++){
            for(int k = 0; k < a[n].length - b[0].length + 1; k++){
                    numCheck = 0;
                for(int i = 0; i < b.length; i++){
                    for(int j =0; j <b[0].length; j++){
                        if(a[n + i][k + j] == b [i][j]){
                            numCheck ++;
                        }
                    }
                }
                if(numCheck == b.length * b[0].length){
                    count++;
                }
            }
        }

        return count;
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
