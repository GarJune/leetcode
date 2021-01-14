package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20201110
 * @description 螺旋矩阵
 * @email :jaron.liang@jodoinc.com
 */
public class SpiralOrder {
  private static final String RIGHT = "RIGHT";
  private static final String LEFT = "LEFT";
  private static final String DOWN = "DOWN";
  private static final String UP = "UP";

  public static List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList<>();
    }
    int size = matrix[0].length;
    int num = matrix.length;
    boolean[][] mark = new boolean[matrix.length][size];
    int width = 0;
    int height = 0;
    List<Integer> list = new ArrayList<>();
    String direction = RIGHT;
    while (true) {
      list.add(matrix[height][width]);
      mark[height][width] = true;
      String result = judgeDirection(width, height, size, num, direction, mark, 0);
      if (result == null) {
        break;
      }
      switch (result) {
        case RIGHT:
          width++;
          break;
        case DOWN:
          height++;
          break;
        case LEFT:
          width--;
          break;
        case UP:
          height--;
          break;
        default:
          throw new RuntimeException();
      }
      direction = result;
    }
    return list;
  }

  private static String judgeDirection(
      int width, int height, int size, int num, String direction, boolean[][] mark, int times) {
    if (times == 4) {
      return null;
    }
    if (direction.equals(RIGHT)) {
      if (width + 1 >= size || mark[height][width + 1]) {
        return judgeDirection(width, height, size, num, DOWN, mark, times + 1);
      }
      return RIGHT;
    }
    if (direction.equals(DOWN)) {
      if (height + 1 >= num || mark[height + 1][width]) {
        return judgeDirection(width, height, size, num, LEFT, mark, times + 1);
      }
      return DOWN;
    }
    if (direction.equals(LEFT)) {
      if (width - 1 < 0 || mark[height][width - 1]) {
        return judgeDirection(width, height, size, num, UP, mark, times + 1);
      }
      return LEFT;
    }
    if (direction.equals(UP)) {
      if (height - 1 < 0 || mark[height - 1][width]) {
        return judgeDirection(width, height, size, num, RIGHT, mark, times + 1);
      }
      return UP;
    }
    return null;
  }

  public static void main(String[] args) {
    int[][] a = new int[3][3];
    a[0] = new int[] {1, 2, 3};
    a[1] = new int[] {4, 5, 6};
    a[2] = new int[] {7, 8, 9};
    List<Integer> list = spiralOrder(a);
    System.out.println(list);
  }
}
