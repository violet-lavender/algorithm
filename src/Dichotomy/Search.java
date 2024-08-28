package Dichotomy;

// 二分查找
// 看到排序数组, log n 复杂度一般要考虑二分
// while 结束条件为 left = right + 1, 此时 nums[right] 是小于等于 target 的最大值, 而 nums[left] 是大于等于 target 的最小值
public class Search {

    // 查找
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //找到则返回索引值
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        // 找不到则返回应该被顺序插入的位置
        return left;
    }
}
