package Junit;

import java.util.Arrays;

public class assign1 {

	public assign1() {
	}

	public int[] sortArray(int [] number) {
		if(number == null) {
			return new 	int[0];
		}
		int [] sorted = number.clone();
		Arrays.sort(sorted);
		return sorted;
	}
	public int[] sortArrayDescending(int[] numbers) {
		if (numbers == null) {
			return new int[0];
		}
		int[] sorted = sortArray(numbers);
		int[] descending = new int[sorted.length];
		for (int i = 0; i < sorted.length; i++) {
			descending[i] = sorted[sorted.length - 1 - i];
		}
		return descending;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
