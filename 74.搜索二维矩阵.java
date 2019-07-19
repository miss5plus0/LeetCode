/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.34%)
 * Likes:    67
 * Dislikes: 0
 * Total Accepted:    11.7K
 * Total Submissions: 33.1K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //my solution 速度快，内存大
        // int m = matrix.length;
        // if(m == 0) return false;
        // int n = matrix[0].length;
        // if(n == 0) return false;
        // int i = 0;
        // while(i < matrix.length && (matrix[i][0] > target || matrix[i][n - 1] < target)) i++;
        // if(i < m){
        //     int lo = 0;
        //     int hi = n - 1;
        //     while(lo <= hi){
        //         int mid = (lo + hi) / 2;
        //         if(matrix[i][mid] == target) return true;
        //         if(matrix[i][mid] < target) lo = mid + 1;
        //         else hi = mid - 1;
        //     }
        // }
        // return false;

        //top rated solution  速度慢，但是内存小
        int i = 0;
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}

