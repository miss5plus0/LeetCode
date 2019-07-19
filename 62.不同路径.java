/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (54.59%)
 * Likes:    261
 * Dislikes: 0
 * Total Accepted:    26.2K
 * Total Submissions: 47.9K
 * Testcase Example:  '3\n2'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2:
 * 
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 */
class Solution {
    // public int uniquePaths(int m, int n) {
    //     if(m == 1 || n == 1) return 1;
    //     m--;
    //     n--;
    //     if(m < n){
    //         int temp = m;
    //         m = n;
    //         n = temp;
    //     }
    //     long res = 1;
    //     for(int i = m + 1; i <= m + n; i++){
    //         res *= i;
    //         res /= i - m;
    //     }
    //     return (int)res;
    // }
    public int uniquePaths(int m, int n) {
        int [][] matrix = new int[m][n];
        if(m == 0 || n == 0) return 0;
        for(int i = 0; i < m; i++) matrix[i][0] = 1;
        for(int j = 1; j < n; j++) matrix[0][j] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }
        return matrix[m - 1][n - 1];
    }
}

