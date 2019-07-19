/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for(int n: nums) if(len == 0 || n != nums[len - 1]) nums[len++] = n; 
        return len;
    }
}

