package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201112
 * @description 螺旋矩阵 II
 * @email :jaron.liang@jodoinc.com
 */
public class GenerateMatrix {
  private static final String RIGHT = "RIGHT";
  private static final String LEFT = "LEFT";
  private static final String DOWN = "DOWN";
  private static final String UP = "UP";

  //    输入: 3
  //    输出:
  //            [
  //            [ 1, 2, 3 ],
  //            [ 8, 9, 4 ],
  //            [ 7, 6, 5 ]
  //            ]

  public static int[][] generateMatrix(int n) {
    int[][] nums = new int[n][n];
    int width = 0;
    int height = 0;
    String direction = RIGHT;
    int current = 1;
    while (true) {
      nums[height][width] = current;
      String result = judgeDirection(width, height, n, n, direction, nums, 0);
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
      current++;
    }
    return nums;
  }

  private static String judgeDirection(
      int width, int height, int size, int num, String direction, int[][] mark, int times) {
    if (times == 4) {
      return null;
    }
    if (direction.equals(RIGHT)) {
      if (width + 1 >= size || mark[height][width + 1] != 0) {
        return judgeDirection(width, height, size, num, DOWN, mark, times + 1);
      }
      return RIGHT;
    }
    if (direction.equals(DOWN)) {
      if (height + 1 >= num || mark[height + 1][width] != 0) {
        return judgeDirection(width, height, size, num, LEFT, mark, times + 1);
      }
      return DOWN;
    }
    if (direction.equals(LEFT)) {
      if (width - 1 < 0 || mark[height][width - 1] != 0) {
        return judgeDirection(width, height, size, num, UP, mark, times + 1);
      }
      return LEFT;
    }
    if (direction.equals(UP)) {
      if (height - 1 < 0 || mark[height - 1][width] != 0) {
        return judgeDirection(width, height, size, num, RIGHT, mark, times + 1);
      }
      return UP;
    }
    return null;
  }

  public static void main(String[] args) {
    int[][] result = generateMatrix(3);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.println(result[i][j]);
      }
    }
  }
}
