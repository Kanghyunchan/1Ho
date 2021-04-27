import java.util.Scanner;

public class BookPageCnt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int bookAllPage = input.nextInt();
		int bookPage[] = new int[10];

		for (int i = 1; i < bookAllPage + 1; i++) {
			if (i > 9) {
				bookPage[i / 10]++;
				bookPage[i % 10]++;
			} else {
				bookPage[i]++;
			}
		}
		for (int i = 0; i < bookPage.length; i++) {
			System.out.print(bookPage[i] + " ");
		}
	}
}
