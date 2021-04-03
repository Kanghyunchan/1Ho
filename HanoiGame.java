import java.util.Scanner;

public class HanoiGame {
	static int[] hanoipan = new int[17];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		for (int i = 1; i <= N; i++) {
			hanoipan[i] = 1;
		}
		search(N, 3);
	}

	public static void search(int hanoi, int p) {
		if (hanoi > 0) {
			int prev = hanoipan[hanoi];
			int other = 6 - (prev + p);

			search(hanoi - 1, other);

			hanoipan[hanoi] = p;
			System.out.println(hanoi + " : " + prev + " -> " + hanoipan[hanoi]);

			search(hanoi - 1, p);
		}
	}
}
