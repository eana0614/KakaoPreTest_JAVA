package Problem3;

public class Cache {

	private int cacheSize;
	private Element[] caches;
	private int cachesCount;

	private String[] cities;

	private int hit;
	private int miss;

	public Cache(int ca, String[] input) {
		this.cacheSize = ca;
		this.caches = new Element[cacheSize];
		this.cachesCount = 0;

		this.cities = input;

		this.hit = 0;
		this.miss = 0;
	}

	public void runLRUCache() {

		int hmTime = 0;

		System.out.print(" [ ");
		for (int i = 0; i < cities.length; i++) {
			System.out.print(cities[i] + " ");
		}

		changeCitiesCase();

		hmTime = addCities();

		System.out.println("] Cache runtime = " + hmTime);
	}

	private int addCities() {
		for (int i = 0; i < cities.length; i++) {
			if(cacheSize <= 0) {
				miss++;
			}else {
				if (isSameElement(cities[i])) {
					hit++;
					swapSameElement(cities[i], i);
				} else {
					miss++;
					if (isCachesFull()) {
						caches[cachesCount] = new Element(cities[i], i);
						cachesCount++;
					} else {
						int old = findOldElement();
						caches[old] = new Element(cities[i], i);
					}
				}
			}
		}

		return (hit * 1) + (miss * 5);
	}

	private int findOldElement() {
		int old = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;

		for (int i = 0; i < caches.length; i++) {
			if (old > caches[i].getTime()) {
				index = i;
				old = caches[i].getTime();
			}
		}

		return index;
	}

	private void swapSameElement(String string, int time) {
		int index;

		for (int i = 0; i < cachesCount; i++) {
			if (caches[i].getKey().equals(string)) {
				caches[i].setTime(time);
				break;
			}
		}
	}

	private boolean isSameElement(String city) {
		boolean find = false;

		for (int i = 0; i < cachesCount; i++) {
			if (caches[i].getKey().equals(city)) {
				find = true;
				break;
			}
		}

		return find;
	}

	private void changeCitiesCase() {

		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toLowerCase();
		}
	}

	private boolean isCachesFull() {
		return (cachesCount < cacheSize);
	}

}
