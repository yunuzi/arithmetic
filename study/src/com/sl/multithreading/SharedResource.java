/**
 * @author 孙铃
 * @date 2025/3/10 14:11
 */
package com.sl.multithreading;

/**
 * @Author：孙铃
 * @Package：com.sl.multithreading
 * @Project：arithmetic
 * @name：SharedResource
 * @Date：2025/3/10
 * @Filename：SharedResource
 */
public class SharedResource {
    private boolean isAvailable = false;
    private int count = 0;

    public synchronized void produce() throws InterruptedException {
        while (isAvailable) {
            wait();
        }
        count++;
        System.out.println("Produced" + "商品数量：" + count);
        isAvailable = true;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!isAvailable) {
            wait();
        }
        count--;
        System.out.println("Consumed" + "商品数量：" + count);
        if(count < 0) {
            System.out.println("商品已经售完");
        }
        isAvailable = false;
        notify();
    }
}
