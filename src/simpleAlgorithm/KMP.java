package simpleAlgorithm;// 此案例为Java版本 会输出所有的匹配模式串的位置

/**
 * @Author: WhaleFall541
 * @Date: 2021/5/22 11:00
 */
public class KMP {
    public static void main(String[] args) {
        String s = "this is a simple example simple";
        String p = "simple";
        indexKMP(s, p);
    }

    private static int indexKMP(String sStr, String pStr) {
        char[] string = sStr.toCharArray();
        char[] pattern = pStr.toCharArray();
        if (sStr.length() < pStr.length()) return -1;
        int[] match = buildMatch(pattern);
        int s = 0, p = 0, n = 0;
        while (s < sStr.length()) {
            while (s < sStr.length() && p < pStr.length()) {
                if (string[s] == pattern[p]) {
                    s++;
                    p++;
                } else if (p > 0)
                    p = match[p - 1] + 1;
                else s++;
            }

            if (p == pStr.length()) {
                ++n;
                System.out.println("第" + n + "次匹配位置" + (s - pStr.length()) + "\n");
                p = 0;
            }
        }
        return 0;
    }

    private static int[] buildMatch(char[] pattern) {
        int[] match = new int[pattern.length];
        int i;
        match[0] = -1;
        for (int j = 1; j < pattern.length; j++) {
            i = match[j - 1];

            if (i >= 0 && pattern[i + 1] != pattern[j])
                i = match[i];

            if (pattern[i + 1] == pattern[j])
                match[j] = i + 1;

            else match[j] = -1;
        }

        return match;
    }
}


