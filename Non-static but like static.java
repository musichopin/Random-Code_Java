public class Worker {
    private int count = 0;

    public synchronized void increment() {
         count++;
    }

    public static void main(String[] args) {
    	Worker x = new Worker();
    	x.runn();
    	x.run2(); // farkl� ref ile �a��r�lsa sonu� 100000 olurdu
    }

    public void runn() {
        for(int i = 0; i < 100000; i++) {
            increment(); 
        }
        System.out.println(count);
    }
    
    public void run2() {
        for(int i = 0; i < 100000; i++) {
            increment(); // count++ dense de sonu� 200000 olur
        }
        System.out.println(count);
    }
    
}
/*
100000
200000
*/