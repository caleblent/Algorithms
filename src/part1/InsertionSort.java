package part1;

public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		Comparable[] partialCopy = new Comparable[hi - lo];
		for (int i = 0; i < partialCopy.length; i++) {
			partialCopy[i] = a[i+lo];
		}
		sort(partialCopy);
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}