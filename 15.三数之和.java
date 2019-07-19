import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
class Solution {
    //my solution(in quetion)

    // public List<List<Integer>> threeSum(int[] nums) {
    //     HashMap container = new HashMap();
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     List<Integer> pair = new ArrayList<Integer>();
    //     pair.add(0);
    //     pair.add(1);
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i + 1; j < nums.length; j++){
    //             if(container.containsKey(nums[j])){
    //                 pair = (List) container.get(nums[j]);
    //                 List<Integer> aResult = new ArrayList<Integer>();
    //                 aResult.add(pair.get(0));
    //                 aResult.add(pair.get(1));
    //                 aResult.add(nums[j]);
    //                 if(!result.contains(aResult)){
    //                     result.add(aResult);
    //                 }
    //             }else{
    //                 pair.set(0, nums[i]);
    //                 pair.set(1, nums[j]);
    //                 pair = pair.subList(0, 2);
    //                 // System.out.println(pair);
    //                 container.put(0 - nums[i] - nums[j], pair);
    //                 // System.out.println(container.entrySet());
    //             }
    //         }
    //     }
    //     return result;
    // }
    //top voted solution

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return result;
    }
}

