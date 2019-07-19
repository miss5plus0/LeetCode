/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (38.03%)
 * Likes:    153
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 34.3K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(word.charAt(0) == board[i][j] && search(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, boolean[][] visited, int index){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        if(search(board, word, i + 1, j, visited, index+1) ||
        search(board, word, i - 1, j, visited, index+1) ||
        search(board, word, i, j + 1, visited, index+1) ||
        search(board, word, i, j - 1, visited, index+1)) return true;
        visited[i][j] = false;
        return false;

    }
}

