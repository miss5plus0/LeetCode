import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (36.28%)
 * Likes:    174
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 46.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j = colBegin; j <= colEnd; j++) result.add(matrix[rowBegin][j]);
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++) result.add(matrix[i][colEnd]);
            colEnd--;
            if(rowBegin <= rowEnd) for(int j = colEnd; j >= colBegin; j--) result.add(matrix[rowEnd][j]);
            rowEnd--;
            if(colBegin <= colEnd) for(int i = rowEnd; i >= rowBegin; i--) result.add(matrix[i][colBegin]);
            colBegin++;
        }
        return result;
    }
}

