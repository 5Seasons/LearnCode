package cn.Sparking.com.sort;

//Copy from web
public class merge_sort_ex {
	private static int count = 0;
	static void merge_sort_recursive(int[] arr, int[] reg, int start, int end) {
		pr("This is " + count++ + "time divide.");
		if (start >= end)
			return;
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		pr("mid is " + mid);
		pr("First part from " + start1 +" to " +end1);
		pr("First part from " + start2 +" to " +end2);
		merge_sort_recursive(arr, reg, start1, end1);
		merge_sort_recursive(arr, reg, start2, end2);
		pr("Actual work.");
		int k = start;
		while (start1 <= end1 && start2 <= end2)
		{
			pr("Both not end.");
			reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
			pr("Compare " + start1 + " and " + start2 +" and put "+reg[k-1]+" to position " + (k-1));
		}
		while (start1 <= end1){
			reg[k++] = arr[start1++];
			pr("First part. Put "+arr[start1-1]+" to position "+(k-1));
		}
		while (start2 <= end2){
			reg[k++] = arr[start2++];
			pr("Second part. Put "+arr[start2-1]+" to position "+(k-1));}
		for (k = start; k <= end; k++)
			arr[k] = reg[k];
	}

	public static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] reg = new int[len];
		merge_sort_recursive(arr, reg, 0, len - 1);
	}
	
	public static void main(String args[]){
		int[] x = new int[100];
		for(int i = 0; i< 100;i++){
			x[i] = (int)(Math.random()*100);
		}
		merge_sort(x);
		for(int xx : x)
			pr(xx);
	}
	
	private static void pr(Object a){
		System.out.println(a);
	}
}
