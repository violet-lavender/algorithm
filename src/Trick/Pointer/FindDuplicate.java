package Trick.Pointer;

// 寻找重复数.
// 给定包含 n + 1 个整数的数组 nums, 其数字都在 [1, n] 范围内(包括 1 和 n), 可知至少存在一个重复的整数
// 假设 nums 只有一个重复的整数, 返回这个重复的数. 要求不修改 nums, O(1) 空间, O(n) 时间.
/* 环形链表, Floyd 判圈算法.
将数组下标 i 与 nums[i] 奖励映射关系 f(i) = nums[i],
从下标 0 开始, 根据 f(i) 计算出新的值, 作为新的下标, 不断重复, 直到下标越界, 这样就产生了一个链表,
数组中如果有重复的数, 就会产生多对一的映射, 这样形成的链表就一定会有环路, 而环的入口即为这个重复的数. */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        // Floyd 判圈算法. 快慢指针, 一个前进一步, 一个前进两步, 相遇后一个回到起点, 此时同步前进一步, 再次相遇即为环入口.
        int slow = 0, fast = 0;
        // 这里用 do-while 循环, 直接 while(slow != fast) 初始即为 false, 不会进入循环. 也可以用 while(true) 和 break.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
