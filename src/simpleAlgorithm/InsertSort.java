package simpleAlgorithm;

import java.util.Arrays;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/12 23:20
 *   算法思维：将`i`元素插入到下标为`0`~`i-1`的位置上，
 *   逐个比较，如果发现前面的元素比arr[i]大
 *   则将该元素后移 否则将i元素放入到空位置上
 */
public class InsertSort {
    public static void main(String[] args) throws InterruptedException {

        int[] arr = {-1111, 20, -3, -10, 100, -255};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 插入排序
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 需要将i插入到前面子序列
            if (arr[i] < arr[i - 1]) {
                int k = arr[i], j;
                // i为要插入的元素,j为i往前的元素
                // 如果arr[j]比k大 则把arr[j]元素往后挪
                // 如果arr[j]比k小则直接插入元素在空位上
                for (j = i - 1; j >= 0 && arr[j] > k; j--)
                    arr[j + 1] = arr[j];
                // 将元素放到比k小的后面
                arr[j + 1] = k;
            }
        }
    }
}
