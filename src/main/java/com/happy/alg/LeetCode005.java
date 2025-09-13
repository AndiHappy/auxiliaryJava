package com.happy.alg;//Given a string s, return the longest palindromic substring in s.
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//

public class LeetCode005 {


    class Solution {
        // Longest Palindromic Substring
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2)
                return s;
            int max = 0, from = 0;
            for (int i = 0; i < s.length(); i++) {
                int len = findLongestPalindrome(s, i, i);
                if (len > max) {
                    max = len;
                    from = i - (len/2);
                }
                int len2 = findLongestPalindrome(s, i, i + 1);
                if (len2 > max) {
                    max = len2;
                    from = i - (len2/2 - 1);
                }
            }
            return s.substring(from, from + max);
        }

        private static int findLongestPalindrome(String s, int i, int j) {
            int length = 0;
            while (i > -1 && j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    length = j-i+1 ;
                } else {
                    break;
                }
                i--;
                j++;
            }
            return length;
        }
    }

    public static String longestPalindrome_dp(String s) {
        if (s == null || s.length() < 2)
            return s;
        int i = s.length();
        int max = 0, from = 0, to = 0;
        boolean[][] dp = new boolean[i][i];
        for (int j = dp.length - 1; j >= 0; j--) {
            for (int j2 = j; j2 < dp.length; j2++) {
                dp[j][j2] = (j2 - j <= 1 && s.charAt(j) == s.charAt(j2))
                        || (dp[j + 1][j2 - 1] && s.charAt(j) == s.charAt(j2));
                if (dp[j][j2] && (j2 - j + 1 >= max)) {
                    max = j2 - j + 1;
                    from = j;
                    to = j2;
                }
            }
        }
        return s.substring(from, to + 1);
    }

    public static void main(String[] args) {
        LeetCode005 leetCode005 = new LeetCode005();
        LeetCode005.Solution solution = leetCode005.new Solution();
        System.out.println(solution.longestPalindrome("cabac"));
        System.out.println(longestPalindrome_dp("cabac"))
        ;
        System.out.println(longestPalindrome_dp("cabac"));
        System.out.println(solution.longestPalindrome("cabac"));

        System.out.println(longestPalindrome_dp("babad"));
        System.out.println(solution.longestPalindrome("babad"));

    }
}
