package cn.garjun.tencent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20210218
 * @description 爬楼梯
 * @email :jaron.liang@jodoinc.com
 */
public class ClimbStairs {
  public static Map<Integer, Integer> map = new HashMap<>();

  public static int climbStairs(int n) {
    int p = 0, q = 0, r = 1;
    for (int i = 0; i < n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }

  public static void main(String[] args) {
    int result = climbStairs(3);
    System.out.println(result);
  }
}
