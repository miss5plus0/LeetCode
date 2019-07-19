import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int lo, hi, currentSum;
        for(int i = 0; i < nums.length - 3; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                for(int j = i + 1; j < nums.length - 2; j++){
                    if(j == i + 1 || (j > i + 1 && nums[j] != nums[j -1])){
                        lo = j + 1;
                        hi = nums.length - 1;
                        while(lo < hi){
                            currentSum = nums[i] + nums[j] + nums[lo] + nums[hi];
                            if(currentSum == target){
                                result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                                while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                                while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                                lo++;
                                hi--;
                            }else if(currentSum < target) lo++;
                            else hi--;
                        }
                    }
                }
            }
        }
        return result;
    }
}

