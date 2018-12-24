package ch09.interfaces;


// The class Incomplete does not implement callback( ) and must be declared as abstract. 
// Any class that inherits Incomplete must implement callback( ) or be declared abstract itself.
abstract class Incomplete implements Callback {
	int a, b;

	void show() {
		System.out.println(a + " " + b);
	}
	// ...
}
