package me.nithind.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devangn on 12-01-17.
 */
public class InteleavingString {
    Map<String, Map<String, Boolean>> m = new HashMap<String, Map<String, Boolean>>();
    //TopDown

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) return true;
        if (s3.length() != s1.length() + s2.length()) return false;
        if (s3.length() == 0) return false;

        if (m.get(s1+"|"+s2) != null && m.get(s1+"|"+s2).get(s3)!=null) {
            //System.out.println("Using DP 1");
            return m.get(s1+"|"+s2).get(s3);
        }

        if (m.get(s2+"|"+s1) != null && m.get(s2+"|"+s1).get(s3)!=null) {
            //System.out.println("Using DP 2");
            return m.get(s2+"|"+s1).get(s3);
        }

        Boolean result =  ((s1.length()>0 && s1.charAt(0)==s3.charAt(0) &&isInterleave(s1.substring(1), s2, s3.substring(1)))
                ||
                (s2.length()> 0 && s2.charAt(0)==s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1))));
        Map<String, Boolean> m2 = new HashMap<String, Boolean>();
        m2.put(s3, result);
        m.put(s1+"|"+s2, m2);
        return result;
    }

    public static void main(String args[]) {
        //System.out.println("Interleaving");
        InteleavingString i = new InteleavingString();
        //if(i.isInterleave("aabcc", "dbbca", "aadbbbaccc")) {
        //if (i.isInterleave("aabcc", "dbbca", "aadbbcbcac")) {
        if (i.isInterleave("aa", "ab", "aaba")) {
            System.out.println("Interleaving");
        } else {
            System.out.println("Not Interleaving");
        }

    }
}
