package cn.Sparking.com.sort;

//�ȶ�����
/*
 * ��β������Ҳ���Ƕ���ð�����򣬼�β�ƽ������򣬽�������Ҳ��������ѡ�������һ�ֱ��Σ���
 * ����������������or ����Сʱ������ð�������һ�ֱ��Ρ�
 * ���㷨��ð������Ĳ�ͬ����������ʱ����˫���������н�������
*/
/*
 * ��β�����������ð���������΢���Ρ���ͬ�ĵط����ڴӵ͵���Ȼ��Ӹߵ��ͣ���ð����������ӵ͵���ȥ�Ƚ��������ÿ��Ԫ�ء�
 * �����Եõ���ð��������΢��һ���Ч�ܣ�ԭ����ð������ֻ��һ��������бȶԣ��ɵ͵��ߣ���ÿ��ѭ��ֻ�ƶ�һ����Ŀ��
 * ������(2,3,4,5,1)Ϊ������β������ֻ��Ҫ����һ�����оͿ���������򣬵����ʹ��ð����������Ҫ�ĴΡ�
 * �������������е�״̬�£���β��������ð�������Ч�ʶ��ܲ��
*/
public class cocktail_sort_ex {
	/*
	 * copy from WIKI.
	 * ʵ������
	 */
	public static void cocktail_sort(int[] arr) {	
		System.out.print("�տ�ʼ��������");
		for(int i : arr){
			System.out.print(i+" ");
		}	
		System.out.println();
		int i, left = 0, right = arr.length - 1;
		int temp;
		int count=0;
//		Left����С�����ֵ�λ��+1 right���������ֵ�λ��-1.
		while (left < right) {
			for (i = left; i < right; i++){
				if (arr[i] > arr[i + 1]) {
//					��ķź���С�ķ�ǰ�档
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					pr("����"+ count++ +"�Ρ�");
					pr("�ϴ����"+arr[i] + "���ŵ���"+i+"λ��");
				}
				else{
					pr("������ ������");
				}
			}
			right--;
			for (i = right; i > left; i--){
				if (arr[i - 1] > arr[i]) {
//					��ķź���С�ķ�ǰ�档
					temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					pr("����"+ count++ +"�Ρ�");
					pr("��С����"+arr[i] + "���ŵ���"+i+"λ��");
				}
				else{
					pr("������ ������");
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
