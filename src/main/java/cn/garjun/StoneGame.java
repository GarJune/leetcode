package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210331
 * @description 石子游戏
 * @email :jaron.liang@jodoinc.com
 */
public class StoneGame {
  class Result {
    int first = 0;
    int second = 0;

    Result(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public boolean stoneGame(int[] piles) {
    Result[][] dp = new Result[piles.length][piles.length];
    for (int i = 0; i < piles.length; i++) {
      dp[i][i] = new Result(piles[i], 0);
    }
    for (int l = 1; l < piles.length; l++) {
      for (int i = 0; i < piles.length - l; i++) {
        int j = l + i;
        int result1 = piles[i] + dp[i + 1][j].second;
        int result2 = piles[j] + dp[i][j - 1].second;
        if (dp[i][j] == null) {
          dp[i][j] = new Result(0, 0);
        }
        if (result1 > result2) {
          dp[i][j].first = result1;
          dp[i][j].second = dp[i + 1][j].first;
        } else {
          dp[i][j].first = result2;
          dp[i][j].second = dp[i][j - 1].first;
        }
      }
    }
    return dp[0][piles.length - 1].first - dp[0][piles.length - 1].second > 0;
  }

  public static void main(String[] args) {
    int[] i = new int[] {3, 2, 10, 4};
    StoneGame s = new StoneGame();
    boolean result = s.stoneGame(i);
    System.out.println(result);
  }
}
