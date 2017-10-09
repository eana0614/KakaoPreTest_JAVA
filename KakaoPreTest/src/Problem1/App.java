package Problem1;

public class App {

	/*
	 * 2���� �迭�� 2���� ������ ����Ѵ�.
	 * 2���� ���������� ���� �Ǵ� ��(#) �� ������ �̷�� �� �ִ�.
	 * 2���� ���� ��� �� �κп��� ���� ������ ��ü �������� ���� �ִ� ���̴�.
	 * 2���� ������ ���� �迭�� ��ȣȭ �Ǿ� �ִ�.
	 * �迭�� �־��� ������ �������� N�� ���̸� ������ �ִ� �������� ǥ���� ��� 1�� # 0�� ������ �ȴ�.
	 * 2���� �迭�� �ص��Ͽ� ��ü ������ ����� #���� ������ ���ڿ� �迭�� ���
	 */
	
	public static void main(String[] args) {

		long start, end;
		
		int n1 = 5;
		int n2 = 6;
		
		int[] array1 = {9, 20, 28, 18, 11};
		int[] array2 = {30, 1, 21, 17, 28};
		int[] array3 = {46, 33, 33, 22, 31, 50};
		int[] array4 = {27, 56, 19, 14, 14, 10};
		
		System.out.println("!] Secret map");
		System.out.println("!] INPUT = N, Array1, Array2 -------------------------");
		System.out.println("!] N = map size, 1<= N <= 16");
		System.out.println("!] Array1 and Array2 size is N * N");
		System.out.println("!] OUTPUT : decoding secret map using Blank and # ----");
		
		
		start = System.currentTimeMillis();
		
		SecretMap sm1 = new SecretMap(n1, array1, array2);
		sm1.decodingMap();
		
		end = System.currentTimeMillis();
		
		System.out.println("!] Run Time : "+(end - start)+"ms");
		
		
		start = System.currentTimeMillis();
		
		SecretMap sm2 = new SecretMap(n2, array3, array4);
		sm2.decodingMap();
		
		end = System.currentTimeMillis();
		
		System.out.println("!] Run Time : "+(end - start)+"ms");
		
		

	}

}
