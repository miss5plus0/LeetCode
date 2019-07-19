/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */
class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int lastPos = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = max > i + nums[i]? max: i + nums[i];
            if(i == lastPos){
                step++;
                lastPos = max;
            }
        }
        return step;
    }
}

