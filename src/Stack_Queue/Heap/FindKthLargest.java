package Stack_Queue.Heap;

// 数组中第 k 个最大元素, 大根堆, 做 k - 1 次删除操作
// 二叉堆的插入和删除时间复杂度为 logn, 自顶向下堆化为 nlogn, 自底向上堆化为 n, 堆排序为 nlogn
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        buildMaxHeap(nums, size);
        for (int i = 0; i < k - 1; i++) {
            extractMax(nums, size--);
        }
        return nums[0];
    }

    // 自底向上的堆化
    private void buildMaxHeap(int[] nums, int size) {
        // 从最后一个非叶子节点开始下沉
        for (int i = size / 2 - 1; i >= 0; i--) {
            sink(nums, size, i);
        }
    }

    // 下沉操作
    private void sink(int[] nums, int size, int cur) {
        int largest = cur;
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        // 找到左右子节点中最大的节点
        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果当前节点不是最大节点, 则交换并继续下沉
        if (largest != cur) {
            swap(nums, cur, largest);
            sink(nums, size, largest);
        }
    }

    // 删除堆顶元素
    public void extractMax(int[] nums, int size) {
        // 将堆顶元素与最后一个元素交换, 并移除最后一个元素
        int root = nums[0];
        nums[0] = nums[size - 1];
        // 下沉操作, 以维护大根堆的性质
        sink(nums, size, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
