package me.nithind.algo;

/**
 * Created by devangn on 03-01-17.
 */
public class Palyndrome {

    /*public String longestPalindrome2(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
            if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if(s.length() <=1) return s;

        String curBig = ""+s.charAt(0);
        int curBigZ = 1;
        for (int i=0; i<s.length()-1; i++) {

        }
        return curBig;
    }

    private boolean isPal(String s, int start, int end) {

    }*/


    public String longestPalindrome(String s) {
        //"babad
        //helNitinnhjhs
        if (s.length() <= 1) return s;

        String curBig = "" + s.charAt(0);
        int curBigZ = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();


            for (int j = i + curBigZ; j < s.length(); j++) {
                sb.setLength(0);
                sb.append(s.substring(i, j+1));
                if (isPal(sb)) {
                    String sP = sb.toString();
                    if (sP.length() > curBigZ) {
                        curBigZ = sP.length();
                        curBig = sP;
                    }
                }
            }
        }
        return curBig;
    }

    private boolean isPal(StringBuilder s1) {
        //System.out.println(s1);
        String sF = s1.toString();
        String sRev = s1.reverse().toString();
        s1.reverse();
        if (sF.equals(sRev)) return true;
        return false;
    }

    public static void main(String[] args) {
        Palyndrome p = new Palyndrome();
        p.longestPalindrome("aaaa");
    }
}
