/**
 * @author 孙铃
 * @date 2024/10/29 16:29
 */
package com.sl.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_LCR147
 * @Date：2024/10/29
 * @Filename：problem_LCR147
 */
public class problem_LCR147 {

     class MinStack {

        public List<Integer> stack;

        public Integer min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int x) {
           stack.add(x);
            if(x < min) {
               min = x;
            }
        }

        public void pop() {
            //删除
           Integer remove = stack.remove(stack.size() - 1);
            System.out.println(remove);
            System.out.println("==");
            System.out.println(min);
//            System.out.println(remove.equals(min));
           if(remove.equals(min)){
               System.out.println(!stack.isEmpty());
              if(!stack.isEmpty()){
                 //查找最小的min
                 min = stack.get(0);
                 for(Integer x : stack){
                     System.out.println(x <= min);
                    if(x <= min){
                       min = x;
//                        System.out.println();
                    }
                 }
              }else {
                  min = Integer.MAX_VALUE;
              }
           }
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
         return min;
        }
    }

}
