/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (73.47%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 15.8K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int col, row;
        int i = 1;
        while(i <= n*n){
            col = colBegin;
            while(i <= n*n && col <= colEnd) res[rowBegin][col++] = i++;
            rowBegin++;
            row = rowBegin;
            while(i <= n*n && row <= rowEnd) res[row++][colEnd] = i++;
            colEnd--;
            col = colEnd;
            while(i <= n*n && col >= colBegin) res[rowEnd][col--] = i++;
            rowEnd--;
            row = rowEnd;
            while(i <= n*n && row >= rowBegin) res[row--][colBegin] = i++;
            colBegin++;
        }
        return res;
    }
}

