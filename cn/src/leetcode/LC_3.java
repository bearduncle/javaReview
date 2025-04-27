package leetcode;

//3. 无重复字符的最长子串

import java.util.TreeSet;

//        给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
//        示例 1:
//
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: s = "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: s = "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//        提示：
//
//        0 <= s.length <= 5 * 104
//        s 由英文字母、数字、符号和空格组成
public class LC_3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int slow = 0;
        int fast = 1;
        int max = Integer.MIN_VALUE;
        while (fast < len) {
            String temp = s.substring(slow, fast);
            String tempC = String.valueOf(s.charAt(fast));
            if (temp.contains(tempC)) {
                //子串存在和当前字符重复
                slow++;
            } else {
                //子串不存在当前字符
                max = Math.max(max, fast - slow + 1);
                fast++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
//        方法二：借助set（实测不如方法一）
        TreeSet<Character> set = new TreeSet<>();
        int fast = 0, slow = 0;
        int length = 0;
        int resLength = 0;
        while (fast < s.length() && slow <= fast) {
            Character tempChar = s.charAt(fast);
            if (!set.contains(tempChar)) {
                set.add(tempChar);
                length++;
                fast++;
                resLength = Math.max(resLength, length);
            } else {
                while (set.contains(tempChar)) {
                    set.remove(s.charAt(slow));
                    length--;
                    slow++;
                }
                set.add(tempChar);
                length++;
                fast++;
            }
        }
        return resLength;
    }
}
