/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (61.60%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    19.4K
 * Total Submissions: 31.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for(int j = 1; j < n; j++) grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) grid[i][j] += grid[i - 1][j] < grid[i][j - 1]? grid[i - 1][j]: grid[i][j - 1];
        }
        return grid[m - 1][n - 1];
    }
}

