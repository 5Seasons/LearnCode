package cn.Sparking.com.sort;

//稳定排序
/*
 * 插入排序（英语：Insertion Sort）是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
 * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
*/
/*
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤2~5
*/
//这个比较容易= =
public class insertion_sort_ex {
	public static void insertion_sort_1( int[] arr ) {
		prarray(arr);
		System.out.println();
	    for( int i=0; i<arr.length-1; i++ ) {	
	        for( int j=i+1; j>0; j-- ) {
	            if( arr[j-1] <= arr[j] )
	                break;
//	            交换了位置
	            int temp = arr[j];
	            arr[j] = arr[j-1];
	            arr[j-1] = temp;
	            pr("换了一个"+temp+"到"+ (j-1)+"位置上");
	        }
	    }
	}
	
	// 将arr[i] 插入到arr[0]...arr[i - 1]中
		public static void insertion_sort_2(int[] arr)
		{
			prarray(arr);
			for (int i = 1; i < arr.length; i++ ) {
				int temp = arr[i];
//				前面都是有序的 跟有序的最后一个进行比较
				System.out.println();
				pr("temp现在是"+temp);
				for (int j = i - 1; j >= 0 && arr[j] > temp; j-- ) {
//					比temp大
 					arr[j + 1] = arr[j];
					arr[j] = temp;
					prarray(arr);
				}
			}
		}
		
		public static void main(String args[]){
			int size = 20;
			int[] x = new int[size];
			int[] y = new int[size];
			for(int i = 0;i<size ; i++)
			{
				x[i] = (int)(Math.random()*100);
				y[i] = (int)(Math.random()*100);
			}
//			insertion_sort_1(x);
			insertion_sort_2(y);
//			pr("");
//			pr("x现在");
//			prarray(x);
			pr("");
			pr("y现在");
			prarray(y);
		}
		
		private static void pr(Object a){
			System.out.println(a);
		}
		
		/*
		 * 打印数组到console。
		 */
		private static void prarray(int[] a){
			System.out.print("数组是：");
			for(Object aa : a)
				System.out.print(aa + " ");
		}

}
