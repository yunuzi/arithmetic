package com.sl.Study.BasicProgramming;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_445
 * @Date：2024-7-31 10:09
 * @Filename：problem_445
 */
public class problem_445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            while(l1 != null){
                sb1.append(l1.val);
                l1 = l1.next;
            }
            while(l2 != null){
                sb2.append(l2.val);
                l2 = l2.next;
            }
            ListNode ll1 = null;
            ListNode ll2 = null;
            ListNode temp1 = null;
            ListNode temp2 = null;
            sb1.reverse();
            sb2.reverse();
            ListNode tem1 = new ListNode();
            for(int i = 0; i < sb1.length(); i++){
                if(ll1 == null){
                    ll1 = temp1 = new ListNode(Integer.parseInt(String.valueOf(sb1.charAt(i))));
                }else {
                    temp1.next = new ListNode(Integer.parseInt(String.valueOf(sb1.charAt(i))));
                    temp1 = temp1.next;
                }
            }
            for(int i = 0; i < sb2.length(); i++){
                if(ll2 == null){
                    ll2 = temp2 = new ListNode(Integer.parseInt(String.valueOf(sb2.charAt(i))));
                }else {
                    temp2.next = new ListNode(Integer.parseInt(String.valueOf(sb2.charAt(i))));
                    temp2 = temp2.next;
                }
            }
            ListNode res =  addTwoNumbers2(ll1,ll2);
            StringBuffer sb = new StringBuffer();
            while(res != null){
                sb.append(res.val);
                res = res.next;
            }
            sb.reverse();
            ListNode res1 = null;
            ListNode temp = null;
            for(int i = 0; i < sb.length(); i++){
                if(res1 == null){
                    res1 = temp = new ListNode(Integer.parseInt(String.valueOf(sb.charAt(i))));
                }else {
                    temp.next = new ListNode(Integer.parseInt(String.valueOf(sb.charAt(i))));
                    temp = temp.next;
                }
            }
            return res1;
        }



        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

            ListNode head = null ;
            ListNode tail = null;
            int a = 0;
            while(l1 != null || l2 != null){
                int num1 = l1 != null? l1.val : 0;
                int num2 = l2 != null? l2.val : 0;
                //将相同位上的数字进行相加
                int sum = num1 + num2 + a;
                if(head == null){
                    //给头head接点指定接点tail
                    head = tail = new ListNode(sum % 10);
                }else {
                    //进行拼接
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                a = sum / 10;
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            if(a > 0){
                //当a大于0，则给最后一位进1
                tail.next = new ListNode(a);
            }
            return head;
        }

        @Test
        public void test(){
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(3);
            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);
            addTwoNumbers3(l1,l2);
        }



    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;
        while(n1!=null || n2!=null){
            int t1 = n1==null?0:n1.val;
            int t2 = n2==null?0:n2.val;
            int total = t1+t2+carry;
            carry = 0;
            ListNode newNode = new ListNode(total%10);
            curr.next = newNode;
            curr = curr.next;
            if(total>=10){
                carry = 1;
            }
            if(n1!=null){
                n1 = n1.next;
            }
            if(n2!=null){
                n2 = n2.next;
            }
        }
        if(carry == 1){
            curr.next = new ListNode(1);
        }
        return reverse(head.next);
    }

    /**
     * 反转单链表
     * @param l
     * @return
     */
    public ListNode reverse(ListNode l){
        ListNode pre = null;
        ListNode curr = l;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
