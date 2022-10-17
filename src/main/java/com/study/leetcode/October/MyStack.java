package com.study.leetcode.October;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： liaoguang
 * @date： 2022/10/17 16:39
 * Description： 225. 用队列实现栈
 */
public class MyStack {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：  225. 用队列实现栈
        请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

            实现 MyStack 类：

            void push(int x) 将元素 x 压入栈顶。
            int pop() 移除并返回栈顶元素。
            int top() 返回栈顶元素。
            boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
             

    注意：

    你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
    你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。

    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
    */

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * 每 offer 一个数（A）进来，都重新排列，把这个数（A）放到队列的队首
     * @param x
     */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        //移动除了 A 的其它数
        while (size-- > 1){
            queue.offer(queue.poll());
        }

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
