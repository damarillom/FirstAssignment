/**
 * 
 */
package org.escoladeltreball.firstassignment;

/**
 * @author Pep Méndez
 *
 */
public final class ReviewImpl implements Review {
	
	private int frequency(int[] values, int n) {
		int counter = 0;
		for (int value : values) {
			if (n == value) {
				counter++;
			}
		}
		return counter;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.escoladeltreball.firstassignment.Utils#frequencyPercentage(int[],
	 * int)
	 */
	@Override
	public double frequencyPercentage(int[] values, int n) {
		return values.length == 0 ? 0 : ((double) frequency(values, n)) / values.length * 100;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.escoladeltreball.firstassignment.Utils#merge(int[], int)
	 */
	@Override
	public int[] merge(int[] values, int n) {
		int[] merge = new int[values.length + 1];
		int i = 0;
		while (i < values.length && values[i] <= n ) {
			merge[i] = values[i];
			i++;
		}
		merge[i] = n;
		for (i = i + 1; i < merge.length; i++) {
			merge[i] = values[i-1];
		}
		return merge;
	}

	/*
	 * This method returns an integer matrix with row 0 holding even numbers and
	 * row 1 holding odd numbers.
	 * 
	 * NOTE: Don't waste space!!!
	 */
	@Override
	public int[][] split(int[] values) {
		int[][] split = new int[2][];
		int evenCounter = 0;
		int oddCounter = 0;
		int auxEven = 0;
		int auxOdd = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i]%2 == 0) {
				evenCounter++;
			} else {
				oddCounter++;
			}
		}
		split[0] = new int[evenCounter];
		split[1] = new int[oddCounter];
		for (int i = 0; i < values.length; i++) {
			if (values[i]%2 == 0) {
				split[0][auxEven] = values[i];
				auxEven++;
			} else {
				split[1][auxOdd] = values[i];
				auxOdd++;
			}
		}
		return split;
	}

}
