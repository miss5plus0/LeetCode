/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        while(lo < hi){
            if(nums[mid] == target) return mid;
            if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && nums[mid] > target) hi = mid - 1;
                else lo = mid + 1;
            }else{
                if(nums[mid] < target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
            mid = (lo + hi) / 2; 
        }
        return nums[mid] == target? mid: -1;
    }
}

