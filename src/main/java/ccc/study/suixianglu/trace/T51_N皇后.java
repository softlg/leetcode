package ccc.study.suixianglu.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author c
 * @date 2023/2/21 19:24
 */
public class T51_N皇后 {
    /*
    难度：hard
    --------------------------------------------------------------------------------
    题目：
        按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

        链接：https://leetcode.cn/problems/n-queens
    --------------------------------------------------------------------------------
    解题思路：
                回溯
    --------------------------------------------------------------------------------
     */

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for(char[] c : chessboard){
            Arrays.fill(c, '.');
        }
        //
        backTracking(n, 0,chessboard);
        return res;
    }

    public void backTracking(int n, int row, char[][] chessboard){
        if(n == row){
            res.add(Array2List(chessboard));
            return;
        }
        //
        for(int col = 0; col < n; ++col){
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTracking(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列 // 相当于剪枝
        for (int i=0; i<row; ++i) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
