package cn.Sparking.com.sort;

//�ȶ�����
/*
 * ��������Ӣ�Insertion Sort����һ�ּ�ֱ�۵������㷨��
 * ���Ĺ���ԭ����ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬�ҵ���Ӧλ�ò����롣
 * ����������ʵ���ϣ�ͨ������in-place���򣨼�ֻ���õ�O(1)�Ķ���ռ�����򣩣�
 * ����ڴӺ���ǰɨ������У���Ҫ������������Ԫ�������Ųλ��Ϊ����Ԫ���ṩ����ռ䡣
*/
/*
 * һ����˵���������򶼲���in-place��������ʵ�֡������㷨�������£�
 * 1.�ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
 * 2.ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
 * 3.�����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��
 * 4.�ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��
 * 5.����Ԫ�ز��뵽��λ�ú�
 * 6.�ظ�����2~5
*/
//����Ƚ�����= =
public class insertion_sort_ex {
	public static void insertion_sort_1( int[] arr ) {
		prarray(arr);
		System.out.println();
	    for( int i=0; i<arr.length-1; i++ ) {	
	        for( int j=i+1; j>0; j-- ) {
	            if( arr[j-1] <= arr[j] )
	                break;
//	            ������λ��
	            int temp = arr[j];
	            arr[j] = arr[j-1];
	            arr[j-1] = temp;
	            pr("����һ��"+temp+"��"+ (j-1)+"λ����");
	        }
	    }
	}
	
	// ��arr[i] ���뵽arr[0]...arr[i - 1]��
		public static void insertion_sort_2(int[] arr)
		{
			prarray(arr);
			for (int i = 1; i < arr.length; i++ ) {
				int temp = arr[i];
//				ǰ�涼������� ����������һ�����бȽ�
				System.out.println();
				pr("temp������"+temp);
				for (int j = i - 1; j >= 0 && arr[j] > temp; j-- ) {
//					��temp��
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
//			pr("x����");
//			prarray(x);
			pr("");
			pr("y����");
			prarray(y);
		}
		
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
