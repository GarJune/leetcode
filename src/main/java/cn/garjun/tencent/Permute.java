package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :liangjiajun
 * @date :20210210
 * @description 全排列
 * @email :jaron.liang@jodoinc.com
 */
public class Permute {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    List<Integer> list = new ArrayList<>();
    iterate(list, nums);
    return result;
  }

  public void iterate(List<Integer> list, int[] nums) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (list.contains(nums[i])) {
        continue;
      }
      list.add(nums[i]);
      iterate(list, nums);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] ints = new int[] {1, 2, 3};
    Permute permute = new Permute();
    List<List<Integer>> lists = permute.permute(ints);
    System.out.println(lists);
  }
}
