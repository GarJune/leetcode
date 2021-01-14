package cn.garjun.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author :liangjiajun
 * @date :20201017
 * @description 有效的括号
 * @email :jaron.liang@jodoinc.com
 */
public class IsValid {
  public static boolean isValid(String s) {
    if (s.trim().length() == 0) {
      return true;
    }
    if (s.length() % 2 != 0) {
      return false;
    }
    Map<Character, Character> charMap = new HashMap<>();
    charMap.put('(', ')');
    charMap.put('{', '}');
    charMap.put('[', ']');
    Stack<Character> left = new Stack<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (charMap.containsKey(c)) {
        left.push(c);
      } else {
        if (left.isEmpty() || charMap.get(left.pop()) != c) {
          return false;
        }
      }
    }
    if (left.isEmpty()) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    boolean result = isValid("()[]{}");
    System.out.println(result);
  }
}
