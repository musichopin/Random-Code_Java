class Ideone
{
	public int a = 0;
	public static int c = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone x = new Ideone();
		Ideone y = new Ideone();
		
		Ideone t = new Ideone(); // gereksiz
		Ideone u = new Ideone(); // gereksiz
	
		int b = x.a = 5;
		System.out.println(b);
		System.out.println(y.a);
		
		int d = t.c = 10; // t.c -> gereksiz
		System.out.println(d); // statik variable'da deðiþim global olur
		System.out.println(c);
	}
}