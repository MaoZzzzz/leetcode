
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2388 👎 0

package Temp.leetcode.editor.cn;

import java.util.List;

//java:合并 K 个升序链表
class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = (left + right) >> 1;
            return MergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 != null ? list1 : list2;
            }
            ListNode dummyNode = new ListNode(0);
            ListNode cur = dummyNode, aTmp = list1, bTmp = list2;
            while (aTmp != null && bTmp != null) {
                if (aTmp.val <= bTmp.val) {
                    cur.next = aTmp;
                    aTmp = aTmp.next;
                } else {
                    cur.next = bTmp;
                    bTmp = bTmp.next;
                }
                cur = cur.next;
            }
            cur.next = aTmp != null ? aTmp : bTmp;
            return dummyNode.next;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
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
}