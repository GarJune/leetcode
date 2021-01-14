package cn.garjun.tencent;

/**
 * @author :liangjiajun
 * @date :20201218
 * @description
 * @email :jaron.liang@jodoinc.com
 */
public class SingleNum {
  public int singleNumber(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result = result ^ nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] i = new int[] {1, 2, 2};
    SingleNum singleNum = new SingleNum();
    int result = singleNum.singleNumber(i);
    System.out.println(result);
  }
}
