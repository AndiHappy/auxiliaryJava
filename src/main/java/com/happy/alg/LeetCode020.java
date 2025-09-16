package com.happy.alg;

import java.util.Stack;

/**

 20. Valid Parentheses
 简单
 相关标签
 premium lock icon
 相关企业
 提示
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.


 Example 1:

 Input: s = "()"

 Output: true

 Example 2:

 Input: s = "()[]{}"

 Output: true

 Example 3:

 Input: s = "(]"

 Output: false

 Example 4:

 Input: s = "([])"

 Output: true

 Example 5:

 Input: s = "([)]"

 Output: false



 Constraints:

 1 <= s.length <= 104
 s consists of parentheses only '()[]{}'.

 * */
public class LeetCode020 {

    class solution {
        public boolean isValid(String s) {
            if(s == null || s.length() <1 ) return true;
            Stack<Character> stack = new Stack<>();
            char[] schars = s.toCharArray();
            for (int i = 0; i < schars.length; i++) {
                char c = schars[i];
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }else if(c == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(c == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(c == '}'){
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }


    public boolean isValid(String s) {
        if(s == null || s.length() <1 ) return true;
        Stack<Character> stack = new Stack<>();
        char[] schars = s.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            char c = schars[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        LeetCode020 l = new LeetCode020();
        System.out.println("keep happy");
        System.out.println(l.isValid("("));
        System.out.println(l.isValid(")"));
        System.out.println(l.isValid("()["));
        System.out.println(l.isValid("()[{}]"));
    }

}
