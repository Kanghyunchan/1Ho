import java.util.Scanner;

public class List {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int listCase[][] = new int[5][];

		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번 째 열의 사이즈를 적어주세요 : ");
			int listSize = input.nextInt();
			listCase[i] = new int[listSize];

			for (int j = 0; j < listCase[i].length; j++) {
				System.out.print(i + 1 + "번 째 열의 " + (j + 1) + "번 째에 들어갈 숫자를 써주세요 : \n");
				int number = input.nextInt();
				listCase[i][j] = number;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < listCase[i].length; j++) {
				System.out.print(listCase[i][j] + " ");
			}
			System.out.println();
		}
	}
}
