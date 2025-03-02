package com.happy.alg;

import com.happy.util.ListNode;

public class LeetCode002 {

    int carry=0;
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null && carry ==0)  return null;
        int sum = (l1!=null?l1.val:0) + (l2 != null?l2.val:0)+carry;
        carry=sum/10;
        return new ListNode(sum%10,addTwoNumbers(l1!=null?l1.next:null,l2!=null?l2.next:null));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // head 循环的过程中保持不变
        ListNode head = new ListNode(-1);
        // 变动的部分，另外的声明
        ListNode cur = head;int carry=0;
        while(l1 != null || l2 != null){
            int l1value = l1==null?0:l1.val;
            int l2value = l2==null?0:l2.val;
            int curValue = (l1value+l2value+carry)%10;
            carry=(l1value+l2value+carry)/10;
            cur.next=new ListNode(curValue);
            cur = cur.next;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        LeetCode002 T = new LeetCode002();
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode result = T.addTwoNumbers(l1,l2);
        System.out.println(result);
    }
}
