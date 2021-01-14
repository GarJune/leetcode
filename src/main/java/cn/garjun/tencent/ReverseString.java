package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201109
 * @description 反转字符串
 * @email :jaron.liang@jodoinc.com
 */
public class ReverseString {
  public static void reverseString(char[] s) {
    if (s.length == 0 || s.length == 1) {
      return;
    }
    char temp;
    for (int i = 0, j = s.length - 1; i < j; i++, j--) {
      temp = s[i];
      s[i] = s[j];
      s[j] = temp;
    }
  }

  public static void main(String[] args) {
    char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
    reverseString(s);
    System.out.println(s);
  }
}
