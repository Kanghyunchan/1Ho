import java.util.Scanner;

public class Main {
	public static int[] stack = new int[101]; // Stack Storage space
	public static int num = 0; //Element Count

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int comCnt = Integer.parseInt(input.nextLine()); //How many times are you going to execute the command?

		for (int i = comCnt; i > 0; i--) {
			String command = input.nextLine(); //What command would you like to give?

			switch (command.charAt(0)) {
			case 'i': //If the command is i
				Main.push(Integer.parseInt(String.valueOf(command.charAt(2))));
				break;
				
			case 'o': //If the command is o
				System.out.println(Main.pop());
				break;
				
			case 'c': //If the command is c
				System.out.println(Main.size());
				break;
			}
		}
	}

	public static int size() { //How much is the stack being used?
		return num;
	}

	public static int top() { //Last stored element

		return stack[num];
	}

	public static void push(int data) { //Put the data in the stack.
		stack[num] = data;
		num++;
	}

	public static String pop() { //Removes data from the stack and outputs it.
		int topNum;
		if (num == 0) { //Output empty if there is nothing to remove from the stack
			return empty();
		} else {
			num--;
			topNum = stack[num];
			stack[num] = 0;
			return String.valueOf(topNum);
		}
	}

	public static String empty() {
		if (num == 0) {
			return "empty";
		} else {
			return null;
		}
	}
}