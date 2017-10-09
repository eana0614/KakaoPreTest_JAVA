package Problem6;

/*
 * 2x2 blocks delete (Block game)
 * INPUT : 판의 높이 (m<=30), 폭(2<=n) 배치정보 board( n*m 배열, 블록 원소는 A-Z 사용)
 * OUTPUT : 지워진 블록의 갯수
 * 
 */

public class App {

	public static void main(String[] args) {
		
		long start, end;
		
		String[][] board = {{"CCBDE", "AAADE", "AAABF", "CCBBF"},
							{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}};
		int[] m = {4, 6};
		int[] n = {5, 6};
		
		for(int i=0; i<m.length; i++) {
			
			start = System.currentTimeMillis();
			
			FriendBlock fb = new FriendBlock(m[i], n[i], board[i]);
			fb.runRemoveBlock();
			
			end = System.currentTimeMillis();
			
			System.out.println("Run Time : "+(end-start)+"ms. \n");
			
		}

	}


}
