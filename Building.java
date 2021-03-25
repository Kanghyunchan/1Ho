import java.util.Scanner;

public class Building {
	public static void main(String[] args) {
//http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=607&sca=3020
//		N개의 빌딩이 있다. 
//
//		빌딩은 1번부터 N번까지 번호가 붙어 있다.
//
//		빌딩은 X좌표 상에 위치해 있으며 i번 빌딩은 i좌표 상에 위치해 있다. 그리고 각 빌딩은 Hi 만큼의 높이를 가지고 있다.
//
//		i < j 이고 Hi < Hj 일 경우, i번 빌딩에서 j번 빌딩을 볼 수 있다. 
//
//		각 빌딩에서 현재 빌딩의 좌표보다 오른쪽에 있는 빌딩을 보고자 할 때, 가장 가까이 보이는 빌딩이 어딘지 찾는 프로그램을 작성하라.

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int buliding[] = new int[N];

		for (int i = 0; i < N; i++) {
			buliding[i] = input.nextInt();
		}

		int H = 0;
		for (int i = 0; i < buliding.length; i++) {
			for (int j = i; j < buliding.length; j++) {
				if (buliding[i] < buliding[j]) {
					H = j;
					System.out.println(H + 1);
					break;
				}
			}
			if (H == 0)
				System.out.println("0");
			H = 0;
		}

	}
}
