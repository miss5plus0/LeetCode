

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int swapFirstId = nums.length - 1;
        while(swapFirstId >= 1 && nums[swapFirstId] <= nums[swapFirstId - 1]) swapFirstId--;
        if(swapFirstId > 0){
            int swapSecondId = nums.length - 1;
            while(nums[swapSecondId] <= nums[swapFirstId - 1]) swapSecondId--;
            swap(nums, swapFirstId - 1, swapSecondId);
        }
        reverse(nums, swapFirstId, nums.length - 1);
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void reverse(int[] A, int i, int j){
        while(i < j) swap(A, i++, j--);
    }
}

