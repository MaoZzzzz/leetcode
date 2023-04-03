
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4236 👎 0

package Temp.leetcode.editor.cn;

import java.util.Stack;

//java:接雨水
class P42TrappingRainWater {
    public static void main(String[] args) {
        SolutionDoublePoint solution = new P42TrappingRainWater().new SolutionDoublePoint();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 方法一：计算每个列的可以存储的量
    // 动态规划
    class SolutionDP {
        public int trap(int[] height) {
            int res = 0;
            int length = height.length;
            int[] maxLeft = new int[length];
            int[] maxRight = new int[length];

            maxLeft[0] = height[0];
            maxRight[length - 1] = height[length - 1];
            for (int i = 1; i < length; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            }

            for (int i = length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i]);
            }

            for (int i = 1; i < length; i++) {
                int tmp = Math.min(maxLeft[i], maxRight[i]);
                res += tmp - height[i];
            }
            return res;
        }
    }

    // 方法二：动态规划 + 双指针
    // 由动态规划演变而来
    class SolutionDoublePoint {
        public int trap(int[] height) {
            int res = 0;
            int length = height.length;
            int left = 0, right = length - 1;
            // 用两个变量代替最大值数组
            int maxLeft = 0, maxRight = 0;

            // 只能从最左或者最右边的两根柱子开始
            // 确定一个柱子接的水是需要知道左右两边的最高柱子才可以，所以应该是两个变量（方法一的maxLeft和maxRight数组）
            // 使用双指针后，会从两根柱子一起开始算，但是两根柱子只有两个值是不够的，就需要这样一个定理
            // 由于右边的柱子 j 在 i 的左边，所以：iLeftMax<jLeftMax, iRightMax>jRightMax
            while (left < right) {
                // 所以这里的 maxLeft 其实是 iLeftMax，maxRight 其实是 jRightMax
                maxLeft = Math.max(maxLeft, height[left]);
                maxRight = Math.max(maxRight, height[right]);
                // 当有 iLeftMax>jRightMax，就有 jRightMax>iLeftMax>jRightMax，又因为 jRightMax 是知道的，所以可以求 j
                if (maxLeft > maxRight) {
                    res += maxRight - height[right];
                    right--;
                } else {
                    res += maxLeft - height[left];
                    left++;
                }
            }

            return res;
        }
    }

    // 方法三：单项栈
    // TODO
//leetcode submit region end(Prohibit modification and deletion)


}