package com.sl.day;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_232
 * @Date：2024-3-4 10:40
 * @Filename：problem_232
 */
public class problem_232 {

    /**
     * 232. 用栈实现队列
     * 简单
     * 相关标签
     * 相关企业
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     *
     * 实现 MyQueue 类：
     *
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     * 说明：
     *
     * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可
     */
    class MyQueue {

         Stack<Integer> queue1 = new Stack<>();
         Stack<Integer> queue2 = new Stack<>();

        private MyQueue() {

        }

        public void push(int x) {
            queue2.push(x);
        }

        public int pop() {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()){
                    queue1.push(queue2.pop());
                }
            }
            int result = queue1.pop();
            return result;
        }

        public int peek() {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()){
                    queue1.push(queue2.pop());
                }
            }
            return queue1.peek();
        }

        public boolean empty() {
            if(queue1.isEmpty() && queue2.isEmpty()){
                return true;
            }
            return false;
        }
    }

    @Test
    public void test(){
         MyQueue obj = new MyQueue();
         obj.push(1);
         obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        System.out.println(param_2);
        System.out.println(param_3);
        boolean param_4 = obj.empty();
    }
}
