import java.util.Scanner;

public class JungolExam {
	// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=421&sca=3020 문제
	public static void main(String[] args) {
		int cowN[] = new int[80000];
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();

		for (int i = 0; i < num; i++) {
			cowN[i] = input.nextInt();
		}

		int cnt = 0;
		for (int i = 1; i < num; i++) {
			for (int j = i; j < num; j++) {
				if (cowN[i - 1] > cowN[j]) {
					System.out.println("++");
					cnt++;
				} else if (cowN[i - 1] <= cowN[j]) {
					System.out.println("break");
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
