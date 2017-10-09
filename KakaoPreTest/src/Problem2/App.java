package Problem2;

/*
 * �� 3ȸ�� ��ȸ�� �����Ǿ� �ְ�
 * ������ 0��~ 10������
 * Single(S) : ������ 1����
 * Double(D) : ������ 2����
 * Triple(T) : ������ 3����
 * 
 * ��Ÿ�� (*) : ��÷��, �ش� ������ ���� ������ 2��� ����, 2�� ��ø �� ���, ���� ������ 4��
 * ������ (#) : ��÷��, �ش� ���� ���̳ʽ�, ��Ÿ��� ��ø�� ��� �ش������� -2��
 * ��Ÿ��� �������� �����ϳ��� ������ �� �� �ְ� �������� ���� �� �� ����
 * 
 */

public class App {

	public static void main(String[] args) {
	
		long start, end;
		String[] strs = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"}; 
		
		System.out.println("!] INPUT : ScoreBonusOption. ex) 1S2D*3T");
		System.out.println("!] OUTPUT : Score Sum Value.");
		System.out.println();

		
		DartGame dg = new DartGame();
		
		for(int i=0; i<strs.length; i++) {
			start = System.currentTimeMillis();
			
			dg.runDartGame(strs[i]);
			
			end = System.currentTimeMillis();
			System.out.println("Run time : "+(end-start)+"ms.");
			System.out.println();
			
		}
		
	}

}
