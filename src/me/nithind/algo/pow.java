package me.nithind.algo;

/**
 * Created by devangn on 07-01-17.
 */
public class pow {
    public double myPow(double x, int n) {
        if (n==1) return x;
        if (n==0) return 1;
        int tempN = n;
        boolean onePending = false;
        if (n == Integer.MIN_VALUE) {
            n = n-1;
            onePending = true;
        }
        if(tempN<0) {
            //System.out.println(tempN);
            tempN = tempN *-1;
            //System.out.println(tempN);
        }
        double result =  0;

        if (tempN%2==0) {
            double temp = myPow(x, tempN/2);
            result = temp*temp;
        } else {
            double temp = myPow(x, tempN/2);
            result = temp*temp*x;
        }

        if (n <0) {
            if (onePending) {
                return 1 / (result*x);
            } else {
                result = 1 / result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        pow w = new pow();
        System.out.print(w.myPow(2.00000, -2147483648));
    }
}