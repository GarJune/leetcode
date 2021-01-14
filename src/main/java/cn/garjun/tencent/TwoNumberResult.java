package cn.garjun.tencent;

import java.util.Stack;

/**
 * @author :liangjiajun
 * @date :20201002
 * @description 两数之和
 * @email :jaron.liang@jodoinc.com
 */
public class TwoNumberResult {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
