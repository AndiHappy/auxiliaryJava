package com.happy.alg;

import java.util.Arrays;
import java.util.HashMap;

//## HashMap
//## Cache
public class LeetCode001 {

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] result = T.twoSum(new int[]{1,2,3,4,5},6);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums== null || nums.length==0 ) {
                return new int[2];
            }
            HashMap<Integer,Integer> cache = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if(cache.get(target-nums[i]) != null){
                    return new int[]{cache.get(target-nums[i]),i};
                }
                cache.put(nums[i],i);
            }
            return new int[2];
        }
    }
}
