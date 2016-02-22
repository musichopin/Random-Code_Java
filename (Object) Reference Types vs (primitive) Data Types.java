// #1 Data Types (String, int, char vs)

class Test
{
	String x = "hi"; // x is a reference that points to an object of type string
	// data types require little storage
	// so it is more efficient to store them directly in a variable
	String y = x; // x and y pointing to the different adresses
	public void change ()
	{
		x = "bye";
		System.out.println(x); // x değeri değişiyor
		System.out.println(y); // y sabit
	}
}

public class ObjectReference {

	public static void main(String[] args) {
		Test mytest = new Test(); 
		mytest.change();
		
	}
}

// #2 Object Reference Types (class -> object)

class Test
{
	String x = "hi"; 
	
	public void change ()
	{
		x = "bye";
	}
}

public class ObjectReference {

	public static void main(String[] args) {
		Test mytest = new Test(); // mytest variable’ı, object reference olarak isimlendirilir. mytest is a reference that points to an object of type Test
		// object reference'ın type ı class
		System.out.println (mytest); // object reference’ın hashcode’u vardır
		// myTest variable does not contain the object. it refers to the object
		// in java, a variable whose type is a class does not actually hold the object
// object reference holds the hashcode of an object
		// the object itself is stored elsewhere
		// objects (not equal to object reference types which are classes) can be large. hence it is more efficient to store only the memory location instead of the entire object (Test object) (memory “new” ile yaratılmıştı)
		// object (Test object) olarak class Test ile içindeki method ve variable'lar düşünülebilir mi (?)
		Test yourtest = mytest; // yourtest is pointing to the same adress where mytest is pointing
		System.out.println (yourtest); // hascode'lar ortak
		
		System.out.println(mytest.x);
		System.out.println(yourtest.x);
		
		yourtest.change(); // mytest ve yourtest aynı objecte referans yaptığından ikisi de değişir
		
		System.out.println(mytest.x);
		System.out.println(yourtest.x);
		
	}
}