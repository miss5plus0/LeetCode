import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentSum = nums[0] + nums[1] + nums[2];
        int result = currentSum;
        int lo, hi;
        for(int i = 0; i < nums.length - 2; i++){
            lo = i + 1;
            hi = nums.length - 1;
            while(lo < hi){
                currentSum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(currentSum - target) < Math.abs(result - target)) result = currentSum;
                if(currentSum < target) lo++;
                else hi--;
            }
        }
        return result;
    }
}


