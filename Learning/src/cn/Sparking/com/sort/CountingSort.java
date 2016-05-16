package cn.Sparking.com.sort;

import cn.Sparking.com.tool.pr;

//�ȶ�����
/*
 * ��������Counting sort����һ���ȶ�������ʱ�������㷨��
 * ��������ʹ��һ�����������C�����е�i��Ԫ���Ǵ���������A��ֵ����i��Ԫ�صĸ�����
 * Ȼ���������C����A�е�Ԫ���ŵ���ȷ��λ�á�
 */
/*
 * �������Ԫ����n��0��k֮�������ʱ����������ʱ���Ǧ�(n + k)�����������ǱȽ�����������ٶȿ����καȽ������㷨��
 * ������������������C�ĳ���ȡ���ڴ��������������ݵķ�Χ�����ڴ�������������ֵ����Сֵ�Ĳ����1����
 * ��ʹ�ü�������������ݷ�Χ�ܴ�����飬��Ҫ����ʱ����ڴ档
 * ���磺������������������0��100֮������ֵ���õ��㷨�����������ʺϰ���ĸ˳������������
 * ���ǣ���������������ڻ��������㷨�У��ܹ�����Ч���������ݷ�Χ�ܴ�����顣
 * ͨ�׵���⣬������10�����䲻ͬ���ˣ�ͳ�Ƴ���8���˵������AС����A����������ڵ�9λ��
 * ������������Եõ�����ÿ���˵�λ�ã�Ҳ���ź����򡣵�Ȼ���������ظ�ʱ��Ҫ���⴦����֤�ȶ��ԣ���
 * �����Ϊʲô���Ҫ�������Ŀ�����飬�Լ���ÿ�����ֵ�ͳ�Ƽ�ȥ1��ԭ���㷨�Ĳ������£�
 * 1.�ҳ��������������������С��Ԫ��
 * 2.ͳ��������ÿ��ֵΪi��Ԫ�س��ֵĴ������������� C �ĵ� i ��
 * 3.�����еļ����ۼӣ���C�еĵ�һ��Ԫ�ؿ�ʼ��ÿһ���ǰһ����ӣ�
 * 4.�������Ŀ�����飺��ÿ��Ԫ��i����������ĵ�C(i)�ÿ��һ��Ԫ�ؾͽ�C(i)��ȥ1

 */
public class CountingSort {
	public static void main(String[] argv) {
		int[] A = CountingSort.countingSort(new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 });
		pr.pr(A);
	}

	public static int[] countingSort(int[] A) {
		int[] B = new int[A.length];
		// ����A�е�����a'�У�0<=a' && a' < k����k=100
		int k = 100;
		countingSort(A, B, k);
		return B;
	}

	private static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k];
		// ����
		for (int j = 0; j < A.length; j++) {
			int a = A[j];
			C[a] += 1;
		}
		pr.pr(C);
		// �������
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		pr.pr(C);
		// ����
		for (int j = A.length - 1; j >= 0; j--) {
			int a = A[j];
			B[C[a] - 1] = a;
			C[a] -= 1;
		}
	}
}

// ���c����Ĵ�С���Ż����ļ�������
class CountSort {
	public static void main(String[] args) {
		// ���������
		int a[] = { 100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95 };
		int b[] = countSort(a);
		for (int i : b) {
			System.out.print(i + "  ");
		}
		System.out.println();
	}

	public static int[] countSort(int[] a) {
		int b[] = new int[a.length];
		int max = a[0], min = a[0];
		for (int i : a) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		// ����k�Ĵ�С��Ҫ����������У�Ԫ�ش�С�ļ�ֵ��+1
		int k = max - min + 1;
		int c[] = new int[k];
		for (int i = 0; i < a.length; ++i) {
			c[a[i] - min] += 1;// �Ż����ĵط�����С������c�Ĵ�С
		}
		for (int i = 1; i < c.length; ++i) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = a.length - 1; i >= 0; --i) {
			b[--c[a[i] - min]] = a[i];// ����ȡ�ķ�ʽȡ��c��Ԫ��
		}
		return b;
	}
}
