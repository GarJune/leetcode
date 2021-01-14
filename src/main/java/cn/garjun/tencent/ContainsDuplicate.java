package cn.garjun.tencent;

import java.util.HashSet;

/**
 * @author :liangjiajun
 * @date :20201110
 * @description 存在重复元素
 * @email :jaron.liang@jodoinc.com
 */
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<Integer>(nums.length);
    for (int i : nums) {
      if (set.contains(i)) {
        return true;
      } else {
        set.add(i);
      }
    }
    return false;
  }
}
