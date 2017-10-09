package Problem3;

/*
 * ĳ��ũ��� ���� �̸� �迭�� �Է� ����
 * ĳ��ũ�� : ����, 0<= cachesize <=30
 * ���� �̸��� ����, ����, Ư�����ڰ� ���� �����ڷ� ���� �� ��ҹ��� ���� X �ִ� 20�ڷ� ����
 * ��� : �Էµ� �����̸� �迭�� ������� ó���� �� �� ���� �ð�
 * 
 * cache hit ���� �ð� : 1
 * 			hit : Cache�� �̹� ���� �� ��
 * cache miss ���� �ð� : 5
 * 			miss : Cache�� �������� ���� ��
 * 
 * ĳ�� ��ü �˰����� LRU ���
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
			
			System.out.println(i+"��° ���� �ð� : "+ (end-start)+"ms.");
			System.out.println();
		}
	}

}
