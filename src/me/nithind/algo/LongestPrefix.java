package me.nithind.algo;

/**
 * Created by devangn on 16-01-17.
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        for (int i=0; i<strs.length; i++) {
            
        }
    }

    public static void main(String args[]) {
        String[] strs = {"geeksforgeeks", "geeks", "geek", "geezer"};
        LongestPrefix l = new LongestPrefix();
        System.out.print(l.longestCommonPrefix(strs));

    }
}
