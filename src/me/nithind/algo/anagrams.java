package me.nithind.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devangn on 07-01-17.
 */
public class anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anMap = new HashMap<String, List<String>>();
        for (int i=0; i<strs.length; i++) {
            String hkey = getHash(strs[i]);
            if(anMap.containsKey(hkey)) {
                ((List<String>)anMap.get(hkey)).add(strs[i]);
            } else {
                List<String> t = new ArrayList<String>();
                t.add(strs[i]);
                anMap.put(hkey, t);
            }
        }
        return new ArrayList<List<String>>(anMap.values()) ;
    }
    public String getHash (String str) {
        char[] stCh = str.toCharArray();
        Arrays.sort(stCh);
        return String.valueOf(stCh);
    }
    public static void main(String[] args) {
        anagrams a = new anagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(a.groupAnagrams(strs));
    }
}