package Nums.Remove;

// 删除删除有序数组中的重复项, 使得数组中每个元素只出现一次, 原地修改且保持原序, 返回新的长度
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                // 维护 nums[0...slow] 无重复, 找到一个新的元素, 复制到下一个位置(slow+1)
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
