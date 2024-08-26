package DFS_Backtrack.Backtrack;

import java.util.ArrayList;
import java.util.List;

// 全排列的小优化
/* 标记数组增加了算法的空间复杂度,可以 swap 交换函数来代替 used 标记数组, 多一个 start 参数维持下标和控制边界
将题目给定的数组 nums 划分成左右两个部分, 左边的表示已经填过的数, 右边表示待填的数, 在回溯的时候只要动态维护这个数组即可
假设我们已经填到第 start 这个位置, 则数组中 [0, start − 1] 为已填过的数的集合, [start, n − 1] 是待填的数的集合
用 [start, n − 1] 里的数去填第 start 个数. 假设待填的数的下标为 i, 那么填完以后我们将第 i 个数和第 start 个数交换,
即能使得在填第 start + 1 个数的时候 nums 数组的 [0, start] 部分为已填过的数, [start + 1, n − 1] 为待填的数,回溯的时候交换回来即能完成撤销操作.
这里, 原数组 nums 不断修改变化, 它存储的即是全排列本身, 只需要在长度到达时添加即可, 同样还省去了 track 记录路径的空间.
但是这样生成的全排列并不是按字典序存储在答案数组中的, 如果要求按字典序输出, 还是用标记数组或者其他方法. */
public class PermutePro {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums){
        backtrack(nums, 0);
        return res;
    }
    public void backtrack(int[] nums, int start){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums)
                list.add(num);
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < nums.length; i++){
            swap(nums, start, i);
            backtrack(nums, start + 1);
            swap(nums, start ,i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
