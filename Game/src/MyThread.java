import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThread implements Runnable {

	public MyThread() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
