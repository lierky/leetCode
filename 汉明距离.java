package leetCode;
//���������Ķ����Ʋ�ͬλ�ĸ���
/*Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��*/
public class �������� {
	//�Ҳ�ͬ��λ���Ƚ����������Ȼ��������1�ĸ����������ͬΪ0����ͬΪ1
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

