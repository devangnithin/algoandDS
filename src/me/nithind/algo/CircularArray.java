package me.nithind.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devangn on 15-01-17.
 */
public class CircularArray {
    public boolean circularArrayLoop(int[] nums) {
        Boolean forward = null;
        if (nums.length<1) return false;
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0; i<nums.length;) {
            if (l.contains(i)) return true;
            l.add(i);
            //forward
            if ((i+nums[i])>i) {
                if (forward == null) {
                    forward = true;
                } else if (forward == false) {
                    return false;
                }
                i = (i+nums[i])%nums.length;
            }
            //reverse
            else if ((i+nums[i])<i) {
                if (forward == null) {
                    forward = false;
                } else if (forward == true) {
                    return false;
                }
                i= nums.length+i;
            }
            //i = (i+nums[i])%nums.length;
            //if (i<0) i = nums.length+i;
            if (l.size() == nums.length) break;
        }
        return false;
    }

    public static void main(String[] args) {
        CircularArray c = new CircularArray();
        int[] nums =  {2, -1, 1, -2, -2};
        if (c.circularArrayLoop(nums)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}