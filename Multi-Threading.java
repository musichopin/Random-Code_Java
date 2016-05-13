
public class Worker {
    private int count = 0;
    
    public synchronized void increment() {
    	// only 1 thread can acquire the lock at a time for the Worker object
    	// 2nd thread would have to wait to use the count variable
        count++;
    }
    
    public static void main(String[] args) {
    	Worker work = new Worker();
    	work.run();
    }
    
    public void run() { // aþaðýdaki run metodundan farklý
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++) {
                	System.out.println("1");
                    increment();
                }
            }
        });
        thread1.start(); // run method has been activated
        try {
			thread1.join(); // thread1'in bitmesi saðlanýr
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++) { // i (storing) = i (reading) + 1 (incrementing)
                	System.out.println("2");
                    increment();
                }
            }
        });
        thread2.start();
        
        try {
            thread1.join(); 
            thread2.join();
            // we call join method
            // in order to pause the execution of main thread 
            // until thread1 and thread2 are finished 
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Count is: " + count);
    }
}
/*
Count is: 200000
*/