public class GenericMethodTest
{
   

static int var;
   
   

public void set_var(int a)
   {
        
var = a;
   
}
   
   

public int get_var()
   {
        
return var;
   
}

   

public static void main( String args[] )
   {
        

System.out.println(var);
        
        

GenericMethodTest gMT0 = new GenericMethodTest();
        
gMT0.set_var(10);
        
System.out.println(gMT0.get_var());
        
        

GenericMethodTest gMT = new GenericMethodTest();
        
System.out.println(gMT.get_var());
        
        
gMT.set_var(20);
        

System.out.println(gMT0.get_var());
        
   
}


}