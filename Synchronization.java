class CallMe{
	void call(String msg){
		System.out.print("["+msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Thread Interrupted"+e);
		}
		System.out.print("]");
	}
}
class Caller extends Thread{
	String msg;
	CallMe c;
	Caller(CallMe c, String msg){
		this.msg = msg;
		this.c = c;
	}
	public void run(){
		synchronized(c){
			c.call(msg);
		}
	}
}
class Synchronization{
	public static void main(String[] args){
		CallMe c = new CallMe();
		Thread t1 = new Thread(new Caller(c, "Hello"));
		Thread t2 = new Thread(new Caller(c, "Hi"));
		Thread t3 = new Thread(new Caller(c, "Test"));
		t1.start();
		t2.start();
		t3.start();
	}
}