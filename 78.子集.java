import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (74.07%)
 * Likes:    274
 * Dislikes: 0
 * Total Accepted:    24.8K
 * Total Submissions: 33.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start){
        res.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtracking(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

