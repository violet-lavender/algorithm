package Dp;

// 接雨水. 给定 n 个非负整数表示每个宽度为1的柱子的高度图, 计算按此排列的柱子, 下雨之后能接多少雨水.
// 对于位置 i, 其能达到的水柱高度与其左边的最高柱子 l_max、右边的最高柱子 r_max 有关, 位置i最大的水柱高度为 min(l_max, r_max)
// 能装的水为 water[i] = min(max(height[0...i]), max(height[i...end])) - height
// 注意这里左右两边都包含了 i 本身, 事实上算不算 i 都可以, 只是在备忘录初始化和计算上逻辑有所不同
public class Trap {
    // 设置备忘录, Dp思想
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        // 备忘录, 位置 i 左右两边(左右两边都包括位置 i 本身)最高的柱子高度
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 注意位置 0 和位置 n-1 无法接雨水, 都不参与结果计算, 即便参与计算也是 0, 逻辑是正确的
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];
        return res;
    }

    // 双指针, 优化空间复杂度
    public int trapPro(int[] height) {
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;
        int res = 0;
        while (left < right) {
            // l_max, r_max 代表 height[0...left] 和 height[right...end] 的最高柱子高度
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            // 位置 i 最大的水柱高度为 min(l_max, r_max), 只与较低的有关
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
