// #1

public class Tut{
	
	// You declare constants with final. final makes a value that can't be changed.
	
	public final String TOMBSTONE = "Here Lies a Dead monster";
	
	// private fields are not visible outside of the class // field variable = instance variable = variables outside of methods
	// only an object (method(?)) can change the value inside of private variables
	
	private int health = 500; // print etmek için methoda gerek var
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	
	public String name = "Big Monster"; // as few public fields as possible unless a good reason
	
	// Accessor Methods (class methods) are used to set and get the values of private fields (başka class için)
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int decreaseHealth) // monster attacked
	{
		health = health - decreaseHealth;
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public void setHealth(double decreaseHealth)
	{
		int intDecreaseHealth = (int) decreaseHealth; // int'e convert edildi
		health = health - intDecreaseHealth; // health = intDecreaseHealth deseydi yeni health intDecreaseHealth'e eşit olacaktı 
		if (health < 0)
		{
			alive = false;
		}
	}
	
	public Tut(int health, int attack, int movement) //constructor named same as the class name
	{
		this.health = health; // this.health ile class health seçilmiş oldu
		this.attack = attack;
		this.movement = movement;
		
	}
	
	public Tut() // default constructor
	{
		
	}

	
	/* You can use the this keyword to call other constructors
	 * public LessonSeven(int newHealth)
	 * {
	 * 		health = newHealth;
	 * }
	 * 
	 * public LessonSeven(int newHealth, int newAttack)
	 * {
	 * 		this(newHealth); // Any calls to another constructor must occur on the first line
	 * 		attack = newAttack;
	 * }
	 * 
	 */
	
	public static void main(String[] args)  // this part doesn't show true syntax. it is just to show sth about private variables
	
	{
		Tut RandomName = new Tut(); // default constructor file called (yukarıdaki variable'lar static olsaydı constructor a gerek kalmayacaktı)
		
		
		RandomName.setHealth(40);
		
		/* RandomName.attack = 10; // "attack" static olsa idi (aynı class'da bulunduğumuzdan) attack = 10 olarak da tanımlanabilirdi
		
		* System.out.println(RandomName.attack); 
		
		* // "attack" private variable olmasına rağmen aynı class'da editlenebiliyor ve accessor method olmadan çağrılabiliyor
		
		*/
		
		
		System.out.println(RandomName.health); // variable private olmasına rağmen aynı class içerisinde doğrudan çağrılabiliyor 
		
	}

}


// #1.1

public class ex {
	
	public static void main(String[] args){
		
		// You create an object using the blueprint of that class as follows
		// className objectName = new className();
		
		Tut RandomName = new Tut(); // variable/field ile method/function static olsa idi constructora gerek kalmayacaktı
		
		// "RandomName" object name i Tut classında kullanılan ile aynı olabiliyor
		// Since the objects name is public you can change it directly
		
		RandomName.name = "Frank"; // name -> public ve editlenebilir. static olsa idi Tut.name olarak çağrılacaktı
		
		// You retrieve class field values by listing the objectName.fieldName
		// You execute class methods by listing objectName.methodName() // paranteze dikkat
		
		// System.out.println(Random)
		//RandomName.health; -> health visible olmadığı için hata verir
		
		RandomName.setHealth(50); // static olsa idi Tut.setHealth() olarak çaprılabilirdi

		System.out.println(RandomName.name + " has an health value of " + RandomName.getHealth()); 
		
		// variable public olsa idi health çağrılabilir ve hatta editlenebilirdi. 
		
		// private olduğu ve farklı class'ta bulunduğumuz için accessor method'a/function'a (return eden method) ihtiyaç vardır
	
	}
}
