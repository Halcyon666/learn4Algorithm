package leetcode.simple;

/**
 * @Author: WhaleFall541
 * @Date: 2021/5/29 20:30
 * 第二题
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoSumLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    [9,9,9,9,9,9,9]
    [9,9,9,9]
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val);
            result = result.next;
        }
        System.out.println("sb = " + sb);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode head = result = new ListNode();
        int temp = 0, value1, value2;

        while (l1 != null || l2 != null) {
            value1 = (l1 == null) ? 0 : l1.val;
            value2 = (l2 == null) ? 0 : l2.val;

            // 当前指针位值的值相加
            result.val = value1 + value2 + temp;
            temp = result.val / 10;// 记录进位的值
            result.val = result.val % 10;// 记录当前位的值

            // l1 l2 只要不为空则后移指针
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            // l1 l2 只要其一不为空则结果集需要后延一位
            if (l1 != null || l2 != null)
                result = result.next = new ListNode();
        }

        // 处理最后一位进位的情况
        if (temp != 0)
            result.next = new ListNode(temp);
        return head;
    }
}
