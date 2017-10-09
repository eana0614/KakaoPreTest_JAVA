package Problem2;

/*
 * 총 3회의 기회로 구성되어 있고
 * 점수는 0점~ 10점까지
 * Single(S) : 점수의 1제곱
 * Double(D) : 점수의 2제곱
 * Triple(T) : 점수의 3제곱
 * 
 * 스타상 (*) : 당첨시, 해당 점수와 이전 점수를 2배로 만듬, 2번 중첩 될 경우, 이전 점수는 4배
 * 아차상 (#) : 당첨시, 해당 점수 마이너스, 스타상과 중첩될 경우 해당점수는 -2배
 * 스타상과 아차상은 둘중하나만 존재할 수 도 있고 존재하지 않을 수 도 있음
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
