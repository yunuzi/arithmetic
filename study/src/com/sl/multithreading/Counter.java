/**
 * @author 孙铃
 * @date 2025/3/10 13:50
 */
package com.sl.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：孙铃
 * @Package：com.sl.multithreading
 * @Project：arithmetic
 * @name：Counter
 * @Date：2025/3/10
 * @Filename：Counter
 */
public class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void  increment() {
        //枷锁
        lock.lock();
        try{
//            Thread thread = Thread.currentThread();
//            System.out.println(thread.getName() + " is running");
            count++;
        }finally {
            lock.unlock();
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(){
        count = 0;
    }
}
