package me.nithind.ds;

/**
 * Created by nithin on 6/23/17.
 */
public class Solution {
    public String addBinary(String a, String b) {

        char carry = '0';
        String big = (a.length() > b.length()) ? a : b;
        String small = (b.length() < a.length()) ? b : a;
        int diff = big.length() - small.length();

        StringBuilder result = new StringBuilder();

        for (int i = small.length() - 1; i >= 0; i--) {
            char temp = (small.charAt(i) == big.charAt(i + diff)) ? '0' : '1';
            if (carry == '1') {
                temp = (temp == '0') ? '1' : '0';
            }
            result.insert(0, temp);
            if (carry == '0') carry = (small.charAt(i) == '1' && big.charAt(i + diff) == '1') ? '1' : '0';
            else if (carry == '1') carry = (small.charAt(i) == '0' && big.charAt(i + diff) == '0') ? '0' : '1';

        }

        int i = big.length() - small.length() - 1;

        while (carry != '0' && i >= 0) {

            char temp = (big.charAt(i) == '0') ? '0' : '1';
            temp = (temp == '0') ? '1' : '0';

            result.insert(0, temp);
            carry = (big.charAt(i) == '0') ? '0' : '1';
            i--;
        }

        if (i >= 0) result.insert(0, big.substring(0, i+1));
        if (carry != '0') result.insert(0, '1');


        return result.toString();

    }

    public static void main(String[] args) {
        String[] input = {"nithin", "nithan", "nithihsh"};
        Solution lp = new Solution();
        System.out.println(lp.addBinary("100", "110010"));


    }

}

