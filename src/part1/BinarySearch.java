package part1;

public class BinarySearch {

	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < a[mid]) {
				high = mid - 1;
			} else if (key > a[mid]) {
				low = mid - 1;
			} else
				return mid;
		}
		return -1;
	}

	// recursive
	public static int binarySearch(int[] a, int key, int low, int high) {
		// find median id
		int mid = low + (high - low) / 2;

		if (key == a[mid])
			return mid;

		if (key < a[mid]) {
			binarySearch(a, key, low, mid);
		} else if (key > a[mid]) {
			binarySearch(a, key, mid, high);
		}

		return -1;

	}

}
