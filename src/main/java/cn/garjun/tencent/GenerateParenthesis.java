package cn.garjun.tencent;

import java.util.*;

/**
 * @author :liangjiajun
 * @date :20210204
 * @description 括号生成
 * @email :jaron.liang@jodoinc.com
 */
public class GenerateParenthesis {
  private static final String LEFT = "(";
  private static final String RIGHT = ")";
  private Set<String> resultSet = new HashSet<>();

  public List<String> generateParenthesis(int n) {
    generateParenthesis(new ArrayDeque<>(), n, n);
    return new ArrayList<>(resultSet);
  }

  public void generateParenthesis(Deque<String> strings, int l, int r) {
    if (l == 0 && r == 0) {
      Deque<String> deque = new ArrayDeque<>(strings);
      boolean result = checkCorrect(deque);
      if (result) {
        StringBuilder stringBuilder = new StringBuilder();
        strings.forEach(stringBuilder::append);
        resultSet.add(stringBuilder.reverse().toString());
      }
      return;
    }
    if (l != 0) {
      strings.push(LEFT);
      generateParenthesis(strings, l - 1, r);
      strings.pop();
    }
    if (r != 0) {
      strings.push(RIGHT);
      generateParenthesis(strings, l, r - 1);
      strings.pop();
    }
  }

  public boolean checkCorrect(Deque<String> strings) {
    Deque<String> rightStack = new ArrayDeque<>();
    while (!strings.isEmpty()) {
      String str = strings.pop();
      if (str.equals(LEFT)) {
        String right = rightStack.poll();
        if (right == null) {
          return false;
        }
      } else {
        rightStack.push(str);
      }
    }
    if (rightStack.isEmpty()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    GenerateParenthesis generateParenthesis = new GenerateParenthesis();
    List<String> list = generateParenthesis.generateParenthesis(1);
    System.out.println(list);
  }
}
