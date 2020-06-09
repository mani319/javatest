package com.manikanta.learning.JavaMemoryManagement.MemoryTest;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.start();
	}
	
	public void start() {
		String last = "Z";
		Container container = new Container();
		container.setInitial("C");
		another(container,last);
		System.out.print(container.getInitial());
	}
	
	public void another(Container initialHolder, String newInitial) {
		newInitial.toLowerCase(); // Just creates a new object in heap but doesn't change reference
		initialHolder.setInitial("B");
		Container initial2 = new Container();
		initialHolder=initial2; // Pointer of initialHolder started pointing to initial2 instead of container
		System.out.print(initialHolder.getInitial());
		System.out.print(newInitial);
	}
}
