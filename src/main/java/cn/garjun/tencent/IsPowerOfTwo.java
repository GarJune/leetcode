package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201225
 * @description 2的幂
 * @email :jaron.liang@jodoinc.com
 */
public class IsPowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    return (n + n - 1) == ((n - 1) | n);
  }

  public static void main(String[] args) {
    IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
    System.out.println(isPowerOfTwo.isPowerOfTwo(0));
  }
}
