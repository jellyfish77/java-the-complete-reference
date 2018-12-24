package ch09.interfaces;

class TestIface2 {
	public static void main(String args[]) {
		// An interface reference variable [c] has knowledge only of the methods declared by its interface declaration.
		Callback c = new Client();
		
		AnotherClient ob = new AnotherClient();

		c.callback(42);

		c = ob; // c now refers to AnotherClient object
		c.callback(42);
	}
}
