package multithreading;

class JavaAlive extends Thread{
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("is run() method alive " + Thread.currentThread().isAlive());
	}
}

public class isalive {

	public isalive() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JavaAlive e1 = new JavaAlive();
		System.out.println("Before starting thread " + e1.isAlive());
		e1.start();
		System.out.println("After Starting thread isAlive " + e1.isAlive());

	}

}
