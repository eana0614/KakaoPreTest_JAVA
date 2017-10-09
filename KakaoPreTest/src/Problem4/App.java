package Problem4;

/*
 * 일시 중단...
 * 
 * Shuttle Bus : 09:00부터 n회  t분 간격으로 역에 도착, 최대 m명의 승객이 탈 수 있음
 * 셔틀은 도착 했을떄 도착한 순간 대기열에 선 사람을 포함하여 대기 순서대로 태우고 출발 (9:00에 도착한 셔틀은 자리가 있을때 9시에 줄을 선 사람까지)
 * 
 * INPUT : 셔틀 운행 횟수 (n, 0<n<=10), 셔틀 운행 간격 (t, 0<t <=60), 한 셔틀에 탈 수 있는 사람 수 (m, 0<m<=45)
 *         사람들이 대기열에 도착하는 시간의 배열 (timetable)
 * OUTPUT : 셔틀을 타고 사무실로 갈 수 있는 도착 시간 중 제일 늦은 시각
 * 
 * 단, 모든 사람들은 잠을 자야 하므로 23:59에 집에 돌아감. 다음 날 셔틀 타는 일은 없음
 */

public class App {

	public static void main(String[] args) {
		
		long start, end;
		
		int[] n = {1, 2, 2, 1, 1, 10};
		int[] t = {1, 10, 1, 1, 1, 60};
		int[] m = {5, 2, 2, 5, 1, 45};
		
		String[][] timetable = {{"08:00", "08:01", "08:02", "08:03"},
								{"09:10", "09:09", "08:00"},
								{"09:00","09:00","09:00","09:00"},
								{"00:01", "00:01", "00:01", "00:01", "00:01"},
								{"23:59"},
								{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}};
		
		for(int i=0; i < n.length; i++) {
			start = System.currentTimeMillis();
			
			ShuttleBus sb = new ShuttleBus(n[i], t[i], m[i],timetable[i]);
			sb.runFindLateTime();
			
			end = System.currentTimeMillis();
			System.out.println("!] Run Time : "+(end-start)+"ms.");
			System.out.println();
		}
	}

}
