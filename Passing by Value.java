// string (immutable) veya primitive olsaydý etkisi olmazdý, object ve array'de var
// (java passes by copy/value/copy of the value (referansýn kopyasý bu örnekte), not reference)

public class HelloWorld
{
  public static void main(String[] args)
  {
    // 1: easy but cheesy
    // prints 30 30 20 20
    // changes made to members of passed class instances 
    // are visible to val1
    
   	OtherClass val1 = new OtherClass("10");
    OtherClass i = val1; 
    OtherClass val2 = new OtherClass("20");
    OtherClass j = val2; 

    val1.message = "30";
    System.out.println("1st:\n"+val1); 
    System.out.println(i);
    System.out.println(val2);
    System.out.println(j);

    // 2: nice
    // prints 30 20 20 30
    // changes made to passed value are not visible to 
    // either val1 or val2
    
	OtherClass k = i;
    i = j;
    j = k;
    
    System.out.println("2nd:\n"+val1); 
    System.out.println(i);
    System.out.println(val2);
    System.out.println(j);
    
    // 3: nice but long
    // prints 30 30 20 20
    
    ThirdClass third_ref1 = new ThirdClass();
	third_ref1.setter(val1); 
    ThirdClass third_ref2 = new ThirdClass();
    third_ref2.setter(val2);
    
    System.out.println("3rd:\n"+val1); 
    System.out.println(third_ref1.getter()); 
    System.out.println(val2);
    System.out.println(third_ref2.getter());
    
    // 4: nice and shortcut
    // prints 30 30 20 20
    
    // prints 0:
    // ForthClass forth_reff = new ForthClass(val1, val2);
	// System.out.println(forth_reff.input1); 
    
    ForthClass forth_ref = new ForthClass(val1, val2);
    System.out.println("4th:\n"+val1); 
    System.out.println(forth_ref.getter1()); 
    System.out.println(val2);
    System.out.println(forth_ref.getter2());
    
    // 5: odd but works (variables become global being static)
    // prints 30 20 20 30
    
    // changes are global for every class for being static
    // thus newly created variables can override
    // as well as accessing

    FifthClass.fifthClass_setter(val1, val2);
    System.out.println("5th:\n"+val1); 
    System.out.println(FifthClass.getter1()); 
    System.out.println(val2);
    System.out.println(FifthClass.getter2());
    
   	// 6: nice and cool 
    // prints 30 20 20 30

    // changes are non-visible outside SixthClass
    
    SixthClass sixth_ref = new SixthClass(val1, val2);
    System.out.println("6th:\n"+val1); 
    System.out.println(sixth_ref.getter1()); 
    System.out.println(val2);
    System.out.println(sixth_ref.getter2());
    
    // 7: nice and cool 
    // prints 20 20 30 30

    // changes become visible outside SeventhClass
    
    SeventhClass seventh_ref = new SeventhClass(val1, val2);
    System.out.println("7th:\n"+val1); 
    System.out.println(seventh_ref.getter1()); 
    System.out.println(val2);
    System.out.println(seventh_ref.getter2());

  }
}


public class OtherClass
{
  public String message;
  
  public OtherClass(String input)
  {
    message = input;
  }
  
  public String getMessage()
  {
  	return message;
  }
  
  public void setMessage(String message)
  {
  	this.message = message;
  }
    
  public String toString()
  {
    return message;
  }
  
}


public class ThirdClass
{
  OtherClass input;
  
  void setter(OtherClass input)
  {
    this.input = input;
  }
  
  OtherClass getter()
  {
  	return input;
  }
  
}

public class ForthClass
{
  OtherClass input1;
  OtherClass input2;
  
  ForthClass(OtherClass input1, OtherClass input2)
  {
    this.input1 = input1;
    this.input2 = input2;
  }
  
  OtherClass getter1()
  {
  	return input1;
  }
  
  OtherClass getter2()
  {
  	return input2;
  }

}


public class FifthClass
{
  static OtherClass input1;
  static OtherClass input2;
  
  static void fifthClass_setter(OtherClass input_1, OtherClass input_2)
  {
    OtherClass k = input_1;
    input1 = input_2;
    input2 = k;
  }
  
  static OtherClass getter1()
  {
  	return input1;
  }
  
  static OtherClass getter2()
  {
  	return input2;
  }

}

public class SixthClass
{
  
  OtherClass input1;
  OtherClass input2;

  
  SixthClass(OtherClass input1, OtherClass input2)
  {
    OtherClass k = input1;
    this.input1 = input2;
    this.input2 = k;
  }
  
  OtherClass getter1()
  {
  	return input1;
  }
  
  OtherClass getter2()
  {
  	return input2;
  }

}

public class SeventhClass
{
  
  OtherClass input1;
  OtherClass input2;

  
  SeventhClass(OtherClass input1, OtherClass input2)
  {
    String k = input1.getMessage();
    input1.setMessage(input2.getMessage());
    this.input1=input1;
    input2.setMessage(k);
    this.input2=input2;
  }
  
  OtherClass getter1()
  {
  	return input1;
  }
  
  OtherClass getter2()
  {
  	return input2;
  }

}





/*
1st:
30
30
20
20
2nd:
30
20
20
30
3rd:
30
30
20
20
4th:
30
30
20
20
5th:
30
20
20
30
6th:
30
20
20
30
7th:
20
20
30
30
*/