package me.nithind.algo;

/**
 * Created by devangn on 14-01-17.
 */
public class Decode {

    int numDecodings(String s) {
        System.out.println(s);
        if (s.length() ==0 || s.charAt(0) == '0') return 0;
        // twoChar: decode ways of s[i-2] , oneChar: decode ways of s[i-1]
        int oneChar = 1, twoChar = 1;

        for (int i = 1; i < s.length(); i++) {
            // zero voids ways of the last because zero cannot be used separately
            if (s.charAt(i) == '0') oneChar = 0;

            // possible two-digit letter, so new oneChar is sum of both while new twoChar is the old oneChar
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                oneChar = twoChar + oneChar;
                twoChar = oneChar - twoChar;
                System.out.println("i = "+i +" oneChar = "+oneChar + " twoChar = "+twoChar);
            }

            // one-digit letter, no new way added
            else {
                twoChar = oneChar;
            }
        }

        return oneChar;
    }
    /*public int numDecodings(String s) {
        int pretwo = 0;
        if(s.length()<1) return 0;
        char[] sC = s.toCharArray();
        if (sC[0] == '0') return 0;
        int count =1;
        if (s.contains("0")) count = 0;
        for (int i=0; i<s.length()-1; i++) {
            int a = Integer.parseInt(""+sC[i] + sC[i+1]);
            if (a == 0) return 0;
            if (a>=10 && a<=26 && isValid(sC, i+2)) {
                count ++;
                if (i>1) {
                    count = count + pretwo;
                }
                if (a != 10 && a!= 20)
                    pretwo++;
            }
        }
        return count;
    }*/

    private boolean isValid(char[] sC, int i) {
        if (i== sC.length-1) {
            if (sC[i]=='0') return false;
        }

        if (i<sC.length-1) {
            int a = Integer.parseInt(""+sC[i] + sC[i+1]);
            if (a==0) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Decode d = new Decode();
        //System.out.println(d.numDecodings("110"));
        //System.out.println(d.numDecodings("12345"));//3
        System.out.println(d.numDecodings("10"));//6
        //System.out.println(d.numDecodings("1010"));//1
    }
}

//110
//1 10
//11 0