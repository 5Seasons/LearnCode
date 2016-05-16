package cn.Sparking.com.sort;

import cn.Sparking.com.tool.pr;

//稳定排序
/*
 * 计数排序（Counting sort）是一种稳定的线性时间排序算法。
 * 计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。
 * 然后根据数组C来将A中的元素排到正确的位置。
 */
/*
 * 当输入的元素是n个0到k之间的整数时，它的运行时间是Θ(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。
 * 由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），
 * 这使得计数排序对于数据范围很大的数组，需要大量时间和内存。
 * 例如：计数排序是用来排序0到100之间的数字的最好的算法，但是它不适合按字母顺序排序人名。
 * 但是，计数排序可以用在基数排序算法中，能够更有效的排序数据范围很大的数组。
 * 通俗地理解，例如有10个年龄不同的人，统计出有8个人的年龄比A小，那A的年龄就排在第9位，
 * 用这个方法可以得到其他每个人的位置，也就排好了序。当然，年龄有重复时需要特殊处理（保证稳定性），
 * 这就是为什么最后要反向填充目标数组，以及将每个数字的统计减去1的原因。算法的步骤如下：
 * 1.找出待排序的数组中最大和最小的元素
 * 2.统计数组中每个值为i的元素出现的次数，存入数组 C 的第 i 项
 * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * 4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1

 */
public class CountingSort {
	public static void main(String[] argv) {
		int[] A = CountingSort.countingSort(new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 });
		pr.pr(A);
	}

	public static int[] countingSort(int[] A) {
		int[] B = new int[A.length];
		// 假设A中的数据a'有，0<=a' && a' < k并且k=100
		int k = 100;
		countingSort(A, B, k);
		return B;
	}

	private static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k];
		// 计数
		for (int j = 0; j < A.length; j++) {
			int a = A[j];
			C[a] += 1;
		}
		pr.pr(C);
		// 求计数和
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		pr.pr(C);
		// 整理
		for (int j = A.length - 1; j >= 0; j--) {
			int a = A[j];
			B[C[a] - 1] = a;
			C[a] -= 1;
		}
	}
}

// 针对c数组的大小，优化过的计数排序
class CountSort {
	public static void main(String[] args) {
		// 排序的数组
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
		// 这里k的大小是要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		int c[] = new int[k];
		for (int i = 0; i < a.length; ++i) {
			c[a[i] - min] += 1;// 优化过的地方，减小了数组c的大小
		}
		for (int i = 1; i < c.length; ++i) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = a.length - 1; i >= 0; --i) {
			b[--c[a[i] - min]] = a[i];// 按存取的方式取出c的元素
		}
		return b;
	}
}
