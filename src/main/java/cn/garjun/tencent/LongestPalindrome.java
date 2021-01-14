package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201005
 * @description 最长回文子串
 * @email :jaron.liang@jodoinc.com
 */
public class LongestPalindrome {
  public String longestPalindrome(String s) {
    int start = 0;
    int end = 0;
    int maxLength = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      int ood = expand(s, i, i);
      int even = expand(s, i, i + 1);
      int length = Math.max(ood, even);
      if (length > maxLength) {
        maxLength = length;
        start = i - (length - 1) / 2;
        end = start + length - 1;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expand(String s, int i, int j) {
    while (s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
      if (j == s.length() || i < 0) {
        break;
      }
    }
    return j - i - 1;
  }

  public static void main(String[] args) {

    String s = "a";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String str = longestPalindrome.longestPalindrome(s);
    System.out.println(str);
  }
}
