import java.util.Scanner;

public class Greedy {
	public static void main(String[] args) {
//		[문제]
//
//				1, 2, 4, 8, 16그램 추가 a, b, c, d, e개 주어진다.
//
//				N그램 짜리 물건을 측정하는데 추의 개수를 최소로 사용하고자 한다.
//
//				사용된 최소 개수의 추를 출력하는 프로그램을 작성하시오.
//		1, 2, 4, 8, 16그램 추 a, b, c, d, e개와 N이 공백으로 구분되어 입력된다.(1 <= N <= 200)
		Scanner input = new Scanner(System.in);

		String sizeSave[] = input.nextLine().split(" ");

		int chuCase[] = new int[5];
		int weight = Integer.parseInt(sizeSave[5]);

		for (int i = 0; i < 5; i++) {
			chuCase[i] = Integer.parseInt(sizeSave[i]);
		}
		int minimumNumber = 0;

		while (weight > 0) {
			// System.out.println("실행");
			if (16 <= weight && chuCase[4] > 0) {
				weight -= 16;
				chuCase[4]--;
				minimumNumber++;
				// System.out.println(weight + " 16뺌" + chuCase[4] + "남음");
			} else if (8 <= weight && chuCase[3] > 0) {
				weight -= 8;
				chuCase[3]--;
				minimumNumber++;
				// System.out.println(weight + " 8뺌" + chuCase[3] + "남음");
			} else if (4 <= weight && chuCase[2] > 0) {
				weight -= 4;
				chuCase[2]--;
				minimumNumber++;
				// System.out.println(weight + " 4뺌" + chuCase[2] + "남음");
			} else if (2 <= weight && chuCase[1] > 0) {
				weight -= 2;
				chuCase[1]--;
				minimumNumber++;
				// System.out.println(weight + " 2뺌" + chuCase[1] + "남음");
			} else if (1 <= weight && chuCase[0] > 0) {
				weight -= 1;
				chuCase[0]--;
				minimumNumber++;
				// System.out.println(weight + " 1뺌" + chuCase[0] + "남음");
			} else {
				break;
			}
		}
		System.out.println((weight <= 0) ? minimumNumber : "impossible");
	}
}