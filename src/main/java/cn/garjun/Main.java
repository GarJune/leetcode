package cn.garjun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20210418
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class Main {
  public int[][] sql(int[][] t, int a, int b, int c) {
    HashMap<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < t.length; i++) {
      int[] tmpArr = map.getOrDefault(t[i][c], new int[] {0, 0});
      tmpArr[0] = tmpArr[0] + 1;
      tmpArr[1] = tmpArr[1] + t[i][b];
      System.out.println(map.size());
    }
    int row = map.size();
    int[][] result = new int[row][3];
    int i = 0;
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
      result[i][0] = entry.getKey();
      result[i][1] = entry.getValue()[0];
      result[i][2] = entry.getValue()[1];
      i++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] t = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 3}};
    Main main = new Main();
    int[][] result = main.sql(t, 0, 1, 2);
    for (int[] a : result) {
      for (int b : a) {
        System.out.print(b);
      }
      System.out.println("--");
    }
    System.out.println();
  }
}
