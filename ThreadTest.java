import java.util.ArrayList;
import java.util.Random;

public class ThreadTest extends Thread {
	private static int index = 0;
	int id = -1;

	public ThreadTest(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(id + " 번 쓰레드 동작 중...");
		Random r = new Random(System.currentTimeMillis());
		try {
			long s = r.nextInt(3000);
			Thread.sleep(s);
			setIndex();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(id + "번 쓰레드 동작 종료...");
	}

	public synchronized static void setIndex() {
		index++;
	}

	public static void main(String[] args) {
		System.out.println("Start main method.");

		ArrayList<Thread> threadList = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			ThreadTest test = new ThreadTest(i);

			test.start();
			threadList.add(test);
		}

		for (int i = 0; i < threadList.size(); i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("current Index: " + index);
		System.out.println("End main method.");
	}
}
