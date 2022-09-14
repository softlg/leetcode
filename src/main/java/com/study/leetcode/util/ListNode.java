package com.study.leetcode.util;

/**
 * 类名 ：Java类就是一种自定义的数据结构
 * @author c
 * 2022.09.07
 */
public class ListNode {

    /**
     * 成员变量：数值
     */
    int val;
    /**
     * 对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
     */
    ListNode next;

    /**
     * 一个参数的构造方法
     */
    public ListNode(int val){
        // 把接收的参数赋值给当前类的val变量
        this.val=val;
    }

    ListNode(int val, ListNode next) {
        // 这个就是包含两个参数的构造方法
        this.val = val;
        this.next = next;
    }

}

class Test{
    public static void main(String[] args){

        //创建首节点，节点的val是0.
        ListNode Listnode = new ListNode(0);
        //声明一个变量用来在移动过程中指向当前节点
        ListNode nextNode;
        //指向首节点，这样两个结点的指针指向同一个结点
        nextNode=Listnode;

        //创建链表
        for(int i=1;i<10;i++){
            //生成新的节点
            ListNode node = new ListNode(i);
            //把新节点连起来
            nextNode.next=node;
            //当前节点往后移动
            nextNode=nextNode.next;
        }
        //当for循环完成之后 nextNode指向最后一个节点，

        //重新赋值让它指向首节点
        nextNode=Listnode;
        //打印输出
        print(nextNode);

    }
    //打印输出方法
    static void print(ListNode listNoed){
        //创建链表节点
        while(listNoed!=null){
            System.out.println("节点:"+listNoed.val);
            listNoed=listNoed.next;
        }
        System.out.println();
    }

}
