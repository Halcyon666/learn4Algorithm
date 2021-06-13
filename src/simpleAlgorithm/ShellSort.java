package simpleAlgorithm;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/12 22:59
 * 视频: https://www.bilibili.com/video/BV1BK4y1478X?from=search&seid=18253194365918849629
 * 算法思维:
 * 说明 arr.length = n; 增量序列为 seq; 间隔  span = seq[p];
 * 1. 第一层for循环 选取增量序列为 `2^x-1` 的增量序列`增量序列的长度即为需要排序的趟数
 * 2. 第二层for循环 `arr[i]`从`arr[span]`开始到`arr[n-1]`表示间隔为`span`时需要比较的次数
 * 3. 第三层for循环 `arr[j]`和 `arr[j - span]` 比较大小 `if (arr[j] < arr[j - span]) arr[j] = arr[j-span];`
 * 则将`arr[j-span]`后移，然后将当前排序的元素`arr[i]`放到`j-span`位置
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = new int[] {3,1,-2,6,2,-10,90};

        shellSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i])
                throw new RuntimeException("第" + i + "未排好顺序");
        }
    }

    static void shellSort(int[] arr) {
        int n = arr.length;
        // 从生成的增量序列中按间隔进行排序 2^x - 1
        int seq[] = generateSequence(n);

        for (int p = 0; p < seq.length; p++) {
            int span = seq[p];
            for (int i = span; i < n; i++) {
                // 此处可以看作是从arr[n/2]处开始，跟间隔前的比较大小
                // 如果arr[n/2]小于前面的arr[n/2-span] 则移动前面的元素到arr[n/2]上
                int k = arr[i], j;// 需要插入排序的元素
                // j >= span 和 j -= span 决定了 for循环体arr[j-span]后移至多执行一次
                for (j = i; j >= span && k < arr[j - span]; j -= span)
                    arr[j] = arr[j - span];
                arr[j] = k;
            }
        }
    }

    private static int[] generateSequence(int n) {
        int len = (int) (Math.log(n) / Math.log(2));// log2n
        int[] seq = new int[len];
        for (int i = 0; i < len; i++) {
            seq[i] = (int) (Math.pow(2, len - i) - 1);// 2^x-1
        }
        return seq;
    }
}
