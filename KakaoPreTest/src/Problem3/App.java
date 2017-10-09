package Problem3;

/*
 * 캐시크기와 동시 이름 배열을 입력 받음
 * 캐시크기 : 정수, 0<= cachesize <=30
 * 도시 이름은 공백, 숫자, 특수문자가 없는 영문자로 구성 및 대소문자 구분 X 최대 20자로 구성
 * 출력 : 입력된 도시이름 배열을 순서대로 처리할 떄 총 실행 시간
 * 
 * cache hit 실행 시간 : 1
 * 			hit : Cache에 이미 존재 할 때
 * cache miss 실행 시간 : 5
 * 			miss : Cache에 존재하지 않을 때
 * 
 * 캐시 교체 알고리즘은 LRU 사용
 * 
 */

public class App {

	public static void main(String[] args) {
		
		long start, end;
		
		String[][] city = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
							{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
							{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
							{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
							{"Jeju", "Pangyo", "NewYork", "newyork"},
							{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
		int[] cacheSize = {3, 3, 2, 5, 2, 0};

		Cache cc;
		
		for(int i=0; i<city.length; i++) {
			start = System.currentTimeMillis();
			
			cc = new Cache(cacheSize[i], city[i]);
			cc.runLRUCache();
		
			end = System.currentTimeMillis();
			
			System.out.println(i+"번째 실행 시간 : "+ (end-start)+"ms.");
			System.out.println();
		}
	}

}
