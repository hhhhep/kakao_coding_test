public class Main {

	public static void main(String[] args) {
		
		secretMap(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
		
		dart("1D#2S*3S");
		
		cache(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
		
	}
	
	// Bitwise Operation
	public static void secretMap(int n, int[] arr1, int[] arr2) {
		int[] result = new int[n];
		String[] resultBinary = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = arr1[i] | arr2[i];
			resultBinary[i] = Integer.toBinaryString(result[i]);
			System.out.println(resultBinary[i].replaceAll("1", "#").replaceAll("0", " "));
		}
	}
	
	// String Manipulation
	public static void dart(String scoresString) {
		
		String[] scores = scoresString.split("(?<=\\D)(?=\\d)");
		
		double[] results = new double[3];
		
		for (int i = 0; i < scores.length; i++) {
			String[] score = scores[i].split("(?<=[SDT])|(?=[SDT])");
			double result = 0;
			
			if (score[1].equals("S")) {
				result = Math.pow(Integer.parseInt(score[0]), 1);
			} else if (score[1].equals("D")) {
				result = Math.pow(Integer.parseInt(score[0]), 2);
			} else if (score[1].equals("T")) {
				result = Math.pow(Integer.parseInt(score[0]), 3);
			}
			
			if (score.length == 3) {
				if (score[2].equals("*")) {
					if (i != 0) {
						results[i - 1] = results[i - 1] * 2;
					}
					result = result * 2;
				} else if (score[2].equals("#")) {
					result = -result;
				}
			}
			
			results[i] = result;
		}
		
		System.out.println(results[0] + results[1] + results[2]);
	}
	
	// LRU Cache
	public static void cache(int cacheSize, String[] cities) {
		int time = 0;
		LRUCache lru = new LRUCache(cacheSize);
		for (int i = 0; i < cities.length; i++) {
			String result = lru.get(cities[i]);
			if (result == null)
				time += 5;
			else
				time += 1;
			if (cacheSize != 0)
				lru.set(cities[i], cities[i] + " restaurant");
		}
		System.out.println(time);
	}
	
	// Number Check
	public static boolean isNumeric(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
		
	}
}