package com.happy.alg;

import java.util.HashMap;
import java.util.Map;

public class LeetCode003 {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;int from=0,end=0;
        Map<Character,Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chari = s.charAt(i);
            if(window.containsKey(chari)){
                int repeatIndex = window.get(chari);
                // abba second a index=0，but from=2
                from = Math.max(repeatIndex+1,from);
//                from=repeatIndex+1>from?repeatIndex+1:from;
            }
            end++;
            result = Math.max(result,end-from);
            window.put(chari,i);
        }
        return result;
    }

}
