package Nums.TwoPointer;

// 盛水最多的容器
public class MaxArea {
    // 在每次求解中, 两个while循环只会执行其中一个, 而不是同时执行. 只有较低的一边会执行, 确保了算法的正确性
    public int maxArea_Mine(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int hei = Math.min(height[right], height[left]);
            int area = (right- left) * hei;
            res = Math.max(res, area);
            while (left < right && height[left] <= hei)
                left++;
            while (left < right && height[right] <= hei)
                right--;
        }
        return res;
    }

/*  矩形的高度是由 min(height[left], height[right]) 即较低的一边决定的,
    如果移动较低的那一边, 那条边可能会变高, 使得矩形的高度变大, 进而就「有可能」使得矩形的面积变大;
    相反, 如果去移动较高的那一边, 矩形的高度是无论如何都不会变大的, 所以不可能使矩形的面积变得更大。 */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int area = (right- left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            // 双指针技巧, 总是移动较低的那一边
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}
