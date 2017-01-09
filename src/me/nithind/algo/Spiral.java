package me.nithind.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devangn on 08-01-17.
 */
public class Spiral {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBeg =0;
        int colBeg = 0;
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int tot = (matrix.length * matrix[0].length);
        int cur = 0;
        while (cur< (matrix.length * matrix[0].length)) {
            int li=rowBeg;
            int lj=colBeg;
            //System.out.println("");
            for (int j =colBeg; j<matrix[0].length-colBeg && cur<tot; j++) {
                //System.out.print(matrix[rowBeg][j] + " ");
                result.add(matrix[rowBeg][j]);
                lj = j;
                cur++;
            }
            //j--;
            for (int i=rowBeg+1; i<matrix.length-rowBeg && cur <tot; i++) {
                //System.out.print(matrix[i][lj] + " ");
                result.add(matrix[i][lj]);
                li = i;
                cur++;
            }
            //i--;

            for (int j = (matrix[0].length-2)-colBeg; j>=colBeg && cur <tot; j--) {
                //System.out.print(matrix[li][j] + " ");
                result.add(matrix[li][j]);
                lj = j;
                cur++;
            }
            //j++;
            for (int i =(matrix.length-2)-rowBeg; i>=rowBeg+1 && cur <tot; i-- ) {
                //System.out.print(matrix[i][lj] + " ");
                result.add(matrix[i][lj]);
                cur++;
            }
            rowBeg++;
            colBeg++;
            //break;
            }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat ={};
        Spiral spiral = new Spiral();
        spiral.spiralOrder(mat);
    }
}
