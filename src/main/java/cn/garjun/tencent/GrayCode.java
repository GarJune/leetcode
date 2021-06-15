package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20210212
 * @description 格雷编码
 * @email :jaron.liang@jodoinc.com
 */
public class GrayCode {
  public static List<Integer> grayCode(int n) {
    List<Integer> list = new ArrayList<>();
    if (n == 0) {
      list.add(0);
      return list;
    }
    list = grayCode(n - 1);
    int size = list.size();
    int add = 1 << n - 1;
    for (int i = size - 1; i >= 0; i--) {
      int result = list.get(i) + add;
      list.add(result);
    }
    return list;
  }

  public static void main(String[] args) {
    List<Integer> list = grayCode(3);
    System.out.println(list);
  }
}
