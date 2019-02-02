package ch11.threads.unsynchronized;

//This program is not synchronized.
class Callme {
	//void call(String msg) {
	synchronized void call(String msg) { // make this method synchronized - can only be called by one thread at a time
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}
