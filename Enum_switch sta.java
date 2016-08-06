public class CrunchifyEnumExample {
 
	public enum Company {
		EBAY, PAYPAL, GOOGLE, YAHOO, ATT
	}
 
	Company cName;
 
	public Lesson27(Company cName) {
		System.out.println(cName);
		this.cName = cName;
	}
 
	public void companyDetails() {
		switch (cName) {
		case EBAY:
			System.out.println("Biggest Market Place in the World.");
			break;
 
		case PAYPAL:
			System.out.println("Simplest way to manage Money.");
			break;
 
		case GOOGLE:
		case YAHOO:
			System.out.println("1st Web 2.0 Company.");
			break;
 
		default:
			System.out.println("Google - biggest search giant.. ATT - my carrier provider..");
			break;
		}
	}
 
	public static void main(String[] args) {
		Lesson27 ebay = new Lesson27(Company.EBAY);
		ebay.companyDetails();
		Lesson27 paypal = new Lesson27(Company.PAYPAL);
		paypal.companyDetails();
		Lesson27 google = new Lesson27(Company.GOOGLE);
		google.companyDetails();
		Lesson27 yahoo = new Lesson27(Company.YAHOO);
		yahoo.companyDetails();
		Lesson27 att = new Lesson27(Company.ATT);
		att.companyDetails();
	}
}

/*
EBAY
Biggest Market Place in the World.
PAYPAL
Simplest way to manage Money.
GOOGLE
1st Web 2.0 Company.
YAHOO
1st Web 2.0 Company.
ATT
Google - biggest search giant.. ATT - my carrier provider..
*/