package Problem1;

public class App {

	/*
	 * 2개의 배열은 2개의 지도로 취급한다.
	 * 2개의 지도에서는 공백 또는 벽(#) 두 종류로 이루어 져 있다.
	 * 2개의 지도 어느 한 부분에라도 벽이 있으면 전체 지도에서 벽이 있는 것이다.
	 * 2개의 지도는 정수 배열로 암호화 되어 있다.
	 * 배열에 주어진 정수를 이진수로 N의 길이를 가지고 있는 이진수로 표현할 경우 1은 # 0은 공백이 된다.
	 * 2개의 배열을 해독하여 전체 지도를 공백과 #으로 구성된 무자열 배열로 출력
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
