package cn.Sparking.com.sort;

/**
 * Created by g on 2017/3/13.
 */
public class heap_sort_ex {
    private void print(int a[], int n) {
        for (int j = 0; j < n; j++) {
            System.out.print(a[j]);
        }
        System.out.println();
    }
    /**
     * ��֪H[s��m]����H[s] �������ѵĶ���
     * ����H[s],ʹ���Ϊ�󶥶�.�����Ե�s�����Ϊ��������ɸѡ,
     * @Param H�Ǵ������Ķ�����
     * @Param s�Ǵ�����������Ԫ�ص�λ��
     * @Param length������ĳ���
     */
    private void  HeapAdjust(int H[], int s, int length)
    {
        int tmp = H[s];
        int child = 2 * s + 1; //���ӽ���λ�á�(i+1 Ϊ��ǰ���������Һ��ӽ���λ��)
        while (child < length) {
            if (child + 1 < length && H[child] < H[child + 1]) { // ����Һ��Ӵ�������(�ҵ��ȵ�ǰ����������ĺ��ӽ��)
                ++child;
            }
            if (H[s] < H[child]) {  // ����ϴ���ӽ����ڸ����
                H[s] = H[child]; // ��ô�ѽϴ���ӽ�������ƶ����滻���ĸ����
                s = child;       // ��������s ,������������һ������λ��
                child = 2 * s + 1;
            } else {            // �����ǰ�������������������Һ��ӣ�����Ҫ������ֱ���˳�
                break;
            }
            H[s] = tmp;         // ��ǰ�������Ľ��ŵ������ĺ��ӽ��λ����
        }
        print(H, length);
    }

    /**
     * ��ʼ�ѽ��е���
     * ��H[0..length-1]���ɶ�
     * ������֮���һ��Ԫ�������е���С��Ԫ��
     */
    private void  BuildingHeap(int H[], int length)

    {
        //���һ���к��ӵĽڵ��λ�� i=  (length -1) / 2
        for (int i = (length - 1) / 2; i >= 0; --i)
            HeapAdjust(H, i, length);
    }

    /**
     * �������㷨
     */
    private void HeapSort(int H[], int length){
        //��ʼ��
        BuildingHeap(H, length);
        //�����һ��Ԫ�ؿ�ʼ�����н��е���
        for (int i = length - 1; i > 0; --i) {
            //�����Ѷ�Ԫ��H[0]�Ͷ������һ��Ԫ��
            int temp = H[i];
            H[i] = H[0];
            H[0] = temp;
            //ÿ�ν����Ѷ�Ԫ�غͶ������һ��Ԫ��֮�󣬶�Ҫ�Զѽ��е���
            HeapAdjust(H, 0, i);
        }
    }
    public static void main(String args[]) {
        heap_sort_ex hp = new heap_sort_ex();
        int[] H ={3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        System.out.print("��ʼֵ:");
        hp.print(H, 10);
        hp.HeapSort(H,10);
        //selectSort(a, 8);
        System.out.print("���:");
        hp.print(H, 10);
    }
}
