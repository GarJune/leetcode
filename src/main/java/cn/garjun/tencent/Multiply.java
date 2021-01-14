package cn.garjun.tencent;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20201017
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class Multiply {
  public static String multiply(String num1, String num2) {
    if (num1.length() > num2.length()) {
      return multiply(num2, num1);
    }
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    Map<Character, Long> numMap = new HashMap<>();
    numMap.put('0', 0L);
    numMap.put('1', 1L);
    numMap.put('2', 2L);
    numMap.put('3', 3L);
    numMap.put('4', 4L);
    numMap.put('5', 5L);
    numMap.put('6', 6L);
    numMap.put('7', 7L);
    numMap.put('8', 8L);
    numMap.put('9', 9L);
    char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
    char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();
    long add = 0;
    String total = "0";
    for (int i = 0; i < num1.length(); i++) {
      String sum = "0";
      for (int j = 0; j < num2.length(); j++) {
        long first = numMap.get(chars1[i]);
        long second = numMap.get(chars2[j]);
        long result = first * second;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(result));
        for (int k = 0; k < j + i; k++) {
          stringBuilder.append(0);
        }
        sum = sum(stringBuilder.toString(), sum);
      }
      total = sum(sum, total);
    }
    return total;
  }

  private static String sum(String num1, String num2) {
    if (num1.length() > num2.length()) {
      return sum(num2, num1);
    }
    int add = 0;
    String str1 = new StringBuilder(num1).reverse().toString();
    String str2 = new StringBuilder(num2).reverse().toString();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < num2.length(); i++) {
      int second = 0;
      if (num1.length() > i) {
        second = str1.charAt(i) - '0';
      }
      int first = str2.charAt(i) - '0';
      int result = first + second + add;
      add = result / 10;
      stringBuilder.append(result % 10);
    }
    if (add != 0) {
      stringBuilder.append(add);
    }
    return stringBuilder.reverse().toString();
  }

  public static void main(String[] args) {
    // "3866762897776739956"
    // "15975363164662"
    // 39176187142816108674
    String str = multiply("3866762897776739956", "6529364523802684779");
    BigDecimal one = new BigDecimal("3866762897776739956");
    BigDecimal two = new BigDecimal("6529364523802684779");
    System.out.println(one.multiply(two).toString());
    System.out.println(str);
  }
}
