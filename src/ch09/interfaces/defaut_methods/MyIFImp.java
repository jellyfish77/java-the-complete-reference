package ch09.interfaces.defaut_methods;

//Implement MyIF. 
class MyIFImp implements MyIF {
	// Only getNumber() defined by MyIF needs to be implemented.
	// getString() can be allowed to default.
	public int getNumber() {
		return 100;
	}
}
