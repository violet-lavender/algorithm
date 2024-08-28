package Dichotomy;

// 旋转排序数组. 注意旋转排序数组的两个性质:
// 1. 一个升序数组变成了两个升序数组(左侧升序数组总是比右侧大)拼接在一起.
// 2. 在旋转排序数组中, 任意一个点都可以把数组分为两个部分, 其中一定有一个有序.
public class RotateSortedArray {

    // 搜索旋转排序数组.
    // 在旋转排序数组中, 任意一个点都可以把数组分为两个部分, 其中一定有一个有序.
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            // [left, mid] 有序, 或者 [mid + 1, right] 有序
            if (nums[left] <= nums[mid]) {  // 左侧有序
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {    // 右侧有序
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 寻找旋转排序数组中的最小值.
    // 左侧升序数组总是比右侧大, 找右侧数组的 left 即可.
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            res = Math.min(res, nums[left]);
            int mid = (right - left) / 2 + left;
            // 注意 mid 一直被跳过, 所以也需要比较
            res = Math.min(res, nums[mid]);
            if (nums[left] <= nums[mid]) {  // 左侧有序
                left = mid + 1;
            } else {    // 右侧有序
                right = mid - 1;
            }
        }
        return res;
    }
}
