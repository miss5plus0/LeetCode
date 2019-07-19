import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start){
        if(remain < 0) return;
        if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                backTrack(list, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

