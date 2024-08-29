package Nums.Diff;

// 区间加法. 差分数组
// diff[i] = nums[i] - nums[i - 1], 注意差分数组下标与前缀和数组有所不同
//  diff[i] = diff[i] + val; 即 i 之后元素全部加 val
public class Difference{
    private int[] diff;
    public Difference(int[] nums){
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1; i < diff.length; i++){
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    // 给区间 [i, j] 增加val(可以是负值)
    public void increment(int i, int j, int val){
        diff[i] += val;    //则 i 之后元素全部加 val
        if(j + 1 < diff.length)
            diff[j + 1] -= val;    //则 j + 1 之后元素全部减 val
    }
}
