package simpleAlgorithm;

import java.util.Arrays;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/12 22:59
 *
 * [视频](https://www.bilibili.com/video/BV184411L79P?t=650)
 * 算法思维:
 * 基数排序的趟数就是最大数的长度
 *
 * 通过10个桶来收集数值，先对个位的数值对应到count数组进行计数，然后将计数数组累加
 *
 * 通过累加后的数组可以确定哪几个元素在哪个位置
 * 如下：`count[5] = 7`,前面有6个元素，并且 5,6号下标均为个位含有5的数
 *
 * `NOTE`: 计数累加数组 和 倒序回填元素保证了算法的稳定性
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{444444224, 240, 115, 532, 305, 430, 124};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void radixSort(int[] arr) {

        int n = arr.length;
        if (n == 0) return;

        // 1. 求出最大数
        int max = arr[0];
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];

        // 计算出最大数的位数
        int bit = String.valueOf(max).length();
        for (int i = 0; i < bit; i++) {
            int base = (int) Math.pow(10, i);

            int[] count = new int[10];
            int[] result = new int[arr.length];

            // 根据位数0-9分别对count数组中对应位置累加
            for (int j = 0; j < n; j++) {
                // 位数上的值
                int number = arr[j] / base % 10;
                count[number]++;
            }

            // 累加计数
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j - 1] + count[j];
            }

            for (int j = n - 1; j >= 0; j--) {
                int number = arr[j] / base % 10;
                // 按照累加数组 放回元素到result中
                //  count [2, 3, 4, 4, 5, 7, 7, 7, 7, 7]
                //  result [240, 430, 421, 532, 124, 115, 305]
                // --count[number] 表示对应位置上的数组前面有多少个元素
                // 比如 count[5] = 7,前面有6个元素，并且 5,6号下标均为个位含有5的数
                result[--count[number]] = arr[j];
            }

            // 将结果集放回到原数组准备下一轮排序
            System.arraycopy(result, 0, arr, 0, n);
            //清空计数数组
            Arrays.fill(count, 0);
        }
    }

}
