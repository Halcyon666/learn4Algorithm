package simpleAlgorithm;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/11 20:40
 * [github仓库地址](https://github.com/whalefall541/learn4Algorithm)
 * [视频链接](https://www.bilibili.com/video/BV1Ax411U7Xx?from=search&seid=2724712095992885035)
 * 算法思路：将两个局部有序的数组归并为一个有序的数组
 * 归并过程：i,j两个指针指向两个数组，分别比较该位置上值的大小
 * 小的先放入原数组；
 * 分治法：针对整体都无序的数组则需要分治法来处理，将数组不断一分为二
 * 进行归并排序，直到长度为1(指针重合的时候)排序完成
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 6, 8, 2, 3, 9, 1};
        mergeSort(arr, 0, arr.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        // 归并排序只有一个元素时结束递归
        if (l == r)
            return;
        // 规定mid为分界线右边的第一个元素
        int mid = (l + r) / 2+1;
        mergeSort(arr, l, mid-1);
        mergeSort(arr, mid, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int m = mid - l, n = r - mid + 1;

        // 规定mid为分界线右边的第一个元素
        int[] left = new int[m];
        int[] right = new int[n];

        for (int i = l; i < mid; i++)
            left[i - l] = arr[i];
        // NOTE: 注意这里的r表示右边界 i<=r 等号掉了就悲剧了
        // 错误输出为 0 0 0 0 0 0 0 10
        for (int i = mid; i <= r; i++)
            right[i - mid] = arr[i];

        //do merge
        int k = l, i = 0, j = 0;
        while (i < n && j < m) {
            if (left[i] > right[j])
                // 把小的数放回到数组中从k开始放
                arr[k++] = right[j++];
            else
                arr[k++] = left[i++];
        }

        // 如果一个数组为空了，放入另一个数组所有元素
        while (i < n)
            arr[k++] = left[i++];
        while (j < m)
            arr[k++] = right[j++];
    }
}
