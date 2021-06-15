package cn.garjun;

/**
 * @author :liangjiajun
 * @date :20210422
 * @description 排序
 * @email :jaron.liang@jodoinc.com
 */
public class SortArray {
  public static int[] sortArray(int[] nums) {
    sort(0, nums.length - 1, nums);
    return nums;
  }

  private static void sort(int i, int j, int[] nums) {
    if (i >= j) {
      return;
    }
    int begin = i;
    int end = j;
    int base = nums[i];
    while (i < j) {
      while (j > i && base < nums[j]) {
        j--;
      }
      if (j > i) {
        nums[i] = nums[j];
        i++;
      }
      while (j > i && base > nums[i]) {
        i++;
      }
      if (j > i) {
        nums[j] = nums[i];
        j--;
      }
    }
    nums[i] = base;
    sort(begin, i - 1, nums);
    sort(i + 1, end, nums);
  }

  public static void main(String[] args) {
    int[] nums = new int[] {5, 1, 1, 2, 0, 0};
    int[] i = sortArray(nums);
    for (int j = 0; j < nums.length; j++) {
      System.out.println(i[j]);
    }
  }
}
