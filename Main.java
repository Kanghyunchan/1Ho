import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputNum = input.nextInt();

		int[] num1 = new int[Divisor(inputNum)];
		int col = 0;
		for (int i = 1; i <= inputNum; i++) {
			if (inputNum % i == 0) {
				num1[col] = i;
				col++;
			}
		}

		inputNum = input.nextInt();
		int[] num2 = new int[Divisor(inputNum)];
		col = 0;
		for (int i = 1; i <= inputNum; i++) {
			if (inputNum % i == 0) {
				num2[col] = i;
				col++;
			}
		}
		for (int i = 0; i < num1.length; i++) {
			for (int j = 0; j < num2.length; j++) {
				if (num1[i] == num2[j])
					System.out.println(num1[i]);
			}
		}
	}

	static int Divisor(int inputValue) {
		int temp = 0;
		for (int i = 1; i <= inputValue; i++) {
			if (inputValue % i == 0) {
				temp++;
			}
		}
		return temp;
	}
}
