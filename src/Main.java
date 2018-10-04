import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
//		secretMap(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
		
//		dart("1D#2S*3S");
		
//		cache(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
		
//		bus(1, 1, 5, new String[] {"08:00", "08:01", "08:02", "08:03"});
		bus(2, 10, 2, new String[] {"09:10", "09:09", "08:00"});
		
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
	
	// Bus
	public static void bus(int n, int t, int m, String[] timetable) {
		
		// 시작 시간, 배차 회수, 배찬 간격을 기준으로 버스들을 목록화  
		List<LocalTime> buses = new ArrayList<LocalTime>();
		LocalTime localTime = LocalTime.parse("09:00");
		for (int i = 0; i < n; i++) {
			buses.add(localTime);
			localTime = localTime.plusMinutes(t);
		}
		
		for (int i = 0; i < buses.size(); i++) {
			System.out.println(buses.get(i));
		}
		System.out.println("-------------------------");
		
		List<LocalTime> crews = new ArrayList<LocalTime>();
		for (int i = 0; i < timetable.length; i++) {
			crews.add(LocalTime.parse(timetable[i]));
		}
		crews.sort(Comparator.comparing(LocalTime::getHour).thenComparing(Comparator.comparing(LocalTime::getMinute)));
		for (int i = 0; i < crews.size(); i++) {
			System.out.println(crews.get(i));
		}
		
		System.out.println("-------------------------");
		
		
		
//		
//		마지막 버스를 구한다.
//		정원 - 남아있는 인원이 1 이상이면 해당 버스의 시간
//		정원 - 남아있는 인원이 1 미만이면?
//		남아있는 인원의 정렬
//		정원 - 1
//		나를 포함한 인원
			
		// 탑승
//		int myBus = 0;
//		boolean earlybird = false;
//		for (int i = 0; i < times.size(); i++) {
//			int capacity = m;
//			for (int j = 0; j < timetable.length; j++) {
//				if (timetable[j] != null && timetable[j] != "" && (times.get(i).isAfter(LocalTime.parse(timetable[j])) || times.get(i).equals(LocalTime.parse(timetable[j])))  && capacity != 0) {
//					timetable[j] = "";
//					capacity--;
//				}
//			}
//			myBus = i;
//			if (capacity == 1) {
//				;
//			}
//		}
//		
//		
//		System.out.println(times.get(myBus));
		
		
//		for (int i = 0; i < timetable.length; i++) {
//			System.out.println(timetable[i]);
//		}
		
	}
	
	// Number Check
	public static boolean isNumeric(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
		
	}
}