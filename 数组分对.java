package leetCode;

import java.util.Arrays;

//����һ������Ϊ2n���������飬������ֳ�n�飬��ÿ��������Сֵ֮�͵����ֵ��
/*[1,2,3,4]
 * [1,2][3,4] 1,3
 * [1,3][2,4] 1,2
 * [1,4][2,3] 1,2
 * ���Ϊ4
 * */
public class ����ֶ� {
	//���������򣬰������±�Ϊż���ļӺ�
	  public int arrayPairSum(int[] nums) {
	        Arrays.sort(nums);
			int count=0;
	        for(int i=0;i<nums.length;i+=2){
	        	count+=nums[i];
	        }
	        return count;
	    }
}
