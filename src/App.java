import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        String content;
        try {
            /* read all characters from input file*/
            content = new String(Files.readAllBytes(Paths.get("input.txt")));
            /* remove unexpected characters
             convert string to the integer array*/
            int[] arr = Stream.of(content.split("\\W+", 0)).mapToInt(Integer::parseInt).toArray();
            out.println(getMaxSum(arr));
        } 
        /* it could be some characters is not integer so let's check them*/
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxSum(int[] orthoTree) {
        return getMaxSumRec(orthoTree, 0, 1);
    }
    /**
     * there is a relation between children, parent by  depth
     * if we start root node with index=1 and depth=0
     * left-child would be : parent+depth
     * right-child : parent+depth+1
     * 
     *          1
     *     2         3
     * 4        5        6  
     * 
     * 2= 1+1
     * 3= 1+1+1
     * 4=2+2
     * 5=2+2+1 or 3+2
     * 6=3+2
     * 
     * @param orthoTree array of tree represantation
     * @param index array index of element
     * @param depth row index of element
     * @return maximum path sum of the tree
     */
    private static int getMaxSumRec(int[] orthoTree, int index, int depth) {

        /* check is it in range */
        if (index >= orthoTree.length) {
            return 0;
        }
        /* check is it prime, if it is return minimum integer value */
        if (isPrime(orthoTree[index])) {

            return Integer.MIN_VALUE;
        }
        /* check is it in last row, if it is return it */
        if ((2 * depth + 1) >= orthoTree.length) {

            return orthoTree[index];
        }
        /* find maximum child path and add the current value */
        return orthoTree[index] + Integer.max(/* this is left child */getMaxSumRec(orthoTree, index + depth, depth + 1),
                /* this is right child */getMaxSumRec(orthoTree, index + depth + 1, depth + 1));
    }


    /* an easy isPrime method :) */
    private static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }

        var r = Math.sqrt(i);
        for (var j = 3; j <= r; j = j + 2) {

            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
