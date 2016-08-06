public class CrunchifyEnumExample {
 
	public enum Company {
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
		private int value;
 
		private Company(int value) {
			this.value = value;
		}
	}
 
//	You can specify values of enum constants at the creation time. 
//	MyEnum.values() returns an array of MyEnum’s values.
	public static void main(String[] args) {
		for (Company cName : Company.values()) {
			System.out.println("Company Value: " + cName.value + " - Comapny Name: " + cName);
		}
	}
}

/*
Company Value: 30 - Comapny Name: EBAY
Company Value: 10 - Comapny Name: PAYPAL
Company Value: 15 - Comapny Name: GOOGLE
Company Value: 20 - Comapny Name: YAHOO
Company Value: 25 - Comapny Name: ATT
*/