package me.nithind.algo;

/**
 * Created by devangn on 16-01-17.
 */
public class LongestPrefix {
    int isPeriodic(String str) {
        if (str.length() <1 || str==null) return  -1; //abcabcabcabc
        boolean success = true;
        for (int i=1; i<str.length()/2+1; i++) {
            success = true;

            String sNew = str.substring(0, i); //abc
            for (int j =i; j<str.length(); j=j+i) {
                String sT = str.substring(j,j+i); //abc abc abc
                if (!sT.equals(sNew)) {
                    success = false;
                    break;
                }
                //success = true;
            }
            if (success)
                return i;

        }
        return -1;

    }


    public static void main(String args[]) {
        String[] strs = {"geeksforgeeks", "geeks", "geek", "geezer"};
        LongestPrefix l = new LongestPrefix();
        System.out.print(l.isPeriodic("abcabcabc"));

    }
}
