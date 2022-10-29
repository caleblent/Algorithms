package part1;

public class KnuthShuffle {
	public static void shuffle(Object[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// original: int r = StdRandom.uniform(i + 1);
			// modified: (see below)
			int r = (int) (Math.random() * (i + 1)); // I'm unsure if this is accurate
			exch(a, i, r);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}