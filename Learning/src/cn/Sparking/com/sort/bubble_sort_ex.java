package cn.Sparking.com.sort;

public class bubble_sort_ex {
/*
 * 冒泡排序
 * 冒泡排序算法的运作如下：
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
	
/*
  函數 冒泡排序 輸入 一個陣列名稱為array 其長度為length
    i 從 0 到 (length - 1)
        j 從 0 到 (length - 1 - i)
            如果 array[j] > array[j + 1]
                交換 array[j] 和 array[j + 1] 的值
            如果結束
        j迴圈結束
    i迴圈結束
函數結束
 */
	
	public static void bubble_sort(int[] arr) {
		int i, j, temp, len = arr.length;
		int count = 0;
		for (i = 0; i < len - 1; i++){
//			冒泡N-1次。
//			最大的已经冒出去了。
			for (j = 0; j < len - 1 - i; j++)
			{
//				后一位比前一位小就交換，把大的放到后面。
//				大的就会到最后面。
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					pr("换第"+ count++ +"次");
				}
			}
		pr("最大的是"+arr[j]);
//		第一次出去的是arr[j+1]
		}
	}
	public static void main(String[] args) {
		int size = 20;
		int[] number = new int[size];
		for(int i = 0;i<size;i++)
			number[i] = (int)(Math.random()*100);
		bubble_sort(number);
		for(int i = 0; i < number.length; i++) 
			System.out.print(number[i] + " ");
		System.out.println();
	}
	
	private static void pr(Object a){
		System.out.println(a);
	}
}
