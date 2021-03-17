import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int count = 0;

		while (!(count >= 1 && count <= 100)) {
			count = Integer.parseInt(input.nextLine());
		}

		int top = 0;
		int stack[] = new int[101];
		for (int i = count; i > 0; i--) {
			String comm = input.nextLine();
			int value = 0;

			if (comm.charAt(0) == 'i') {
				if (comm.length() > 2) {
					value = Integer.parseInt(String.valueOf(comm.charAt(2)));
					stack[top] = value;
					top++;
				} else {
					System.out.println("ERROR! : Argument not entered\n");
				}
			} else if (comm.charAt(0) == 'o') {
				if (top == 0) {
					System.out.println("empty");
				} else {
					top--;
					System.out.println(stack[top]);
					stack[top] = 0;
				}
			} else if (comm.charAt(0) == 'c') {
				System.out.println(top);
			} else {
				System.out.println("ERROR! : Non-existent Commands\n");
			}
		}

	}
}