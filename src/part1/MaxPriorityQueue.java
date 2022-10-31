package part1;

// Priority queue implemented as a binary heap
public class MaxPriorityQueue<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;

	public MaxPriorityQueue(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key key) {
		pq[N++] = key;
	}

	public Key delMax() {
		int max = 0;
		for (int i = 1; i < N; i++)
			if (less(max, i))
				max = i;
		exch(max, N - 1);
		return pq[--N];
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
}