package leetCode;
/*给定一个整形数组，求出最长的连续序列。
例如数组[100,4,200,1,3,2]，最长的连续序列长度为[1,2,3,4]，长度为4。
要求时间复杂度为O(n)。*/

import java.util.Arrays;
import java.util.HashMap;

//如果不限制时间复杂度，可用这种很容易想到的方法，leetCode编译通过
public class 数组中最长连续序列 {
	 public int longestConsecutive(int[] num) {
		 	//特殊情况的考虑
	        if(num.length==1||num.length==0){
	            return num.length;
	        }
	        //先对数组排序
	        Arrays.sort(num);
			int length=0;//length记录已查的长度
			int count=1;//count用来计数
			for(int i=1;i<num.length;i++){
				if(num[i]-1==num[i-1]){
					count++;                   
				}else if(num[i]==num[i-1]){//要考虑两个数相等的情况
	                continue;
	            }else{//如果后面减前面超过1,则重新计数
	                if(count>=length){//length只记更长的
	                    length=count;
	                }
	                count=1;			
				}
			}
			return count>length?count:length;
	    }	
	 //下面是左神代码面试指南书上的解法,可是运行时间及占用空间都比上面那个方法高
	 public int longestConsecutive2(int[] num) {
		 if(num==null||num.length==0){
			 return 0;
		 }
		 int maxlength=1;
		 //用Hasmap来存储遍历过的数,num[i]为key,该数所在序列长度为value
		 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		 for(int i=0;i<num.length;i++){
			 //从左往右遍历，如果该数没出现过，则放入map里
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
	 //用来更新序列长度
	 public int merge(HashMap<Integer, Integer> map,int less,int more){
		 int left=less-map.get(less)+1;//获取要更改的那个数的位置，比如5,6,7，只改5和7的序列长度，6的不用改
		 int right=more+map.get(more)-1;
		 int len=right-left+1;
		 map.put(left,len);
		 map.put(right, len);
		 return len;
	 }
	 
}
