package Stack_Queue.Heap;

/* 二叉堆特点:
1. 完全二叉树: 二叉堆的每一层都是完全填满的, 除了最后一层, 节点从左到右依次填充;
2. 堆序性:
    最大堆: 对于最大堆, 任何一个父节点的值都大于或等于其子节点的值.
    最小堆: 对于最小堆, 任何一个父节点的值都小于或等于其子节点的值. */
/* 堆操作:
插入:
    将新元素插入到堆的末尾(保持完全二叉树的性质);
    逐级上移该元素("上浮"操作), 直至其父节点满足堆序性.
删除(堆顶):
    先将堆顶元素与堆的最后一个元素交换, 然后删除最后一个元素;
    对新堆顶元素进行逐级下移("下沉"操作), 以恢复堆序性.
堆化:
    通过将一个无序数组转换为一个合法的堆. 常用的堆化方法是自底向上逐步调整各个非叶子节点.
堆排序:
    利用二叉堆可以轻松实现排序. 首先将数组堆化成最大堆, 然后反复交换堆顶元素与末尾元素, 并对剩余元素重新堆化, 最终得到一个升序排列的数组(对最小堆进行同样操作可得到降序排列). */
// 大根堆实现. 堆是完全二叉树, 可以通过数组模拟
// 二叉堆的插入和删除时间复杂度为 logn, 自顶向下堆化为 nlogn, 自底向上堆化为 n, 堆排序为 nlogn
public class MaxHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // 返回父节点的索引
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // 返回左子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回右子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 插入新元素
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // 将新元素插入到堆的最后一个位置
        heap[size] = value;
        size++;

        // 上浮操作, 以维护大根堆的性质
        int current = size - 1;
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // 删除堆顶元素
    public int extractMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // 将堆顶元素与最后一个元素交换, 并移除最后一个元素
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // 下沉操作, 以维护大根堆的性质
        sink(0);

        return root;
    }

    // 下沉操作
    private void sink(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // 找到左右子节点中最大的节点
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // 如果最大的节点不是当前节点, 则交换并继续下沉
        if (largest != index) {
            swap(index, largest);
            sink(largest);
        }
    }

    // 交换两个索引的值
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 堆化一个无序数组
    public void buildHeap(int[] arr) {
        if (arr.length > capacity) {
            throw new IllegalArgumentException("Array size exceeds heap capacity");
        }

        size = arr.length;
        heap = arr;

        // 从最后一个非叶子节点开始下沉
        for (int i = size / 2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    // 打印堆中的元素
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // 获取堆顶元素
    public int getMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // 返回堆的大小
    public int getSize() {
        return size;
    }
}
