// Generic Class Version

public class GenericMethodTest<E> 
{
   

public void printArray( E[] inputArray )
   {
      
for ( E element : inputArray ){        
            
System.out.printf( "%s ", element );
         
}
         
System.out.println();
    
}

    

public static void main( String args[] )
    {
        
Integer[] intArray = { 1, 2, 3, 4, 5 };
        
Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        
Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        
        
GenericMethodTest<Integer> gm_int = new GenericMethodTest<Integer>();

GenericMethodTest<Double> gm_double = new GenericMethodTest<Double>();

GenericMethodTest<Character> gm_char = new GenericMethodTest<Character>();

        
        System.out.println( "Array integerArray contains:" );
        
gm_int.printArray( intArray  ); 
System.out.println( "\nArray doubleArray contains:" );
        
gm_double.printArray( doubleArray ); 
System.out.println( "\nArray characterArray contains:" );
        
gm_char.printArray( charArray );
}


}


// Generic Method Version


public class GenericMethodTest
{


public static < E > void printArray( E[] inputArray )
   {
         
for ( E element : inputArray ){        
            
System.out.printf( "%s ", element );
         
}
         
System.out.println();
    
}

    

public static void main( String args[] )
    {
              
Integer[] intArray = { 1, 2, 3, 4, 5 };
        
Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        
Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        
System.out.println( "Array integerArray contains:" );
        
printArray( intArray  ); 
System.out.println( "\nArray doubleArray contains:" );
        
printArray( doubleArray ); 
System.out.println( "\nArray characterArray contains:" );
        
printArray( charArray ); 
} 


}



/*
Array integerArray contains:
1 2 3 4 5 

Array doubleArray contains:
1.1 2.2 3.3 4.4 

Array characterArray contains:
H E L L O 
*/