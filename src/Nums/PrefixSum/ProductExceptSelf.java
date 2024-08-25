package Nums.PrefixSum;

// 除自身以外数组的乘积
public class ProductExceptSelf {

    // 典型前缀积, 注意这里定义时前缀积包括自身, 即 prefix[0] = nums[0], prefix[i] 乘到了 i 而不是 i-1, 同时注意越界问题
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n -2; i >=0; i--) {
            suffix[i] = suffix[i+1] * nums[i];
        }
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }

    // 空间复杂度优化
    // 这里数组越界问题严重, 可以修改前缀积定义, prefix[0] = 1, prefix[i] 乘到 i-1
    public int[] productExceptSelfPro(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i];
        }
        int suffix = nums[n - 1];
        res[n - 1] = res[n - 2];
        for (int i = n -2; i > 0; i--) {
            res[i] = res[i - 1] * suffix;
            suffix *= nums[i];
        }
        res[0] = suffix;
        return res;
    }

    // 修改前缀积定义
    public int[] productExceptSelfProMax(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            // 注意这里 suffix 是后置更新, 所以是 nums[i] 而不是 nums[i+1]
            suffix *= nums[i];
        }
        return res;
    }
}
