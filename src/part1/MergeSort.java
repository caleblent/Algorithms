package part1;

// this code has been haphazardly spliced together like spaghetti
// it has not been subjected to unit or manual tests
// use at your own peril
public class MergeSort {

	final static int CUTOFF = 7; // adjust this as needed

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//	 assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
//	 assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	private static void merge2(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				aux[k] = a[j++];
			else if (j > hi)
				aux[k] = a[i++];
			else if (less(a[j], a[i]))
				aux[k] = a[j++];
			else
				aux[k] = a[i++];
		}
	}

	public static void sortBottomUp(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz)
			for (int lo = 0; lo < N - sz; lo += sz + sz)
				merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}

//	 assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	// this version of sort() cuts off at CUTOFF items
	private static void sort2(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			InsertionSort.sort(a, lo, hi);
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
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
