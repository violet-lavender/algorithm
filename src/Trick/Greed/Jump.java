package Trick.Greed;

// 跳跃游戏. 数组中的每个元素代表在该位置可以跳跃的最大长度, 判断是否能够到达最后一个下标
public class Jump {

    // 对于每一个可到达的位置 x, x + 1, x + 2, ... x + nums[x]都可达, 维护最远可到达的位置即可
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightBound = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightBound) {
                rightBound = Math.max(rightBound, i + nums[i]);
                if (rightBound >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}