import java.util.Scanner;

public class InterThread {
	public static void main(String[] args) throws InterruptedException {
		final Utility pc = new Utility();
		Scanner in = new Scanner(System.in);

		Thread Input = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.Input(in);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread Output = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.Output();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Input.start();
		Output.start();

		Input.join();
		Output.join();
	}

	public static class Utility {
		int s;
		public synchronized void Input(Scanner in) throws InterruptedException {
			synchronized (this) {
				System.out.print("Enter Range : ");
				s = in.nextInt();
				wait();

			}
		}

		public synchronized void Output() throws InterruptedException {

			for (int i = 0; i < s; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println(i);
				}
			}
			notify();

		}
	}
}