/**
 * @author 孙铃
 * @date 2025/3/10 13:49
 */
package com.sl.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author：孙铃
 * @Package：com.sl.multithreading
 * @Project：arithmetic
 * @name：Main
 * @Date：2025/3/10
 * @Filename：Main
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread();
//        thread.start();
//
//        Counter count = new Counter();
//        Counter count1 = new Counter();
//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 10; j++) {
//                    count.increment();
//                    Thread thread1 = Thread.currentThread();
//                    System.out.println(thread1.getName() + " " + count.getCount() + " ");
////                    System.out.println(count.getCount() + " " + count1.getCount());
//                }
//            }).start();
//        }
//        for(int k = 0;k < 100;k++) {
//            Counter counter = new Counter();
//            Thread thread1 = new Thread(() -> {
//                for (int i = 0; i < 10000; i++) {
//                    counter.increment();
//                }
//            });
//
//            Thread thread2 = new Thread(() -> {
//                for (int i = 0; i < 10000; i++) {
//                    counter.increment();
//                }
//            });
//
//            thread1.start();
//            thread2.start();
//            thread1.join();
//            thread2.join();
//            System.out.println(counter.getCount());
//            counter.setCount();
//        }

//        SharedResource resource = new SharedResource();
//        Thread producer = new Thread(() -> {
//            try {
//                for(int i = 0; i < 500; i++) {
//                    resource.produce();
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//
//        Thread consumer = new Thread(() -> {
//            try {
//                for(int i = 0; i < 500; i++) {
//                    resource.consume();
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//        consumer.start();
//        producer.start();
//
//        producer.join();
//        consumer.join();

//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> {
//                System.out.println("Task executed by " + Thread.currentThread().getName());
//            });
//        }
//        executor.shutdown();

//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//        for(int i = 0; i < 100000000; i++) {
//            Map<String,Integer> map = new HashMap<>();
//            map.put("key1", 1);
//            map.put("key2", 2);
//            System.out.println(map.get("key1") + "当前" +i);
//        }

        Deadlock deadlock = new Deadlock();
        Thread thread1 = new Thread(deadlock::method1);
        Thread thread2 = new Thread(deadlock::method2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
