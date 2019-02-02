package ch11.threads.ipc.producerconsumer.correct;

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;

		while (true) {
			q.put(i++);
		}
	}
}