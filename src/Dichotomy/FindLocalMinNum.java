package Dichotomy;

// 无序数组, 相邻数一定不相等, 求解局部最小值, 如果存在多个局部最小值, 返回一个即可
// 局部最小值: 若某个数组元素两边的数均大于它, 则它为局部最小值, 边界元素则只要求相应的一半
public class FindLocalMinNum {
    public int findLocalMinNum(int[] arr){
        int n = arr.length;
        if(n == 1)
            return 0;
        if(arr[0] < arr[1])
            return 0;
        if(arr[n - 1] < arr[n - 2])
            return n - 1;
        // 跳过边界元素, 防止数组越界
        int left = 1, right = n - 2;
        // 左闭右闭区间, 区间内没有元素时结束循环
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
                return mid;
            else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
