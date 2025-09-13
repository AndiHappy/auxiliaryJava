package com.happy.alg;

import java.util.HashMap;
import java.util.Map;

public class LeetCode003 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() <= 1) {
                return s.length();
            }

            int begin = 0;
            int result = 1;
            Map<Character,Integer> window = new HashMap<>(s.length());
            window.put(s.charAt(0),begin);
            for (int i = 1; i < s.length() ; i++) {
                Character c = s.charAt(i);
                //如果不包含c
                if (!window.containsKey(c)) {
                    window.put(c,i);
                    if (result < (i - begin + 1)) {
                        result = i - begin + 1;
                    }
                }else{
                    //包含c
                    Integer repeatIndex = window.get(c);
                    //更新begin
                    if(repeatIndex>=begin){
                        begin=repeatIndex+1;
                    }
                    window.put(c,i);
                    if (result < (i - begin + 1)) {
                        result = i - begin + 1;
                    }
                }
            }
            return result;
        }
    }


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
