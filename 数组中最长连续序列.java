package leetCode;
/*����һ���������飬�������������С�
��������[100,4,200,1,3,2]������������г���Ϊ[1,2,3,4]������Ϊ4��
Ҫ��ʱ�临�Ӷ�ΪO(n)��*/

import java.util.Arrays;
import java.util.HashMap;

//���������ʱ�临�Ӷȣ��������ֺ������뵽�ķ�����leetCode����ͨ��
public class ��������������� {
	 public int longestConsecutive(int[] num) {
		 	//��������Ŀ���
	        if(num.length==1||num.length==0){
	            return num.length;
	        }
	        //�ȶ���������
	        Arrays.sort(num);
			int length=0;//length��¼�Ѳ�ĳ���
			int count=1;//count��������
			for(int i=1;i<num.length;i++){
				if(num[i]-1==num[i-1]){
					count++;                   
				}else if(num[i]==num[i-1]){//Ҫ������������ȵ����
	                continue;
	            }else{//��������ǰ�泬��1,�����¼���
	                if(count>=length){//lengthֻ�Ǹ�����
	                    length=count;
	                }
	                count=1;			
				}
			}
			return count>length?count:length;
	    }	
	 //�����������������ָ�����ϵĽⷨ,��������ʱ�估ռ�ÿռ䶼�������Ǹ�������
	 public int longestConsecutive2(int[] num) {
		 if(num==null||num.length==0){
			 return 0;
		 }
		 int maxlength=1;
		 //��Hasmap���洢����������,num[i]Ϊkey,�����������г���Ϊvalue
		 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		 for(int i=0;i<num.length;i++){
			 //�������ұ������������û���ֹ��������map��
			 if(!map.containsKey(num[i])){
				 map.put(num[i], 1);
			 
			 if(map.containsKey(num[i-1]-1)){
				 maxlength = Math.max(maxlength, merge(map,num[i]-1,num[i]));
			 }
			 if(map.containsKey(num[i-1]+1)){
				 maxlength = Math.max(maxlength, merge(map,num[i],num[i]+1));
			 }
			 }
		 }
		 return maxlength;
	 }
	 //�����������г���
	 public int merge(HashMap<Integer, Integer> map,int less,int more){
		 int left=less-map.get(less)+1;//��ȡҪ���ĵ��Ǹ�����λ�ã�����5,6,7��ֻ��5��7�����г��ȣ�6�Ĳ��ø�
		 int right=more+map.get(more)-1;
		 int len=right-left+1;
		 map.put(left,len);
		 map.put(right, len);
		 return len;
	 }
	 
}
