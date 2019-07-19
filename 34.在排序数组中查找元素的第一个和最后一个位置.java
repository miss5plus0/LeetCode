/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = findFirst(nums, target);
        if(lo == nums.length || nums[lo] != target) return new int[]{-1, -1};
        return new int[]{lo, findFirst(nums, target + 1) - 1};
    }

    public int findFirst(int[] nums, int target){
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

