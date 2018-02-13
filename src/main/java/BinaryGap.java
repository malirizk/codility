package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryGap {

	public static int solution(int N) {
		// write your code in Java SE 8
		String bin = Integer.toBinaryString(N);

		System.out.println("After Convert to binary : " + bin);
//		110010100000000
		bin = bin.substring(0, bin.lastIndexOf("1") +1);
		System.out.println("After remove 0 from end : " + bin);

		if (!bin.contains("0")) {
			return 0;
		}

		Integer[] gabLenghts = new Integer[bin.length()/2];
		int gabLenghtsIndex = 0;
		int i = 0;
		String gabs = "";
		while (i + 1 < bin.length()) {
			if ('1' == bin.charAt(i) && '0' == bin.charAt(i + 1)) {
				gabs = bin.substring(i + 1, bin.indexOf("1", i + 1));
				if (gabs.length() > 0) {
					gabLenghts[gabLenghtsIndex] = gabs.length();
					gabLenghtsIndex++;
					i = bin.indexOf("1", i + 1);
				} else {
					break;
				}
			} else {
				i++;
			}
		}
		System.out.println("before sort array" + gabLenghts);
		if (gabLenghtsIndex > 0) {
			Arrays.sort(gabLenghts, new Comparator<Integer>() {
				@Override
				public int compare(Integer x, Integer y) {
					x = x == null ? 0 : x;
				    y = y == null ? 0 : y;
					return x - y;
				}
			});
			System.out.println("after sort array" + gabLenghts);
			return gabLenghts[gabLenghts.length - 1];
		}

		return 0;

	}
	
	public static void main(String[] args) {
		System.out.println(solution(1162));
	}
}
