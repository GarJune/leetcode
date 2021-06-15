package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210319
 * @description 最长回文子序列
 * @email :jaron.liang@jodoinc.com
 */
public class LongestPalindromeSubseq {
  //    "bbbab"
  //     4
  public int longestPalindromeSubseq(String s) {
    char[] chars = s.toCharArray();
    int[][] dp = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
      for (int j = i + 1; j < s.length(); j++) {
        if (chars[i] == chars[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    System.out.println(dp[0][s.length() - 1]);
    return dp[0][s.length() - 1];
  }

  public static void main(String[] args) {
    LongestPalindromeSubseq subseq = new LongestPalindromeSubseq();
    subseq.longestPalindromeSubseq("bbbab");
  }
}
