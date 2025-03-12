/**
 * @author 孙铃
 * @date 2025/3/10 14:29
 */
package com.sl.multithreading;

/**
 * @Author：孙铃
 * @Package：com.sl.multithreading
 * @Project：arithmetic
 * @name：Deadlock
 * @Date：2025/3/10
 * @Filename：Deadlock
 */
public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Lock1 acquired, waiting for Lock2");
            synchronized (lock2) {
                System.out.println("Lock2 acquired");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Lock2 acquired, waiting for Lock1");
            synchronized (lock1) {
                System.out.println("Lock1 acquired");
            }
        }
    }
}
