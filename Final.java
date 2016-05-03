public class Main
{
    public static void main (String[] args)
    {
        Passenger x = new Passenger();
        System.out.println(x.freeBags);
        Passenger y = new Passenger();
        System.out.println(y.freeBags);
//        Passenger z = new Passenger(10); -> error
//        System.out.println(z.freeBags);

    }
}

    class Passenger {

        final int freeBags; // final ise setter olmaz
        // field initialization, constructor block veya constructor ile değer atanır

        {freeBags= 5;}

        public Passenger() {}

//        public Passenger(int i) {
//            this.freeBags = i;
//        }
    }