package ch11.threads.ipc.producerconsumer.incorrect;

class PC {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);

		System.out.println("Press Control-C to stop.");
	}
}