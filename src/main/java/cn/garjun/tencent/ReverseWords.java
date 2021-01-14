package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201109
 * @description 反转字符串中的单词 III
 * @email :jaron.liang@jodoinc.com
 */
public class ReverseWords {
  public static String reverseWords(String s) {
    String[] strings = s.split(" ");
    //    String[] newStr = new String[strings.length];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = reverse(strings[i]);
    }
    return String.join(" ", strings);
  }

  public static String reverse(String str) {
    char[] s = str.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = s.length - 1; i >= 0; i--) {
      stringBuilder.append(s[i]);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    String str = reverseWords("Let's take LeetCode contest");
    System.out.println(str);
  }
}
