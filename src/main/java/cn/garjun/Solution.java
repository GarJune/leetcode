package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210408
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class Solution {
  //   0 1 2 3 4 5 6
  // 0 P     I     N
  // 1 A   L S   I G
  // 2 Y A   H R
  // 3 P     I
  //                     14 length
  public String convert(String s, int numRows) {
    char[] c = s.toCharArray();
    int column = calculateRow(numRows, s.length());
    char[][] rows = new char[column][numRows];
    int last = 0;
    for (int i = 0; i < c.length; i++) {
      int remainder = i % (numRows + numRows - 2);
      int currentColumn = (i / (numRows + numRows - 2)) * (numRows - 1);
      currentColumn = remainder < numRows ? currentColumn : currentColumn + remainder - numRows + 1;
      System.out.println(last);
      System.out.println("currentColumn:" + currentColumn);
      System.out.println("remainder:" + remainder);
      rows[currentColumn][last] = c[i];
      if (remainder >= numRows - 1) {
        last--;
      } else {
        last++;
      }
    }
    StringBuilder stringbuilder = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < column; j++) {
        char temp = rows[j][i];
        if (temp != '\0') {
          stringbuilder.append(temp);
        }
      }
    }
    return stringbuilder.toString();
  }

  private int calculateRow(int numRows, int current) {
    int remainder = current % (numRows + numRows - 2);
    int column = current / (numRows + numRows - 2);
    if (remainder != 0) {
      if (remainder > numRows) {
        column = column * (1 + numRows - 2) + 1 + (numRows - remainder);
      } else {
        column = column * (1 + numRows - 2) + 1;
      }
    }
    return column;
  }

  public static void main(String[] args) {
    String str = "ABCD";
    Solution t = new Solution();
    String result = t.convert(str, 3);
    System.out.println(result);
  }
}
