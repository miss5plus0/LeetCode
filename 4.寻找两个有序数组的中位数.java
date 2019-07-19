/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        boolean odd = (len1 + len2) % 2 == 1;
        int midIdx;
        int mid1 = 0;
        if(odd){
            midIdx = (len1 + len2)/2;
        }else{
            midIdx = (len1 + len2)/2 - 1;
        }
        while(idx1 != len1 && idx2 != len2){
            if(nums1[idx1] <= nums2[idx2]){
                if(idx1 + idx2 == midIdx){
                    if(odd){
                        return (double)nums1[idx1];
                    }else{
                        mid1 = nums1[idx1];
                    }
                }
                if(idx1 + idx2 == midIdx + 1){
                    return (double)(mid1 + nums1[idx1])/2;
                }
                idx1++;
            }else{
                if(idx1 + idx2 == midIdx){
                    if(odd){
                        return (double)nums2[idx2];
                    }else{
                        mid1 = nums2[idx2];
                    }
                }
                if(idx1 + idx2 == midIdx + 1){
                    return (double)(mid1 + nums2[idx2])/2;
                }
                idx2++;
            }
        }
        while(idx1 != len1){
            if(idx1 + idx2 == midIdx){
                if(odd){
                    return (double)nums1[idx1];
                }else{
                    mid1 = nums1[idx1];
                }
            }
            if(idx1 + idx2 == midIdx + 1){
                return (double)(mid1 + nums1[idx1])/2;
            }
            idx1++;
        }
        while(idx2 != len2){
            if(idx1 + idx2 == midIdx){
                if(odd){
                    return (double)nums2[idx2];
                }else{
                    mid1 = nums2[idx2];
                }
            }
            if(idx1 + idx2 == midIdx + 1){
                return (double)(mid1 + nums2[idx2])/2;
            }
            idx2++;
        }
        return 1.0;
    }
}

