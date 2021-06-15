package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210219
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class MaxProfit {

  public int maxProfit(int[] prices) {
    int max = 0;
    int dp[][] = new int[prices.length][2];
    dp[0][1] = -prices[0];
    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public static void main(String[] args) {
    int[] i = new int[] {1, 4, 2, 7};
    MaxProfit maxProfit = new MaxProfit();
    int result = maxProfit.maxProfit(i);
    System.out.println(result);
  }
}
