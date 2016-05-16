package cn.Sparking.com.sort;

//稳定排序 现在最好的排序
//归并排序 递归版
/*
 * 基本原理是将两个已经排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。
 * 
 * 迭代法
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4.重复步骤3直到某一指针到达序列尾
 * 5.将另一序列剩下的所有元素直接复制到合并序列尾
 * 递归法
 * 原理如下（假设序列共有n个元素）：
 * 1.将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
 * 2.将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
 * 3.重复步骤2，直到所有元素排序完毕

 */
public class merge_sort_ex {
	private static int count = 0;
//	迭代
	public static void merge_sort_1(int[] arr) {
		pr("开始迭代处理。");
		System.out.print("初始数组");
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println();
		int len = arr.length;
		// 结果集
		int[] result = new int[len];
		// block是分块大小
		int block, start;
		for (block = 1; block < len; block = block * 2) {
			for (start = 0; start < len; start += 2 * block) {
				int low = start;
				int mid = (start + block) < len ? (start + block) : len;
				int high = (start + 2 * block) < len ? (start + 2 * block) : len;
				// 两个块的起始下标及结束下标
				pr("第一块从 " + low + " 到 " + mid);
				int start1 = low, end1 = mid;
				pr("第二块从" + mid + " 到 " + high);
				int start2 = mid, end2 = high;
				// 开始对两个block进行归并排序
				// 如果第一部分小 第一部分指针向前。
				while (start1 < end1 && start2 < end2) {
				 	pr("2部分指针都没有走到最后一位");
				 	if(arr[start1]<arr[start2]){
				 		pr("第一部分的数字比第二部分小 取小的那个。是" + arr[start1]);
				 		result[low++] = arr[start1++];
				 		pr("放到结果集的"+(low-1)+"位上面。");
				 	}
				 	else{
				 		pr("第二部分的数字比第一部分小 取小的那个。是" + arr[start2]);
				 		result[low++] = arr[start2++];
				 	}
//					result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
//					low++之后取原位置的要-1
//					pr("Pick the small one as " + result[low-1]);
				}
				while (start1 < end1) {
					pr("第一部分没走完");
					result[low++] = arr[start1++];
					pr("第一部分的放到结果集的。"+(low-1)+"位");
				}
				while (start2 < end2) {
					pr("第二部分没走完");
					result[low++] = arr[start2++];
					pr("第二部分的放到结果集的。"+(low-1)+"位");
				}
			}
			int[] temp = arr;
			arr = result;
			result = temp;
			for(int i : result)
				System.out.print(i+" ");
			System.out.println();
		}
		result = arr;
	}

//	递归
	public static void merge_sort_2(int[] arr) {
		int len = arr.length;
		int[] reg = new int[len];
		merge_sort_recursive(arr, reg, 0, len - 1);
	}
	/*
	 * Use for merge_sort_2
	 */
	static void merge_sort_recursive(int[] arr, int[] reg, int start, int end) {
		pr("This is " + count++ + "time divide.");
		prarray(reg);
		if (start >= end)
			return;
//		分一半
		int len = end - start, mid = (len >> 1) + start;
//		前一半
		int start1 = start, end1 = mid;
//		后一半
		int start2 = mid + 1, end2 = end;
		pr("mid is " + mid);
		pr("First part from " + start1 +" to " +end1);
		pr("First part from " + start2 +" to " +end2);
//		前一半再分
		merge_sort_recursive(arr, reg, start1, end1);
//		后一半再分
		merge_sort_recursive(arr, reg, start2, end2);
		pr("Start work from "+start+" to "+end+".");
		int k = start;
//		从开始位开始
//		前一半后一半都还有数字
		while (start1 <= end1 && start2 <= end2)
		{
			pr("Both not end.");
//			取2半里面小的那个放进结果集
			reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
			pr("Compare " + start1 + " and " + start2 +" and put "+reg[k-1]+" to position " + (k-1));
		}
//		前一半有数字 直接丢到结果集
		while (start1 <= end1){
			reg[k++] = arr[start1++];
			pr("First part. Put "+arr[start1-1]+" to position "+(k-1));
		}
//		后一半有数字 直接丢到结果集
		while (start2 <= end2){
			reg[k++] = arr[start2++];
			pr("Second part. Put "+arr[start2-1]+" to position "+(k-1));}
//		临时结果集 放到实际结果集
		for (k = start; k <= end; k++)
			arr[k] = reg[k];
	}
	
	public static void main(String args[]){
//		生成指定大小的数组 2个 分别用两种去排序
		int size =20;
		int[] x=new int[size],y = new int[size];
		for(int i = 0; i< size;i++){
//			1-100的随机数
			x[i] = (int)(Math.random()*100);
			y[i] = (int)(Math.random()*100);
		}
//		迭代处理
		merge_sort_1(x);
		prarray(x);
//		递归处理
		merge_sort_2(y);
		prarray(y);
		
	}
	/*
	 * Just print info to console.
	 */
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
