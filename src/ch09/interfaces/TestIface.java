package ch09.interfaces;

class TestIface {
	public static void main(String args[]) {
		Callback c = new Client();
		c.callback(42);
	}
}
