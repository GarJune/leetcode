package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20210120
 * @description 数组中的第K个最大元素
 * @email :jaron.liang@jodoinc.com
 */
public class FindKthLargest {
  public static int findKthLargest(int[] nums, int k) {
    buildMaxHeap(nums, nums.length);
    for (int i = 0; i < k; i++) {
      int temp = nums[0];
      nums[0] = nums[nums.length - i - 1];
      nums[nums.length - i - 1] = temp;
      maxHeapify(nums, 0, nums.length - i - 1);
    }

    return nums[nums.length - k];
  }

  public static void buildMaxHeap(int[] nums, int length) {
    for (int i = length / 2; i >= 0; i--) {
      maxHeapify(nums, i, length);
    }
  }

  public static void maxHeapify(int[] nums, int i, int length) {
    int l = (i << 1) + 1;
    int r = l + 1;
    int largest = i;
    if (l < length && nums[l] > nums[largest]) {
      largest = l;
    }
    if (r < length && nums[r] > nums[largest]) {
      largest = r;
    }
    if (largest != i) {
      int temp = nums[i];
      nums[i] = nums[largest];
      nums[largest] = temp;
      maxHeapify(nums, largest, length);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    int result = findKthLargest(nums, 2);
    System.out.println(result);
  }
}
