package ccc.study.suixianglu.dynamicProgramming;

/**
 * @author c
 * @date 2023/3/27 0:17
 */
public class T63_不同路径II {
    /*
    难度：medium
    --------------------------------------------------------------------------------
    题目：
        一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

        现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

        网格中的障碍物和空位置分别用 1 和 0 来表示。

        链接：https://leetcode.cn/problems/unique-paths-ii
    --------------------------------------------------------------------------------
    解题思路：
        动规五部曲：
            1、确定dp数组（dp table）以及下标的含义
                dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。

            2、确定递推公式
                递推公式和62.不同路径一样，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
                但这里需要注意一点，因为有了障碍，(i, j)如果就是障碍的话应该就保持初始状态（初始状态为0）。

            3、dp数组如何初始化
                因为从(0, 0)的位置到(i, 0)的路径只有一条，所以dp[i][0]一定为1，dp[0][j]也同理。
                但如果(i, 0) 这条边有了障碍之后，障碍之后（包括障碍）都是走不到的位置了，所以障碍之后的dp[i][0]应该还是初始值0。
                for循环的终止条件，一旦遇到obstacleGrid[i][0] == 1的情况就停止dp[i][0]的赋值1的操作，dp[0][j]同理

            4、确定遍历顺序
                从递归公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 中可以看出，一定是从左到右一层一层遍历，
                这样保证推导dp[i][j]的时候，dp[i - 1][j] 和 dp[i][j - 1]一定是有数值。

            5、举例推导dp数组
    --------------------------------------------------------------------------------
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 确定dp
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1
                || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 初始化
        for(int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++){
            dp[0][i] = 1;
        }
        // 遍历
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 1; j < obstacleGrid[0].length; j++){
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
