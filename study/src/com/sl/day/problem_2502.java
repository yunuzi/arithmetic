/**
 * @author 孙铃
 * @date 2025/2/25 9:27
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2502
 * @Date：2025/2/25
 * @Filename：problem_2502
 */
public class problem_2502 {
    /**
     * 2502. 设计内存分配器
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数 n ，表示下标从 0 开始的内存数组的大小。所有内存单元开始都是空闲的。
     *
     * 请你设计一个具备以下功能的内存分配器：
     *
     * 分配 一块大小为 size 的连续空闲内存单元并赋 id mID 。
     * 释放 给定 id mID 对应的所有内存单元。
     * 注意：
     *
     * 多个块可以被分配到同一个 mID 。
     * 你必须释放 mID 对应的所有内存单元，即便这些内存单元被分配在不同的块中。
     * 实现 Allocator 类：
     *
     * Allocator(int n) 使用一个大小为 n 的内存数组初始化 Allocator 对象。
     * int allocate(int size, int mID) 找出大小为 size 个连续空闲内存单元且位于  最左侧 的块，分配并赋 id mID 。返回块的第一个下标。如果不存在这样的块，返回 -1 。
     * int freeMemory(int mID) 释放 id mID 对应的所有内存单元。返回释放的内存单元数目。
     */
    class Allocator {

        private final int[] memory;

        public Allocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int free = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] > 0) { // 已分配
                    free = 0; // 重新计数
                    continue;
                }
                free++;
                if (free == size) { // 找到了
                    Arrays.fill(memory, i - size + 1, i + 1, mID);
                    return i - size + 1;
                }
            }
            return -1; // 无法分配内存
        }

        public int freeMemory(int mID) {
            int ans = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == mID) {
                    ans++;
                    memory[i] = 0; // 标记为空闲内存
                }
            }
            return ans;
        }

//        public int[] memory;
//        public int n;
//        public Allocator(int n) {
//            memory = new int[n];
//            this.n = n;
//            memory[0] = 1-n;
//        }
//
//        int action = 0;
//
//        public int allocate(int size, int mID) {
//            int i = 0;
//            int pos = -1;
//            while (i < n) {
//                if (memory[i] < 0) {
//                    if (memory[i - memory[i]] == 0 && memory[i] <= 1-size) {
//                        if (memory[i - memory[i]] == 0 && memory[i] < 1-size) {
//                            memory[i+size] = memory[i] + size;
//                        }
//                        pos = i;
//                        memory[i] = 1-size;
//                        memory[i+size-1] = mID;
//                        break;
//                    }
//                    i -= memory[i];
//                } else if (memory[i] == 0 && size == 1) {
//                    memory[i] = mID;
//                    pos = i;
//                    break;
//                } else {
//                    i++;
//                }
//            }
//            return pos;
//        }
//
//        public int freeMemory(int mID) {
//            int total = 0;
//            int lstBlankIdx = -1;
//            int i = 0;
//            while (i < n) {
//                if (memory[i] == mID) {
//                    memory[i] = 0;
//                    if (lstBlankIdx < 0) {
//                        lstBlankIdx = i;
//                    }
//                    if (i < n-1) {
//                        if (memory[i+1] == 0) {
//                            i++;
//                        } else if ((memory[i+1] < 0 && memory[i + 1 - memory[i+1]] == 0)) {
//                            i = i + 1 - memory[i+1];
//                        }
//                    }
//                    memory[lstBlankIdx] = lstBlankIdx - i;
//
//                    total++;
//                    i++;
//                } else if (memory[i] < 0) {
//                    if (memory[i - memory[i]] == mID) {
//                        memory[i - memory[i]] = 0;
//                        if (lstBlankIdx < 0) {
//                            lstBlankIdx = i;
//                        }
//                        total -= memory[i] - 1;
//                        i -= memory[i];
//                        if (i < n-1) {
//                            if (memory[i+1] == 0) {
//                                i++;
//                            } else if ((memory[i+1] < 0 && memory[i + 1 - memory[i+1]] == 0)) {
//                                i = i + 1 - memory[i+1];
//                            }
//                        }
//                        memory[lstBlankIdx] = lstBlankIdx - i;
//                        i++;
//                    } else {
//                        if (memory[i - memory[i]] == 0) {
//                            lstBlankIdx = i;
//                        } else {
//                            lstBlankIdx = -1;
//                        }
//                        i -= memory[i]-1;
//                    }
//                } else {
//                    if (memory[i] == 0) {
//                        lstBlankIdx = i;
//                    } else {
//                        lstBlankIdx = -1;
//                    }
//                    i++;
//                }
//            }
//            return total;
//        }
    }

}
