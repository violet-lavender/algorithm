package Nums.TwoPointer;

// 移动零
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        // slow实际上最后多进行了一次++, 0~slow-1是所有非0元素, 且保持了相对顺序
        for (; i < nums.length; i++)
            nums[i] = 0;
    }
}
