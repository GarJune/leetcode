package cn.garjun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangjiajun
 * @date 20200309
 * @description 买卖股票的最佳时机
 */
public class BestTimeSellStocks {
  public int maxProfit(int[] prices) {
    int max = 0;
    String str = new String();
    StringBuilder stringBuilder = new StringBuilder(str);
    stringBuilder.reverse();
    List list = new ArrayList<>();
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[i] < prices[j]) {
          int profit = prices[j] - prices[i];
          if (profit > max) {
            max = profit;
          }
        }
      }
    }
    return max;
  }
}
