package leetcode.simple;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/8 20:23
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">https://leetcode-cn.com/problems/median-of-two-sorted-arrays/</a>
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1};
        int[] a2 = {1, 2, 2, 3};
        double res = findMedianSortedArrays(a1, a2);
        System.out.println("res = " + res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        // NOTE: 这里的m 如果你当指针写成m-1 当短的数组长度为1时 right = m-1 = 0;
        int right = m;


        while (left < right) {
            // NOTE: right - left + 1 此处+1是为避免一种情况
            // 当left =1，right =2 时 left + (right - left) / 2=1;
            // 设if条件走了else分支 left又被赋值为1了 然后就没玩没了次循环了
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        // NOTE: i 表示 分界线有右边的第一个元素 当i为0时说明数组左边越界处理为一个极小的值
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        // NOTE: 角标为m、n时数组已经右边越界 此时处理为一个很大的值
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }


}
