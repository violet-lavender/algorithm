package Dichotomy;

// 在排序数组中查找元素的第一个和最后一个位置, 寻找左右边界的二分查找
// 注意这里在返回时都判断了是否等于 target ,当 target 不存在时——
// 左侧边界的返回索引是大于 target 的最小索引, 右侧边界的返回索引是小于 target 的最大索引
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    private int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 双闭区间 [left, right], 区间为空时循环结束
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收紧右侧边界以锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断是否越界
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target? left : -1;
    }

    private int right_bound(int[] nums, int target){
        // 同样双闭区间
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                // 收紧左侧边界以锁定右侧边界
                left = mid + 1;
            }
        }
        // 收缩左边界时 left + 1 (相当于多加了一次),最后返回 left - 1
        // while 的结束条件是 right == left - 1, 可以用 right 替换 left - 1, 即左边界 left, 右边界 right, 更统一
        if(right < 0)
            return -1;
        return nums[right] == target? right : -1;
    }
}
