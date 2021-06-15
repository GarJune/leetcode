package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210118
 * @description 搜索旋转排序数组
 * @email :jaron.liang@jodoinc.com
 */
public class Search {
  // 1 2 3 4 0
  public static int search(int[] nums, int target) {
    if (nums.length == 1) {
      return target == nums[0] ? 0 : -1;
    }
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (target == nums[mid]) {
        return mid;
      }
      if (nums[l] <= nums[mid]) {
        if (nums[l] <= target && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] n = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
    int result = search(n, 0);
    System.out.println(result);
  }
}
