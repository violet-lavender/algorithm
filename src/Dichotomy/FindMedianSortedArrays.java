package Dichotomy;

// 寻找两个正序(升序)数组的中位数. 即寻找两个有序数组中的第 k 小的数, 其中 k 为 (m + n) / 2 或 (m + n) / 2 + 1.
// 归并两个有序数组, 或者维护两个指针找中位数都可以, 但是时间复杂度都是 O(m + n), 要log的复杂度, 只能用二分

/* 二分逻辑:
要找到第 k 个元素, 可以比较 A[k / 2 - 1] 和 B[k / 2 - 1]
1. 若 A[k / 2 - 1] < B[k / 2 - 1], 则比 A[k / 2 - 1] 小的数最多只有 A 的前 k / 2 - 1 个数 和 B 的前 k / 2 - 1 个数, 即最多只有 k - 2 个,
   因此 A[k / 2 − 1] 不可能是第 k 个数, A[0] 到 A[k / 2 − 1] 也都不可能是第 k 个数, 可以全部排除;
2. 若 A[k / 2 - 1] < B[k / 2 - 1], 则同理可以排除 B[0] 到 B[k / 2 − 1];
3. 若 A[k / 2 − 1] = B[k / 2 − 1], 则可以归入第一种情况处理. */
/* 边界处理:
1. 如果 A[k / 2 − 1] 或 B[k / 2 − 1] 越界, 可以选取对应数组中的最后一个元素. 此时必须根据排除数的个数减少 k 的值, 而不能直接将 k 减去 k / 2;
2. 如果一个数组为空, 说明该数组中的所有元素都被排除, 可以直接返回另一个数组中第 k 小的元素;
3. 如果 k = 1, 只要返回两个数组首元素的最小值即可. */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = m + n;
        if (l % 2 == 1) {
            int k = l / 2 + 1;
            return getKthElement(nums1, nums2, k);
        } else {
            int k1 = l / 2, k2 = l / 2 + 1;
            return (getKthElement(nums1, nums2, k1) + getKthElement(nums1, nums2, k2)) / 2.0;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况. 注意这是个死循环, 不断二分的情况下一定会来到边界并返回结果.
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况
            int half = k / 2;
            // 这里也处理了边界情况, 即越界逻辑
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                // 直接根据排除数的个数减少 k 的值, 统一处理
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
