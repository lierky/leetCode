package leetCode;

import java.util.Arrays;

//给定一个长度为2n的整数数组，将数组分成n组，求每组数的最小值之和的最大值。
/*[1,2,3,4]
 * [1,2][3,4] 1,3
 * [1,3][2,4] 1,2
 * [1,4][2,3] 1,2
 * 结果为4
 * */
public class 数组分对 {
	//将数组排序，把所有下标为偶数的加和
	  public int arrayPairSum(int[] nums) {
	        Arrays.sort(nums);
			int count=0;
	        for(int i=0;i<nums.length;i+=2){
	        	count+=nums[i];
	        }
	        return count;
	    }
}
