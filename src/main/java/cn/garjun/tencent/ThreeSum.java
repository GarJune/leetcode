package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20201013
 * @description 三数之和
 * @email :jaron.liang@jodoinc.com
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return new ArrayList<>();
    }
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          j++;
          continue;
        }
        if (k != nums.length - 1 && nums[k] == nums[k + 1]) {
          k = k - 1;
          continue;
        }
        int first = nums[i];
        int second = nums[j];
        int three = (first + second) * -1;
        if (three == nums[k]) {
          List<Integer> target = new ArrayList<>();
          target.add(first);
          target.add(second);
          target.add(three);
          list.add(target);
          j++;
          k--;
          continue;
        }
        if (three > nums[k]) {
          j++;
        }
        if (three < nums[k]) {
          k--;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

    ThreeSum sum = new ThreeSum();
    List<List<Integer>> list = sum.threeSum(nums);
    for (List<Integer> each : list) {
      System.out.println(each);
    }
  }
}
