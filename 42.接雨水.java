import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */
class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int i = 0, botWater = 0, sumBotWater = 0;
        while(i < height.length){
            if(s.isEmpty() || height[i] <= height[s.peek()]) s.push(i++);
            else{
                int bot = s.pop();
                botWater = s.isEmpty()? 0: (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
                sumBotWater += botWater;
            }
        }
        return sumBotWater;
    }
}

