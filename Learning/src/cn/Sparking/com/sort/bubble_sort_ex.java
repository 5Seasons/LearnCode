package cn.Sparking.com.sort;

public class bubble_sort_ex {
/*
 * ð������
 * ð�������㷨���������£�
 * 1.�Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * 2.��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ��ⲽ���������Ԫ�ػ�����������
 * 3.������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * 4.����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
 */
	
/*
  ���� ð������ ݔ�� һ��������Q��array ���L�Ȟ�length
    i �� 0 �� (length - 1)
        j �� 0 �� (length - 1 - i)
            ��� array[j] > array[j + 1]
                ���Q array[j] �� array[j + 1] ��ֵ
            ����Y��
        jޒȦ�Y��
    iޒȦ�Y��
�����Y��
 */
	
	public static void bubble_sort(int[] arr) {
		int i, j, temp, len = arr.length;
		int count = 0;
		for (i = 0; i < len - 1; i++){
//			ð��N-1�Ρ�
//			�����Ѿ�ð��ȥ�ˡ�
			for (j = 0; j < len - 1 - i; j++)
			{
//				��һλ��ǰһλС�ͽ��Q���Ѵ�ķŵ����档
//				��ľͻᵽ����档
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					pr("����"+ count++ +"��");
				}
			}
		pr("������"+arr[j]);
//		��һ�γ�ȥ����arr[j+1]
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
