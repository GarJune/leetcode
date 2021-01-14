package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201109
 * @description 除自身以外数组的乘积
 * @email :jaron.liang@jodoinc.com
 */
public class ProductExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];
    answer[0] = 1;
    for (int i = 1; i < answer.length; i++) {
      answer[i] = answer[i - 1] * nums[i - 1];
    }
    int R = 1;
    for (int i = answer.length - 1; i >= 0; i--) {
      answer[i] = answer[i] * R;
      R *= nums[i];
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 4};
    a = productExceptSelf(a);
    for (int i : a) {
      System.out.println(i);
    }
  }
}
