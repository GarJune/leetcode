package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201130
 * @description 整数反转
 * @email :jaron.liang@jodoinc.com
 */
public class Reverse {
  private static final int MIN = Integer.MIN_VALUE;
  private static final int MAX = Integer.MAX_VALUE;
  private static final String MAX_STR = String.valueOf(Integer.MAX_VALUE);
  private static final String MIN_STR = String.valueOf(Integer.MIN_VALUE);

  public static int reverse(int x) {
    if (x == 0) {
      return 0;
    }
    int reverse = 0;
    int temp = x;
    while (temp != 0) {
      if (MAX / 10 < reverse) {
        return -1;
      } else if (MAX / 10 == reverse) {
        if (temp % 10 > MAX % 10) {
          return -1;
        }
      }
      if (MIN / 10 > reverse) {
        return -1;
      } else if (MIN / 10 == reverse) {
        if (temp % 10 < MIN % 10) {
          return -1;
        }
      }
      reverse = temp % 10 + reverse * 10;
      temp = temp / 10;
    }
    return reverse;
  }

  public static void main(String[] args) {
    int result = reverse(123);
    System.out.println(result);
  }
}
