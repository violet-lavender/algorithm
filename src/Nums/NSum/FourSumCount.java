package Nums.NSum;

import java.util.HashMap;

// 四数相加
public class FourSumCount {

    // 索引问题, 没有去重逻辑, 哈希存储前两个数之和和出现次数,
    // 注意是解空间是索引元组而不是数值元组, 按照索引枚举是不会有重复的, 即没有去重逻辑, 一定要统计次数, 全部计数
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int res = 0;
        HashMap<Integer, Integer> count1_2 = new HashMap<>();
        for(int x: nums1)
            for(int y: nums2)
                count1_2.put(x + y, count1_2.getOrDefault(x + y, 0) + 1);
        for(int x: nums3)
            for(int y: nums4)
                if(count1_2.containsKey(- x- y))
                    res += count1_2.get(x + y);
        return res;
    }
}
