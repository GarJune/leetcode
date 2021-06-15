package cn.garjun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20210326
 * @description 高楼扔鸡蛋
 * @email :jaron.liang@jodoinc.com
 */
public class SuperEggDrop {
  class Node {
    int k;
    int n;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return k == node.k && n == node.n;
    }

    @Override
    public int hashCode() {
      return super.hashCode();
    }
  }

  private Map<Node, Integer> map = new HashMap<>();

  public int superEggDrop(int k, int n) {
    return dp(k, n);
  }

  public int dp(int k, int n) {
    if (k == 1) {
      return n;
    }
    if (n == 0) {
      return 0;
    }
    Node node = new Node();
    node.k = k;
    node.n = n;
    if (map.containsKey(node)) {
      System.out.println(map.get(node));
      return map.get(node);
    }
    int min = Integer.MAX_VALUE;
    int start = 1;
    int end = n;
    while (end >= start) {
      int middle = (start + end) / 2;
      int first = dp(k - 1, middle - 1);
      int second = dp(k, n - middle);
      int res;
      if (first > second) {
        end = middle - 1;
        res = first + 1;
      } else {
        start = middle + 1;
        res = second + 1;
      }
      if (min > res) {
        min = res;
      }
    }
    map.put(node, min);
    return min;
  }

  public static void main(String[] args) {
    SuperEggDrop s = new SuperEggDrop();
    int result = s.superEggDrop(3, 14);
    System.out.println(result);
  }
}
