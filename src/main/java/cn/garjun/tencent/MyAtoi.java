package cn.garjun.tencent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :liangjiajun
 * @date :20201006
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class MyAtoi {

  public int myAtoi(String s) {
    String trimStr = s.trim();
    int symbol = 1;
    String handledStr = trimStr;
    Set<Character> set = new HashSet<>();
    set.add('0');
    set.add('1');
    set.add('2');
    set.add('3');
    set.add('4');
    set.add('5');
    set.add('6');
    set.add('7');
    set.add('8');
    set.add('9');
    if (trimStr.startsWith("+")) {
      handledStr = trimStr.substring(1);
    } else if (trimStr.startsWith("-")) {
      handledStr = trimStr.substring(1);
      symbol = -1;
    }
    int result = 0;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < handledStr.length(); i++) {
      char c = handledStr.charAt(i);
      if (set.contains(c)) {
        stringBuilder.append(c);
      } else {
        break;
      }
    }
    String resultStr = stringBuilder.toString();
    while (resultStr.startsWith("0")) {
      resultStr = resultStr.substring(1);
    }
    if (resultStr.length() == 0) {
      return 0;
    }
    if (resultStr.length() > 11) {
      if (symbol == -1) {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
    double resultLong = Double.valueOf(resultStr) * symbol;
    if (resultLong > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (resultLong < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) resultLong;
  }

  public static void main(String[] args) {
    MyAtoi m = new MyAtoi();
    int result = m.myAtoi("20000000000000000000");
    System.out.println(result);
  }
}
