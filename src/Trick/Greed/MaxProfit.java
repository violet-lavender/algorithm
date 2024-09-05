package Trick.Greed;

// 买股票的最佳时机
public class MaxProfit {

    // 暴力超时
    public int maxProfitFalse(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    // 遍历过程中, 记录当前历史最低点, 每天考虑: 如果是在历史最低点买进的, 那么今天卖出能赚多少钱. (贪心)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}