package Nums.Remove;

// 移动零, 与 RemoveElement 很像, 先移除 0, 再把后面赋 0
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
