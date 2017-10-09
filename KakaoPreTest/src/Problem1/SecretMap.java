package Problem1;

public class SecretMap {
	
	int n;
	int[] arrays1, arrays2;
	
	public SecretMap(int n1, int[] array1, int[] array2) {
		this.n = n1;
		this.arrays1 = array1;
		this.arrays2 = array2;
	}

	public void decodingMap() {
		
		String[] allMap = createMap(arrays1, arrays2, n);
		String[] mapDecode = changeArrayElement(allMap);
		
		printDecodeMap(mapDecode);
	}

	private void printDecodeMap(String[] mapDecode) {
		
		for(int i=0; i<mapDecode.length; i++) {
			System.out.println(mapDecode[i]);
		}
		
	}

	private String[] changeArrayElement(String[] allMap) {
		
		String[] result = new String[allMap.length];

		for(int i=0; i<allMap.length; i++) {
			result[i] = "";
			
			for(int j=0; j<allMap[i].length(); j++) {
				if(allMap[i].charAt(j) == '1') {
					result[i] = result[i] + "#";
				}else {
					result[i] = result[i]+ " ";
				}
			}
		}

		return result;
	}

	private String[] createMap(int[] arrays1, int[] arrays2, int n) {
		String[] orResult = new String[n];
		
		for(int i=0; i<n; i++) {
			orResult[i] = Integer.toBinaryString(arrays1[i] | arrays2[i]);
			
			int length = orResult.length;
			
			if(length < n) {
				
				for(int j=0; j<n-length; j++) {
					orResult[i] = "0"+orResult[i];
				}
				
			}
		}
		
		return orResult;
	}

}
