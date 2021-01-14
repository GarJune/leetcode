package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201008
 * @description 最长公共前缀
 * @email :jaron.liang@jodoinc.com
 */
public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int length = 0;
    for (int i = 0; i < strs[0].length(); i++) {
      boolean next = true;
      for (int j = 1; j < strs.length; j++) {
        if (i >= strs[j].length()) {
          next = false;
          break;
        }
        if (strs[0].charAt(i) != strs[j].charAt(i)) {
          next = false;
          break;
        }
      }
      if (next) {
        length++;
      } else {
        break;
      }
    }

    if (length == 0) {
      return "";
    }
    return strs[0].substring(0, length);
  }

  public static void main(String[] args) {
    String[] str = new String[] {"aac", "aab", "aaaaa"};
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String prefix = longestCommonPrefix.longestCommonPrefix(str);
    System.out.println(prefix);
  }
}
