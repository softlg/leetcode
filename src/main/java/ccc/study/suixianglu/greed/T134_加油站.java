package ccc.study.suixianglu.greed;

/**
 * @author c
 * @date 2023/3/21 22:46
 */
public class T134_加油站 {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
        你从其中的一个加油站出发，开始时油箱为空。

        给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
        如果存在解，则 保证 它是 唯一 的。

        链接：https://leetcode.cn/problems/gas-station
    --------------------------------------------------------------------------------
    解题思路：
           贪心：局部最优
    --------------------------------------------------------------------------------
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // 当前累加rest[i]和 curSum一旦小于0
            if(curSum < 0){
                // 起始位置更新为i+1
                start = i + 1;
                curSum = 0;
            }
        }
        return totalSum >= 0 ? start : -1;
    }

}
