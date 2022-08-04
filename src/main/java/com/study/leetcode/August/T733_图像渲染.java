package com.study.leetcode.August;
/**
 * @author c
 * 2022/8/3
 */
public class T733_图像渲染 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。

        你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。

        为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
        接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程
        。将所有有记录的像素点的颜色值改为 newColor 。

        最后返回 经过上色渲染后的图像 

    --------------------------------------------------------------------------------
    解题思路：
        1、记录下当前像素点的原像素值
        2、当前像素点像素值等于newColor直接返回，否则进入第3步
        3、将当前像素值改成newColor，
        4、对当前像素点上下左右四个方向满足以下条件的点传入floodFill方法，继续上述步骤。
            坐标不超数组长度
            像素值等于当前点的像素值（不等的话要么是遍历过了，要么是本来就不等）

    --------------------------------------------------------------------------------
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 先记录当前像素点的值，用作后面的判断
        int curColor = image[sr][sc];
        // 若初始像素跟要修改的相同，不需要修改直接返回
        if (curColor == newColor) {
            return image;
        }
        // 要先修改像素再进入下面递归的判断
        // 相当于标记当前像素点已被遍历过，否则相当于死循环，跳不出递归
        image[sr][sc] = newColor;
        if (sr - 1 >= 0 && image[sr - 1][sc] == curColor) {
            floodFill(image, sr-1, sc, newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == curColor) {
            floodFill(image, sr+1, sc, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == curColor) {
            floodFill(image, sr, sc-1, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == curColor) {
            floodFill(image, sr, sc+1, newColor);
        }
        return image;
    }

}
