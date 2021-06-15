package cn.garjun;

import java.util.TreeMap;

/**
 * @author :liangjiajun
 * @date :20210326
 * @description 123模式
 * @email :jaron.liang@jodoinc.com
 */
public class Find123Pattern {
  //    i < j < k 和 nums[i] < nums[k] < nums[j]
  public static boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
    for (int i = 1; i < nums.length; i++) {
      treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
    }
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      Integer second = treeMap.ceilingKey(min + 1);
      if (second != null && nums[i] > second) {
        return true;
      }
      if (min > nums[i]) {
        min = nums[i];
      }
      if (treeMap.get(nums[i]) == 1) {
        treeMap.remove(nums[i]);
      } else {
        treeMap.put(nums[i], treeMap.get(nums[i]) - 1);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    // 1 3 0 2
    int[] ints = new int[] {1, 2, 3, 4};
    boolean result = find132pattern(ints);
    System.out.println(result);
  }
}
