/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1) i++;
            else if(nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
            else i++;
        }
        i = 0;
        while(i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

