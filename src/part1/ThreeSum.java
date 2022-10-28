package part1;

public class ThreeSum {
	
	// Returns the number of sets of 3 integers in the array of ints passed to it
	// that adds up to the target (which is usually 0)
	public static int count(int[] a, int target) {
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; j < N; k++) {
					if (a[i] + a[j] + a[k] == target)
						count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
//		int[] a = In.readInts(args[0]);
//		Stopwatch stopwatch = new Stopwatch();
//		StdOut.println(count(a, 0));
//		double time = stopwatch.elapsedTime();
	}

}
