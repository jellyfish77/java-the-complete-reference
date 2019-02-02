package ch11.threads.ipc.producerconsumer.correct;

class PCFixed {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);

		System.out.println("Press Control-C to stop.");
	}
}