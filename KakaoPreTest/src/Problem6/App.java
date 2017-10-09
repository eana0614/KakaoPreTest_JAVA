package Problem6;

/*
 * 2x2 blocks delete (Block game)
 * INPUT : ���� ���� (m<=30), ��(2<=n) ��ġ���� board( n*m �迭, ��� ���Ҵ� A-Z ���)
 * OUTPUT : ������ ����� ����
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
