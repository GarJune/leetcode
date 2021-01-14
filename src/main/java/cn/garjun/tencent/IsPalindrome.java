package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201006
 * @description 判断一个数字是否回文数
 * @email :jaron.liang@jodoinc.com
 */
public class IsPalindrome {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x < 10) {
      return true;
    }
    int length = 0;
    int temp = x;
    while (temp > 0) {
      length++;
      temp = temp / 10;
    }
    for (int i = 1; i <= length / 2; i++) {
      int first = getBitNumber(x, i);
      int second = getBitNumber(x, length - i + 1);
      if (first != second) {
        return false;
      }
    }
    return true;
  }

  private int getBitNumber(int number, int bit) {
    int temp = 1;
    for (int i = 0; i < bit - 1; i++) {
      temp = temp * 10;
    }
    return number / temp % 10;
  }

  public static void main(String[] args) {
    IsPalindrome isPalindrome = new IsPalindrome();
    boolean result = isPalindrome.isPalindrome(1322231);
    System.out.println(result);
  }
}
