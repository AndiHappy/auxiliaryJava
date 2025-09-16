package com.happy.alg;


import com.happy.util.ListNode;

/**

 19. Remove Nth Node From End of List
 中等
 相关标签
 premium lock icon
 相关企业
 提示
 Given the head of a linked list, remove the nth node from the end of the list and return its head.



 Example 1:


 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]
 Example 2:

 Input: head = [1], n = 1
 Output: []
 Example 3:

 Input: head = [1,2], n = 1
 Output: [1]


 Constraints:

 The number of nodes in the list is sz.
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz


 Follow up: Could you do this in one pass?

 * */

public class LeetCode019 {

    public static void main(String[] args) {
        System.out.println("keep happy");
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        LeetCode019 l = new LeetCode019();
        LeetCode019.Solution s = l.new Solution();
        System.out.println(s.removeNthFromEnd(head,2));// 1,2,3,5

        System.out.println(removeNthFromEnd(head,2));// 1,2,3,5

        head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(removeNthFromEnd(head.next.next.next.next,1));//null

        head = new ListNode(1);
        head.next=new ListNode(2);
        System.out.println(removeNthFromEnd(head,2));// 4
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummpy = new ListNode(0,head);
            ListNode pre = dummpy;
            while(head != null){
                if (n <= 0) {
                    pre = pre.next;
                }
                head = head.next;
                n--;
            }
            pre.next = pre.next.next;
            return dummpy.next;
        }
    }



    /**
     * 关键还是在于处理特殊的场景
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <=0) return head;
        // end point
        ListNode s = head;
        //dele point pre node！
        ListNode f = head;

        while(n>0 && s != null){
            s = s.next;
            n--;
        }

        if(s == null && n == 0){
            return head.next;
        }

        while (s.next != null) {
            f = f.next;
            s = s.next;
        }
        f.next = f.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd_Error(ListNode head, int n) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null){
            cur = cur.next;
            if(n<0){
                pre = pre.next;
            }
            n--;
        }
        if(pre.next != null){
            ListNode right = pre.next.next;
            pre.next=right;
        }

        return head;
    }
}
