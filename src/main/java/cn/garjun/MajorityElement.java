package cn.garjun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20200313
 * @description 多数元素
 * @email :jaron.liang@jodoinc.com
 */
public class MajorityElement {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if (map.containsKey(nums[i])) {
        int count = map.get(nums[i]) + 1;
        if (count > nums.length / 2) {
          return nums[i];
        }
        map.put(nums[i], count);
      } else {
        map.put(nums[i], 1);
      }
    }
    return 0;
  }
}
