// #1
public class java {
	double x = 1.0;
	public void first() { 
		int x = 4; 
		System.out.println(x);
		System.out.println(this.x);
		x = 6;
		System.out.println(x);
		System.out.println(this.x);
	}
	public void second() { 
		x = 4; 
		System.out.println("\n" + x);
		System.out.println(this.x);
		int x = 6;
		System.out.println(x);
		System.out.println(this.x);
	}
	public static void main(String[] args) {
		java first = new java();
		first.first();
		first.second();
	}
}

// #2

public class java {
	double x = 1.0;
	public void first(int x) { 
		// field variable and local variable can share the same name even if their scope overlaps
		int x1 = 4; // 2 local variables cannot have the same name if their scope overlaps
		System.out.println(x1);
		this.x = x1;
		System.out.println(x);
		System.out.println(this.x);
	}
	public static void main(String[] args) {
		java first = new java();
		first.first(2);
	}
}

// #3
public class java {
	double x = 1.0;
	public void first() { // method static olsa idi this kw kullanılamazdı
		x=0.5;
		System.out.println("1st: " + x);
		System.out.println("2nd: " + this.x);
	}
	public static void main(String[] args) {
		java first = new java();
		first.first();
		System.out.println(first.x);
	}
}

// #4

public class java {
	double x = 1.0;

	public void first() { 
		double x = 0.5; // double dendiği için local variable olan x field variable ı override etmez
		System.out.println("1st: " + x);
		System.out.println("2nd: " + this.x);
		for (x ++; x < 5; x++) { // 2 local variable kesişemeyeceğinden "int x ++" denmedi. 
			System.out.println("loop: " + x);
		}
	}

	public static void main(String[] args) {
		java first = new java();
		first.first();
		System.out.println("last:" + first.x);

	}

}
}

// #5

public class java {
	int x = 1;
	int y;
	public void second() { 
		System.out.println("last: " + y); // default value olan 0 olarak print edilir
	}
	public void first(int y) { 
		// parameter variable int olarak belirtilmek zorunda olduğu için field variable'ı override etmez
		System.out.println("first: " + y);
	}
	public static void main(String[] args) {
		java first = new java();
		first.first(5);
		System.out.println(first.y);
		java second = new java();
		second.second();
	}
}