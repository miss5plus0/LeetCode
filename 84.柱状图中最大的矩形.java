import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (38.17%)
 * Likes:    196
 * Dislikes: 0
 * Total Accepted:    8.4K
 * Total Submissions: 22.1K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    //solution 1
    //    int len = heights.length;
    //    int[] leftBar = new int[len];
    //    int[] rightBar = new int[len];
    //    for(int i = 0; i < len; i++){
    //         int left = i;
    //         int right = i;
    //         while(left > 0 && heights[left - 1] >= heights[i]) left--;
    //         leftBar[i] = left;
    //         while(right < len - 1 && heights[right + 1] >= heights[i]) right++;
    //         rightBar[i] = right;
    //    }
    //    int maxArea = 0;
    //    for(int i = 0; i < len; i++){
    //        maxArea = Math.max(maxArea, heights[i] * (rightBar[i] - leftBar[i] + 1));
    //    }
    //    return maxArea;

    //solution 2:Stack
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i <= len; i++){
            int h = i == len? 0: heights[i];
            if(s.isEmpty() || h >= heights[s.peek()]) s.push(i);
            else{
                int bar = s.pop();
                maxArea = Math.max(maxArea, heights[bar] * (s.isEmpty()? i: i - s.peek() - 1));
                i--;
            }
        }
        return maxArea;
    }
}

