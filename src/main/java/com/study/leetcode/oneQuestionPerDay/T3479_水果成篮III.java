package com.study.leetcode.oneQuestionPerDay;

public class T3479_水果成篮III {

    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
       https://leetcode.cn/problems/fruits-into-baskets-iii/description/?envType=daily-question&envId=2025-08-06
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    /**
     * 计算无法放置的水果数量
     * 问题描述：给定水果数组（每个元素为水果大小）和篮子数组（每个元素为篮子容量），
     * 规则是每个水果只能放入容量大于其大小的篮子，且每个篮子只能用一次，求无法放置的水果数量
     *
     * @param fruits 水果大小数组
     * @param baskets 篮子容量数组
     * @return 无法放置的水果数量
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // 构建线段树用于高效查询和更新篮子容量
        SegmentTreeEasy segmentTreeEasy = new SegmentTreeEasy(baskets);
        // 记录无法放置的水果数量
        int result = 0;

        // 遍历每个水果，尝试放置
        for (int fruit : fruits) {
            // 查找第一个容量大于当前水果大小的篮子索引
            int index = segmentTreeEasy.findFirstGreaterThan(fruit);
            if (index == -1) {
                // 没有找到合适的篮子，该水果无法放置
                result++;
            } else {
                // 找到合适的篮子，将其容量更新为-1（标记为已使用）
                segmentTreeEasy.update(index, -1);
            }
        }
        return result;
    }

    /**
     * 简易线段树实现
     * 功能：维护数组的最大值查询，并支持单点更新和查找第一个大于目标值的元素索引
     */
    public class SegmentTreeEasy {
        // 原始数据数组，存储篮子容量
        private int[] data;

        // 线段树数组（使用4倍原始数据长度的空间存储，确保足够）
        private int[] tree;

        /**
         * 构造方法，初始化线段树
         *
         * @param arr 原始数组（篮子容量数组）
         */
        public SegmentTreeEasy(int[] arr) {
            // 深拷贝原始数组，避免外部修改影响线段树
            data = new int[arr.length];
            System.arraycopy(arr, 0, data, 0, arr.length);

            // 初始化线段树数组（长度为原始数组的4倍，通过移位计算：arr.length << 1 << 1 等价于 arr.length * 4）
            tree = new int[arr.length << 1 << 1];

            // 递归构造线段树
            buildSegmentTree(0, 0, arr.length - 1);
        }

        /**
         * 递归构造线段树
         *
         * @param treeIndex 当前线段树节点在tree数组中的索引
         * @param left 当前节点负责的区间左端点
         * @param right 当前节点负责的区间右端点
         */
        private void buildSegmentTree(int treeIndex, int left, int right) {
            // 叶子节点：区间长度为1，直接存储原始数据的值
            if (left == right) {
                tree[treeIndex] = data[left];
                return;
            }
            // 计算左右子节点的索引
            int leftChildIndex = leftChildCalculate(treeIndex);
            int rightChildIndex = rightChildCalculate(treeIndex);

            // 计算区间中点（避免left + right溢出，使用left + (right - left)/2）
            int mid = left + ((right - left) >> 1);

            // 递归构造左子树（负责[left, mid]区间）
            buildSegmentTree(leftChildIndex, left, mid);
            // 递归构造右子树（负责[mid+1, right]区间）
            buildSegmentTree(rightChildIndex, mid + 1, right);

            // 当前节点的值为左右子节点的最大值（线段树维护区间最大值）
            tree[treeIndex] = Math.max(tree[leftChildIndex], tree[rightChildIndex]);
        }

        /**
         * 计算右子节点的索引
         *
         * @param treeIndex 当前节点的索引
         * @return 右子节点在tree数组中的索引
         */
        private int rightChildCalculate(int treeIndex) {
            // 右子节点索引公式：2 * treeIndex + 2（通过移位优化：(treeIndex << 1) + 2）
            return (treeIndex << 1) + 2;
        }

        /**
         * 计算左子节点的索引
         *
         * @param treeIndex 当前节点的索引
         * @return 左子节点在tree数组中的索引
         */
        private int leftChildCalculate(int treeIndex) {
            // 左子节点索引公式：2 * treeIndex + 1（通过移位优化：(treeIndex << 1) + 1）
            return (treeIndex << 1) + 1;
        }


        /**
         * 对外提供的更新方法：更新原始数组中指定索引的值
         *
         * @param index 原始数组中需要更新的索引
         * @param newValue 新值
         */
        public void update(int index, int newValue) {
            // 更新原始数据数组
            data[index] = newValue;
            // 调用递归方法更新线段树
            update(0, 0, data.length - 1, index, newValue);
        }

        /**
         * 递归更新线段树
         *
         * @param treeIndex 当前线段树节点的索引
         * @param left 当前节点负责的区间左端点
         * @param right 当前节点负责的区间右端点
         * @param index 原始数组中需要更新的索引
         * @param newValue 新值
         */
        private void update(int treeIndex, int left, int right, int index, int newValue) {
            // 叶子节点：直接更新当前节点的值
            if (left == right) {
                tree[treeIndex] = newValue;
                return;
            }
            // 计算左右子节点的索引
            int leftChildIndex = leftChildCalculate(treeIndex);
            int rightChildIndex = rightChildCalculate(treeIndex);

            // 计算区间中点
            int mid = left + (right - left >> 1);

            // 判断更新索引在左子树还是右子树
            if (index > mid) {
                // 索引在右子树区间，递归更新右子树
                update(rightChildIndex, mid + 1, right, index, newValue);
            } else {
                // 索引在左子树区间，递归更新左子树
                update(leftChildIndex, left, mid, index, newValue);
            }

            // 更新当前节点的值（左右子节点的最大值）
            tree[treeIndex] = Math.max(tree[leftChildIndex], tree[rightChildIndex]);
        }

        /**
         * 对外提供的查询方法：查找第一个大于目标值的元素索引（在原始数组中）
         *
         * @param value 目标值
         * @return 第一个大于目标值的元素索引，若不存在则返回-1
         */
        public int findFirstGreaterThan(int value) {
            // 调用递归方法查询
            return findFirstGreaterThan(0, 0, data.length - 1, value);
        }

        /**
         * 递归查询第一个大于目标值的元素索引
         *
         * @param treeIndex 当前线段树节点的索引
         * @param left 当前节点负责的区间左端点
         * @param right 当前节点负责的区间右端点
         * @param value 目标值
         * @return 第一个大于目标值的元素索引，若不存在则返回-1
         */
        private int findFirstGreaterThan(int treeIndex, int left, int right, int value) {
            // 若当前区间的最大值小于目标值，说明该区间无符合条件的元素
            if (tree[treeIndex] < value) {
                return -1;
            }
            // 叶子节点：当前元素即为符合条件的元素（因已判断最大值>=value）
            if (left == right) {
                return left;
            }

            // 计算左右子节点的索引
            int leftChildIndex = leftChildCalculate(treeIndex);
            int rightChildIndex = rightChildCalculate(treeIndex);

            // 计算区间中点
            int mid = left + (right - left >> 1);

            // 优先查询左子树（保证找到"第一个"符合条件的元素，即最左侧的）
            int index = findFirstGreaterThan(leftChildIndex, left, mid, value);
            // 若左子树无符合条件的元素，再查询右子树
            if (-1 == index) {
                index = findFirstGreaterThan(rightChildIndex, mid + 1, right, value);
            }
            return index;
        }

    }

    public static void main(String[] args) {
        System.out.println(new T3479_水果成篮III().numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));
        System.out.println(new T3479_水果成篮III().numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
    }

}
