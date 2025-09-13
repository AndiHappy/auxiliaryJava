package com.happy.alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


    /*
    Given a string containing digits from 2-9 inclusive,

    return all possible letter combinations that the number could represent.

    Return the answer in any order.

    A mapping of digit to letters (just like on the telephone buttons)
    is given below. Note that 1 does not map to any letters.


    {0 ==> "",
     1 ==> "",
     2 ==> "abc",
     3 ==> "def",
     4 ==> "ghi",
     5 ==> "lkj",
     6 ==> "mno",
     7 ==> "pqrs",
     8 ==> "tuv",
     9 ==> "wxyz"};


    Example 1:

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []


    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]


    Constraints:
            0 <= digits.length <= 4

    digits[i] is a digit in the range ['2', '9'].
    */

public class LeetCode017 {

    class Solution2 {
        String[] a = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return res;
            rt(digits, 0);
            return res;
        }

        public void rt(String digits, int index) {
            if (path.length() == digits.length()) {
                res.add(path.toString());
                return;
            }

            String s = a[digits.charAt(index) - '0'];
            for (int i = 0; i < s.length(); i++) {
                path.append(s.charAt(i));
                rt(digits, index + 1);
                path.deleteCharAt(path.length() - 1);
            }

        }
    }

    public static String[] digitsCombina = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "lkj",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"};

    class Solution {


        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            // special case
            if (digits == null || digits.length() == 0) return result;
            return lc(digits, 0, digitsCombina,result);
        }

        /**
         * @param digits input digits
         * @param start  current index of digits
         * @param digitsArray  mapping array
         * @param res  result list
         * @return  result list
         */
        private List<String> lc (String digits,int start,String[] digitsArray,List<String> res) {
            if (start == digits.length() || start > digits.length()) return res;
            List<String> tmpR = new ArrayList<>();
            // find start
            int index = digits.charAt(start) - '0'; //index of digitsCombina
            String targetString = digitsArray[index];
            if (res.isEmpty()) {
                for (int i = 0; i < targetString.length(); i++) {
                    tmpR.add(targetString.charAt(i) + "");
                }
            }else{
                // res not empty
                for (String s : res) {
                    for (int i = 0; i < targetString.length(); i++) {
                        tmpR.add(s + targetString.charAt(i));
                    }
                }
            }
            return lc(digits, start+1, digitsArray,tmpR);
        }

    }

    public static void main(String[] args) {
        LeetCode017 leetCode017 = new LeetCode017();
        LeetCode017.Solution s = leetCode017.new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println("L1_30.LeetCode017.main");
        System.out.println( letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        return letterCombinations(digits, 0, digitsCombina,result);
    }

    //
    private static List<String> letterCombinations(String digits, int i, String[] digitsCombina, List<String> result) {
        if(i < digits.length()){
            // find i
            List<String> tmpR = new ArrayList<>();
            int index = digits.charAt(i)-'0';
            String dividedString = digitsCombina[index];
            if(result==null || result.isEmpty()){
                for (int j = 0; j < dividedString.length(); j++) {
                    tmpR.add(String.valueOf(dividedString.charAt(j)));
                }
            }else{
                for (String tmp: result) {
                    for (int j = 0; j < dividedString.length(); j++) {
                        tmpR.add(tmp+dividedString.charAt(j));
                    }
                }
            }
            return letterCombinations(digits,i+1,digitsCombina,tmpR);
        }
        return result;
    }
}
