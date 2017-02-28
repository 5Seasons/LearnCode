package cn.Sparking.com.sort;

import static cn.Sparking.com.tool.pr.pr;

//�ȶ�����
/*Ͱ����Bucket sort������ν����������һ�������㷨��
 * ������ԭ���ǽ�����ֵ�����������Ͱ���
 * ÿ��Ͱ���ٸ��������п�����ʹ�ñ�������㷨�����Եݹ鷽ʽ����ʹ��Ͱ����������򣩡�
 * Ͱ�����Ǹ볲�����һ�ֹ��ɽ����
 * ��Ҫ������������ڵ���ֵ�Ǿ��ȷ����ʱ��Ͱ����ʹ������ʱ�䣨��(n)����
 * ��Ͱ���򲢲��ǱȽ����������ܵ�O(n log n)���޵�Ӱ�졣
 */
/*
 * Ͱ���������г�����У�
 * 1.����һ�����������鵱����Ͱ�ӡ�
 * 2.Ѱ�����У����Ұ���Ŀһ��һ���ŵ���Ӧ��Ͱ��ȥ��
 * 3.��ÿ�����ǿյ�Ͱ�ӽ�������
 * 4.�Ӳ��ǿյ�Ͱ�������Ŀ�ٷŻ�ԭ���������С�
 */
public class BucketSort_Ex{
    public static void main(String args[]){
//        int[] dataArr = new int[10];
        int[] dataArr = {78,37,4,1,9,39,75,44,44,76};
//        for(int i = 0;i < 10; i++){
//            dataArr[i] = (int)(Math.random()*100);
//        }
        pr("����������飬����ǰ����:");
        for(int da : dataArr){
            System.out.print(da+" ");
        }
        BucketSort_Ex buckSort = new BucketSort_Ex();
        buckSort.basket(dataArr);
        pr("�������������");
        for(int da : dataArr){
            System.out.print(da+" ");
        }
    }

    private void basket(int data[])//dataΪ����������
    {
        int n=data.length;
        int bask[][]=new int[10][n];
        int index[]=new int[10];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=max>(Integer.toString(data[i]).length())?max:(Integer.toString(data[i]).length());
        }
        pr("�ҳ����ֵ���󳤶�Ϊ:" + max);
        String str;
        for(int i=max-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                str="";
//                pr("λ�����:��ԭ�����ÿһ������ת����String����0������ǰ");
                if(Integer.toString(data[j]).length()<max)
                {
                    for(int k=0;k<max-Integer.toString(data[j]).length();k++)
                        str+="0";
                }
                str+=Integer.toString(data[j]);
                pr("��"+(j+1)+"λ��0��Ϊ : "+ str);
                bask[str.charAt(i)-'0'][index[str.charAt(i)-'0']++]=data[j];
            }
            int pos=0;
            for(int j=0;j<10;j++)
            {
                for(int k=0;k<index[j];k++)
                {
                    data[pos++]=bask[j][k];
                }
            }
            for(int x=0;x<10;x++)index[x]=0;
        }
    }
}
