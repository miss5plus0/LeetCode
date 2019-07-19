import java.util.Stack;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (44.35%)
 * Likes:    154
 * Dislikes: 0
 * Total Accepted:    5.1K
 * Total Submissions: 11.5K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] numMatrix = new int[m][n];
        for(int j = 0; j < n; j++) numMatrix[0][j] = matrix[0][j] == '0'? 0: 1;
        int maxArea = getMaxArea(numMatrix[0]);
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                numMatrix[i][j] = matrix[i][j] == '0'? 0: numMatrix[i - 1][j] + 1;
            }
            maxArea = Math.max(maxArea, getMaxArea(numMatrix[i]));
        }
        return maxArea;
    }

    private int getMaxArea(int[] height){
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = i == len? 0: height[i];
            if(s.isEmpty() || h >= height[s.peek()]) s.push(i);
            else{
                int bar = s.pop();
                maxArea = Math.max(maxArea, height[bar] * (s.isEmpty()? i: i - s.peek() - 1));
                i--;
            }
        }
        return maxArea;
    }
}

