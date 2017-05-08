package leetCode;
//求两个数的二进制不同位的个数
/*Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑*/
public class 汉明距离 {
	//找不同的位，先将两个数异或，然后求结果中1的个数。异或相同为0，不同为1
	public int hammingDistance(int x, int y) {
        int xor=x^y;
        int count=0;
        while(xor!=0){        	
        		count+=xor&1;
        		xor=xor>>1;        	
        }
        return count;
    }
}

