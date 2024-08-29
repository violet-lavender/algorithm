package Nums.Hash;

import java.util.*;

// O(1) 时间插入、删除和(等概率)获取随机元素. 数组 + 哈希
// 插入、删除、获取元素,常数时间考虑哈希, 但是哈希显然做不到等概率获取随机元素, 想要实现底层必须是数组, 且数组必须紧凑
// 但是用数组有无法使得插入和删除时间复杂度为 O(1), 考虑尾插, 在数组尾部进行插入和删除
// 插入时可以直接插入尾部, 而删除时需要交换到尾部删除, 需要用哈希记录索引, 同时哈希判断是否存在也是O(1)
public class RandomizedSet {

    // 动态数组(列表)存储元素的值
    List<Integer> nums;
    // 哈希表记录每个元素对应在nums中的索引
    Map<Integer, Integer> valToIndex;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val))
            return false;
        // 数组尾部索引 = 数组长度 - 1, 一定是先 put, 再 add
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val))
            return false;
        int index = valToIndex.get(val);
        // 哈希表中索引要与数组对应索引保持一致, 所以数组和哈希表都要交换当前 val 与尾部元素,
        // 哈希将尾部元素索引修改为 index 即可, 而数组则是 swap 交换
        valToIndex.put(nums.get(nums.size() - 1), index);
        Collections.swap(nums, index, nums.size() - 1);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}