class baseClass {	
		public baseClass() {			
		}
}

public class subClass extends baseClass {

    public subClass() {
    }
    
    public static void main (String args[]) {
    	
    	// Creating a baseClass Array reference to point to subClass Array object - OK
    	baseClass baseClassArray [] = new subClass [5];
    	
    	// Assigning a baseClass Array element to subClass instance - OK
    	baseClassArray[0] = new subClass();
    	
    	// Assigning a baseClass Array element to baseClass instance 
    	// Run time exception - ArrayStoreException
    	    	
    	baseClassArray[1] = new baseClass();    	
    }
}