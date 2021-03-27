package algorithms;

class A {
	
	public void printName(A a) {
		System.out.println("A");
	}
	
	public void print() {
		System.out.println("AA");
	}
}

class B extends A {
	public void printName(B b) {
		System.out.println("B");
	}
	
	public void print() {
		System.out.println("BB");
	}
}

public class ExtendsTest {

	public static void main(String[] args) {
		A a = new B();
		B b = new B();
		
		a.print();
		b.print();
		
		a.printName(b);
		b.printName(b);
	}

}
