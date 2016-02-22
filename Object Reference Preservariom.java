class Test
{
	String x = "hi";
	
	public String change ()
	{
		return x = "bye";
	}
}
public class ObjectReference {

	public static void main(String[] args) {
		Test mytest = new Test(); 
		Test yourtest = mytest; 
		yourtest=null; 
		 
		System.out.println(mytest.x); 
		// mytest ile yourtest object reference variable'ları ortak objecte (Test object) sahip, ancak
		// yourtest object reference null'a eşitlendi diye mytest.x in değeri değişmez
		System.out.println(yourtest); 
	
		System.out.println(mytest.change());
	// System.out.println(yourtest.x); // hata verir
		
	}
}