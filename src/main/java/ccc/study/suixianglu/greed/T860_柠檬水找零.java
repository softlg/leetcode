package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/3/22 20:44
 */
public class T860_柠檬水找零 {
    /*
    难度：easy
    --------------------------------------------------------------------------------
    题目：
           在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

            每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位
            顾客向你支付 5 美元。

            注意，一开始你手头没有任何零钱。

            给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

            链接：https://leetcode.cn/problems/lemonade-change
    --------------------------------------------------------------------------------
    解题思路：
        有如下三种情况：

            情况一：账单是5，直接收下。
            情况二：账单是10，消耗一个5，增加一个10
            情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
    --------------------------------------------------------------------------------
     */

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        //
        for(int i = 0; i < bills.length; i++){
            //
            if(bills[i] == 5){
                five++;
            }
            if(bills[i] == 10){
                if(five < 0){
                    return false;
                }
                five--;
                ten++;
            }
            if(bills[i] == 20){
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
