package com.leetcode.editor.cn;
//647
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 394 👎 0

public class PalindromicSubstrings{

    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < 2 * n - 1; ++i) {
                int l = i / 2, r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    --l;
                    ++r;
                    ++ans;
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}