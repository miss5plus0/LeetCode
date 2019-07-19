import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

class Test {
    //my answer
    // public int[] twoSum(int[] nums, int target) {
    //     int found = 0; 
    //     int[] indices = new int[2];
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i + 1; j < nums.length; j++){
    //             if(nums[i] + nums[j] == target){
    //                 indices[0] = i;
    //                 indices[1] = j;
    //                 // System.out.println(indeces);
    //                 found  = 1;
    //                 break;
    //             }
    //         }
    //         if(found == 1){
    //             break;
    //         }
    //     }
    //     return indices;
    // }

    //top voted solution
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[] {left, i};
            }
            else{
                tracker.put(target - nums[i], i);
                System.out.println(tracker.entrySet());
            }
        }
        return new int[2];
    }
    
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum(nums, target));
    }
}
