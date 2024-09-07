package Trick.Pointer;

// 下一个排列. 其整数的下一个字典序更大的排列. 要求原地修改数组, 常数空间.
/* 将后面的大数与前面的小数交换, 交换时要在尽可能靠右的低位进行(从后向前), 即小数尽量靠右, 同时大数要尽可能小, 交换后将大数后的数字重置为升序.
1. 从后向前查找第一个相邻升序的元素对(i, j)(即 j = i + 1), 满足 nums[i] < nums[j], 此时 [j, end) 一定是降序;
2. 在 [j, end) 从后向前查找第一个满足 nums[i] < nums[k] 的 k(降序序列, 从后向前查找, 第一个大数即为最小的大数), 则 nums[i]、nums[k] 分别为小数、大数;
3. 交换 nums[i] 与 nums[k];
4. 此时 [j, end) 一定是降序, 逆置 [j, end) 使其升序;
5. 如果在 1 中找不到相邻升序的元素对, 则说明数组已经是降序的, 则直接逆置数组即可. */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >=0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, n - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
