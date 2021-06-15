package cn.garjun.tencent;

import java.util.List;

/**
 * @author :liangjiajun
 * @date :20210304
 * @description 目标和
 * @email :jaron.liang@jodoinc.com
 */
public class FindTargetSumWays {
  private int max = 0;

  public int findTargetSumWays(int[] nums, int S) {
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];
    dp[0][1] = -nums[0];

    return max;
  }

  public void backTrace(int[] nums, int S, List<Integer> list, int current) {
    if (list.size() == nums.length) {
      int result = 0;
      for (Integer each : list) {
        result += each;
      }
      if (result == S) {
        max++;
      }
      return;
    }
    list.add(nums[current]);
    backTrace(nums, S, list, current + 1);
    list.remove(list.size() - 1);
    list.add(nums[current] * -1);
    backTrace(nums, S, list, current + 1);
    list.remove(list.size() - 1);
  }

  public static void main(String[] args) {
    int[] i =
        new int[] {6, 44, 30, 25, 8, 26, 34, 22, 10, 18, 34, 8, 0, 32, 13, 48, 29, 41, 16, 30};
    FindTargetSumWays f = new FindTargetSumWays();
    int result = f.findTargetSumWays(i, 12);
    System.out.println(result);
  }

  // 6692
}
