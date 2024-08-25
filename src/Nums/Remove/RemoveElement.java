package Nums.Remove;

// 移除元素, 原地修改, 不要求保持原序, 返回不等的元素个数
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                // fast 遇到 val 就跳过,否则就赋值为 slow —— 直接覆盖赋值即可, 不用交换
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow ;
    }
}
