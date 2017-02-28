package cn.Sparking.com.sort;

import static cn.Sparking.com.tool.pr.pr;

//稳定排序
/*桶排序（Bucket sort）或所谓的箱排序，是一个排序算法，
 * 工作的原理是将数组分到有限数量的桶子里。
 * 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。
 * 桶排序是鸽巢排序的一种归纳结果。
 * 当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间（Θ(n)）。
 * 但桶排序并不是比较排序，他不受到O(n log n)下限的影响。
 */
/*
 * 桶排序以下列程序进行：
 * 1.设置一个定量的数组当作空桶子。
 * 2.寻访序列，并且把项目一个一个放到对应的桶子去。
 * 3.对每个不是空的桶子进行排序。
 * 4.从不是空的桶子里把项目再放回原来的序列中。
 */
public class BucketSort_Ex{
    public static void main(String args[]){
//        int[] dataArr = new int[10];
        int[] dataArr = {78,37,4,1,9,39,75,44,44,76};
//        for(int i = 0;i < 10; i++){
//            dataArr[i] = (int)(Math.random()*100);
//        }
        pr("生成随机数组，排序前如下:");
        for(int da : dataArr){
            System.out.print(da+" ");
        }
        BucketSort_Ex buckSort = new BucketSort_Ex();
        buckSort.basket(dataArr);
        pr("排序后数组如下");
        for(int da : dataArr){
            System.out.print(da+" ");
        }
    }

    private void basket(int data[])//data为待排序数组
    {
        int n=data.length;
        int bask[][]=new int[10][n];
        int index[]=new int[10];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=max>(Integer.toString(data[i]).length())?max:(Integer.toString(data[i]).length());
        }
        pr("找出数字的最大长度为:" + max);
        String str;
        for(int i=max-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                str="";
//                pr("位置填充:将原数组的每一个数字转化成String并补0在数字前");
                if(Integer.toString(data[j]).length()<max)
                {
                    for(int k=0;k<max-Integer.toString(data[j]).length();k++)
                        str+="0";
                }
                str+=Integer.toString(data[j]);
                pr("第"+(j+1)+"位补0后为 : "+ str);
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
