package me.nithind.algo;

/**
 * Created by devangn on 08-01-17.
 */
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
 */
public class LastWord {
    public int lengthOfLastWord(String s) {
        //if (s.length() == 0 || !s.contains(" ")) return 0;
        String [] sSplit = s.split(" ");
        if(sSplit.length <= 0) return 0;
        return sSplit[sSplit.length-1].length();
    }

    public static void main(String args[]) {
        LastWord l = new LastWord();
        System.out.print(l.lengthOfLastWord("Hello "));

    }
}