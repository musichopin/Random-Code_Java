public class GenericMethodTest

{
  

private static int var;



public static void set_var(int a)
   {
        
var = a;
   
}


public static int get_var()
   {
        
return var;
   
}

   

public static void main( String args[] )
   {
        
System.out.println(get_var());



set_var(10);
        
System.out.println(get_var());


  
GenericMethodTest gMT = new GenericMethodTest();
        
System.out.println(gMT.get_var());
 // effect is global
        
gMT.set_var(20);
        
System.out.println(get_var());
 // effect is global
} 


}

/*
0
10
10
20
*/