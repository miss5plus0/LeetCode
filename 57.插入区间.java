import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (34.43%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 17.9K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        if(i == intervals.length || intervals[i][0] > newInterval[1]) res.add(newInterval);
        else{
            int left = Math.min(intervals[i][0], newInterval[0]);
            int right = Math.max(intervals[i][1], newInterval[1]);
            while(i < intervals.length - 1 && right >= intervals[i + 1][0]){
                right = Math.max(intervals[i + 1][1], right);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        while(i < intervals.length ) res.add(intervals[i++]);
        return res.toArray(new int[0][]);
    }
}

