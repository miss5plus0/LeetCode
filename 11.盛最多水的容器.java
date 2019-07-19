/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    //my solution
    
    // public int maxArea(int[] height) {
    //     int max = 0;
    //     int area;
    //     for(int i = 0; i < height.length; i++){
    //         for(int j = i + 1; j < height.length; j++){
    //             area = (j-i) * Math.min(height[i], height[j]);
    //             if(max < area){
    //                 max = area;
    //             }
    //         }
    //     }
    //     return max;
    // }

    //top voted solution
    public int maxArea(int[] height) {
        int area;
        int lo = 0, hi = height.length-1;
        int loMax = height[lo], hiMax = height[hi];
        int max = 0;
        while(lo < hi){
            area = (hi - lo) * (loMax < hiMax ? loMax : hiMax);
            max = area > max ? area : max;
            if(loMax < hiMax){
                while(lo < hi && height[lo] <= loMax) lo++;
                loMax = height[lo];
            }else{
                while(lo < hi && height[hi] <= hiMax) hi--;
                hiMax = height[hi];
            }
        }
        return max;
    }
}

