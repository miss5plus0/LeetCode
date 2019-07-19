/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else if(nums[mid] > target) hi = mid;
            else return mid;
        }
        return lo;
    }
}

