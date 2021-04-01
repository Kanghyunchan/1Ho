import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = input.nextInt();
		}

		int Q = input.nextInt();
		int[] B = new int[Q];
		for (int i = 0; i < Q; i++) {
			B[i] = input.nextInt();
		}
		for (int i = 0; i < Q; i++) {
			System.out.print(BinarySearch(B[i], array) + " ");
		}
	}

	public static int BinarySearch(int target, int[] array) {
		int low = 0;
		int high = array.length;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (array[mid] < target) {
				low = mid + 1;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else if (array[mid] == target) {
				break;
			}
		}
		if (low > high) {
			mid = -1;
		}
		return mid;
	}
}
