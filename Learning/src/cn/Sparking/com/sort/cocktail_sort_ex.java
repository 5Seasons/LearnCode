package cn.Sparking.com.sort;

//稳定排序
/*
 * 鸡尾酒排序，也就是定向冒泡排序，鸡尾酒搅拌排序，搅拌排序（也可以视作选择排序的一种变形），
 * 涟漪排序，来回排序or 快乐小时排序，是冒泡排序的一种变形。
 * 此算法与冒泡排序的不同处在于排序时是以双向在序列中进行排序。
*/
/*
 * 鸡尾酒排序等于是冒泡排序的轻微变形。不同的地方在于从低到高然后从高到低，而冒泡排序则仅从低到高去比较序列里的每个元素。
 * 他可以得到比冒泡排序稍微好一点的效能，原因是冒泡排序只从一个方向进行比对（由低到高），每次循环只移动一个项目。
 * 以序列(2,3,4,5,1)为例，鸡尾酒排序只需要访问一次序列就可以完成排序，但如果使用冒泡排序则需要四次。
 * 但是在乱数序列的状态下，鸡尾酒排序与冒泡排序的效率都很差劲。
*/
public class cocktail_sort_ex {
	/*
	 * copy from WIKI.
	 * 实际排序
	 */
	public static void cocktail_sort(int[] arr) {	
		System.out.print("刚开始的数组是");
		for(int i : arr){
			System.out.print(i+" ");
		}	
		System.out.println();
		int i, left = 0, right = arr.length - 1;
		int temp;
		int count=0;
//		Left是最小的数字的位置+1 right是最大的数字的位置-1.
		while (left < right) {
			for (i = left; i < right; i++){
				if (arr[i] > arr[i + 1]) {
//					大的放后面小的放前面。
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					pr("换第"+ count++ +"次。");
					pr("较大的是"+arr[i] + "，放到了"+i+"位上");
				}
				else{
					pr("正常的 不换。");
				}
			}
			right--;
			for (i = right; i > left; i--){
				if (arr[i - 1] > arr[i]) {
//					大的放后面小的放前面。
					temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					pr("换第"+ count++ +"次。");
					pr("较小的是"+arr[i] + "，放到了"+i+"位上");
				}
				else{
					pr("正常的 不换。");
				}
			}
			left++;
		}
	}
	
	public static void main(String args[]){
		int size = 20;
		int[] number = new int[size];
		for(int i = 0;i<size;i++)
			number[i]=(int)(Math.random()*100);
		cocktail_sort(number);
		for(int i : number){
			System.out.print(i+" ");
		}	
		
	}
	
	/*
	 * Just print info to console.
	 */
	private static void pr(Object a){
		System.out.println(a);
	}
}
