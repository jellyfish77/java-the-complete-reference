package ch09.interfaces.defaut_methods;

//Use the default method. 
class DefaultMethodDemo {
	public static void main(String args[]) {

		MyIFImp obj = new MyIFImp();

		// Can call getNumber(), because it is explicitly
		// implemented by MyIFImp:
		System.out.println(obj.getNumber());

		// Can also call getString(), because of default
		// implementation:
		System.out.println(obj.getString());
		
		
		MyIF obj2 = new MyIFImp2();

		// Can call getNumber(), because it is explicitly
		// implemented by MyIFImp:
		System.out.println(obj2.getNumber());

		// Can also call getString(), because of default
		// implementation:
		System.out.println(obj2.getString());
	}
}
