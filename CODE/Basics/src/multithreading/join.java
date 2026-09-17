package multithreading;

class main extends Thread{
	public void run() {
		for(int i=1; i<=5; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Child Thread"  + i);
		}
	}
}

public class join {

	public join() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		main m1 = new main();
		main m2 = new main();
		Thread t1 = new Thread(m1, "First");
		Thread t2 = new Thread(m2, "Second");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		for(int i=1;i<=5;i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main Thread" + i);
		}

	}

}
