/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (33.86%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    7.5K
 * Total Submissions: 22.2K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 
 * 进阶:
 * 
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] < nums[hi] || nums[mid] < nums[lo]){
                if(nums[mid] <= target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }else if(nums[mid] > nums[lo] || nums[mid] > nums[hi]){
                if(nums[lo] <= target && nums[mid] >= target) hi = mid - 1;
                else lo = mid + 1;
            }else hi--;
            
        }
        return false;
    }
}

