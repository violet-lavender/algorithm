package Trick.Pointer;

// 颜色分类. 原地排序. 常数空间的一趟扫描算法.
public class SortColors {

    // 双指针, p0 交换 0, p2 交换 2, 在遍历中, 交换 0 到头部, 交换 2 到尾部
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        // p2 从左到右, 遍历位置超过 p2 即可停止遍历
        for (int i = 0; i <= p2; i++) {
            // 注意找到 2 时, 需要不断交换, 直到新的 nums[i] 不为2
            // 此时, 如果 nums[i] 为 0, 则对应着 == 0 情况(所以 == 0 的逻辑一定放在后边); 如果 nums[i] 为 1, 即不需要后续操作
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}