package cn.garjun;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author :liangjiajun
 * @date :20210407
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class IsMatch {

  class Result {
    Integer i;
    Integer j;

    public boolean equals(Object o) {
      if (!(o instanceof Result)) {
        return false;
      }
      Result result = (Result) o;
      if (i.equals(result.i) && j.equals(result.j)) {
        return true;
      }
      return false;
    }

    public Result(Integer i, Integer j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }

  Map<Result, Boolean> map = new HashMap<>();

  public boolean isMatch(String s, String p) {
    return dp(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  public boolean dp(char[] s, int i, char[] p, int j) {
    if (s.length == i) {
      if ((p.length - j) % 2 == 1) {
        map.put(new Result(i, j), false);
        return false;
      }
      for (; j + 1 < p.length; j += 2) {
        if (p[j + 1] != '*') {
          map.put(new Result(i, j), false);
          return false;
        }
      }
      map.put(new Result(i, j), true);
      return true;
    }
    if (p.length == j) {
      map.put(new Result(i, j), false);
      return false;
    }
    boolean contains = map.containsKey(new Result(i, j));
    if (contains) {
      System.out.println(contains);
      return map.get(new Result(i, j));
    }

    if (s[i] == p[j] || p[j] == '.') {
      if (p.length - 1 > j && p[j + 1] == '*') {
        boolean result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
        map.put(new Result(i, j), result);
        return result;
      } else {
        boolean result = dp(s, i + 1, p, j + 1);
        map.put(new Result(i, j), result);
        return result;
      }
    } else {
      if (p.length - 1 > j && p[j + 1] == '*') {
        return dp(s, i, p, j + 2);
      } else {
        map.put(new Result(i, j), false);
        return false;
      }
    }
  }

  public static void main(String[] args) {
    String a = "aaaaaaaaaaaaab";
    String b = "a*a*a*a*a*a*a*a*a*a*c";
    IsMatch i = new IsMatch();
    boolean result = i.isMatch(a, b);
    System.out.println(result);
  }
}
