package leetcode.simple;

/**
 * @Author: WhaleFall541
 * @Date: 2021/5/31 23:22
 */
public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour1(111111111));
    }


    public static boolean isPowerOfFour1(int n) {
        if (n == 1)
            return true;
         int a = 4;
        while (n > a && a > 0) {
            a = a * 4;
        }
        if (n == a)
            return true;
        else
            return false;
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
