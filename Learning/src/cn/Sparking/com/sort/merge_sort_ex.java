package cn.Sparking.com.sort;

//�ȶ����� ������õ�����
//�鲢���� �ݹ��
/*
 * ����ԭ���ǽ������Ѿ���������кϲ���һ�����еĲ������鲢�����㷨�����鲢������
 * 
 * ������
 * 1.����ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ��������
 * 2.�趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ��
 * 3.�Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ��
 * 4.�ظ�����3ֱ��ĳһָ�뵽������β
 * 5.����һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β
 * �ݹ鷨
 * ԭ�����£��������й���n��Ԫ�أ���
 * 1.������ÿ�����������ֽ��й鲢�������γ�floor(n/2)�����У������ÿ�����а�������Ԫ��
 * 2.�����������ٴι鲢���γ�floor(n/4)�����У�ÿ�����а����ĸ�Ԫ��
 * 3.�ظ�����2��ֱ������Ԫ���������

 */
public class merge_sort_ex {
	private static int count = 0;
//	����
	public static void merge_sort_1(int[] arr) {
		pr("��ʼ��������");
		System.out.print("��ʼ����");
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println();
		int len = arr.length;
		// �����
		int[] result = new int[len];
		// block�Ƿֿ��С
		int block, start;
		for (block = 1; block < len; block = block * 2) {
			for (start = 0; start < len; start += 2 * block) {
				int low = start;
				int mid = (start + block) < len ? (start + block) : len;
				int high = (start + 2 * block) < len ? (start + 2 * block) : len;
				// ���������ʼ�±꼰�����±�
				pr("��һ��� " + low + " �� " + mid);
				int start1 = low, end1 = mid;
				pr("�ڶ����" + mid + " �� " + high);
				int start2 = mid, end2 = high;
				// ��ʼ������block���й鲢����
				// �����һ����С ��һ����ָ����ǰ��
				while (start1 < end1 && start2 < end2) {
				 	pr("2����ָ�붼û���ߵ����һλ");
				 	if(arr[start1]<arr[start2]){
				 		pr("��һ���ֵ����ֱȵڶ�����С ȡС���Ǹ�����" + arr[start1]);
				 		result[low++] = arr[start1++];
				 		pr("�ŵ��������"+(low-1)+"λ���档");
				 	}
				 	else{
				 		pr("�ڶ����ֵ����ֱȵ�һ����С ȡС���Ǹ�����" + arr[start2]);
				 		result[low++] = arr[start2++];
				 	}
//					result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
//					low++֮��ȡԭλ�õ�Ҫ-1
//					pr("Pick the small one as " + result[low-1]);
				}
				while (start1 < end1) {
					pr("��һ����û����");
					result[low++] = arr[start1++];
					pr("��һ���ֵķŵ�������ġ�"+(low-1)+"λ");
				}
				while (start2 < end2) {
					pr("�ڶ�����û����");
					result[low++] = arr[start2++];
					pr("�ڶ����ֵķŵ�������ġ�"+(low-1)+"λ");
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

//	�ݹ�
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
//		��һ��
		int len = end - start, mid = (len >> 1) + start;
//		ǰһ��
		int start1 = start, end1 = mid;
//		��һ��
		int start2 = mid + 1, end2 = end;
		pr("mid is " + mid);
		pr("First part from " + start1 +" to " +end1);
		pr("First part from " + start2 +" to " +end2);
//		ǰһ���ٷ�
		merge_sort_recursive(arr, reg, start1, end1);
//		��һ���ٷ�
		merge_sort_recursive(arr, reg, start2, end2);
		pr("Start work from "+start+" to "+end+".");
		int k = start;
//		�ӿ�ʼλ��ʼ
//		ǰһ���һ�붼��������
		while (start1 <= end1 && start2 <= end2)
		{
			pr("Both not end.");
//			ȡ2������С���Ǹ��Ž������
			reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
			pr("Compare " + start1 + " and " + start2 +" and put "+reg[k-1]+" to position " + (k-1));
		}
//		ǰһ�������� ֱ�Ӷ��������
		while (start1 <= end1){
			reg[k++] = arr[start1++];
			pr("First part. Put "+arr[start1-1]+" to position "+(k-1));
		}
//		��һ�������� ֱ�Ӷ��������
		while (start2 <= end2){
			reg[k++] = arr[start2++];
			pr("Second part. Put "+arr[start2-1]+" to position "+(k-1));}
//		��ʱ����� �ŵ�ʵ�ʽ����
		for (k = start; k <= end; k++)
			arr[k] = reg[k];
	}
	
	public static void main(String args[]){
//		����ָ����С������ 2�� �ֱ�������ȥ����
		int size =20;
		int[] x=new int[size],y = new int[size];
		for(int i = 0; i< size;i++){
//			1-100�������
			x[i] = (int)(Math.random()*100);
			y[i] = (int)(Math.random()*100);
		}
//		��������
		merge_sort_1(x);
		prarray(x);
//		�ݹ鴦��
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
	 * ��ӡ���鵽console��
	 */
	private static void prarray(int[] a){
		System.out.print("�����ǣ�");
		for(Object aa : a)
			System.out.print(aa + " ");
	}
}
