package Assignment9;

public class DeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String s = "Nikhil";
		final String g = "Vemula";
		Thread t1 = new Thread(){
			public void run() {
				while(true){
				synchronized (s) {
					System.out.println("Thread: 1 is using the String resource s.");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Thread: 1 waiting for resource g");
					}
					synchronized (g){
						System.out.println("Thread: 1 is using the String resource g and s.");
					}
				}
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
				synchronized (g) {
					System.out.println("Thread: 2 is using the String resource g.");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Thread2 waiting for resource s");
					}
				
				synchronized (s) {
					System.out.println("Thread: 2 is using the String resource g and s.");
				}
			}
				}
			}
		};
		
			t1.start();
			t2.start();
			
		}
		

	}


