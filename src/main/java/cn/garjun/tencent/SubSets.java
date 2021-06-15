package cn.garjun.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author :liangjiajun
 * @date :20210204
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class SubSets {
  private Set<List<Integer>> resultSet = new HashSet<>();

  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> list = new ArrayList<>();
    caculate(list, nums, 0);

    return resultSet.stream().map(ArrayList::new).collect(Collectors.toList());
  }

  public void caculate(List<Integer> list, int[] nums, int start) {
    resultSet.add(new ArrayList<>(list)); // 0 1
    for (int i = start; i < nums.length; i++) {
      list.add(nums[i]);
      caculate(list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1};
    SubSets subSets = new SubSets();
    List<List<Integer>> list = subSets.subsets(nums);
    System.out.println(list);
  }
}
