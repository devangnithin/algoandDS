package me.nithind.algo;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by devangn on 15-01-17.
 */
public class ReverseSent {
        public String reverseWords(String s) {
            List<String> sL = Arrays.asList(s.split(" "));
            Collections.reverse(sL);;
            //return Arrays.toString(sL.toArray());
            StringBuilder sb = new StringBuilder();
            //String[] sA = (String[]) sL.toArray();
            for (int i=0; i<sL.size(); i++) {
                if (sL.get(i).length() == 0) {
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(sL.get(i));
                if (i != sL.size()-1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        ReverseSent d = new ReverseSent();
        //System.out.println(d.reverseWords("the sky is blue"));
        System.out.println(d.reverseWords(" 1"));

    }
}
