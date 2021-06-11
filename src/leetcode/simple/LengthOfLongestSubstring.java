package leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WhaleFall541
 * @Date: 2021/5/31 21:51
 * 第三题
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abx";
        System.out.println(lengthOfLongestSubstring(s));

    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet hs = new HashSet();

        int pos = -1, lenSubStr = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            if (i != 0)
                hs.remove(s.charAt(i - 1));// 每次循环完成一轮后，滑动一下，清除上一周期的开始元素
            while (pos + 1 < n && !hs.contains(s.charAt(pos + 1))) { //aab
                hs.add(s.charAt(pos + 1));
                pos++;
            }
            lenSubStr = Math.max(lenSubStr, pos - i + 1);
        }
        return lenSubStr;
    }

}

