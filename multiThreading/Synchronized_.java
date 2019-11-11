package multiThreading;
  
import java.text.SimpleDateFormat;
import java.util.Date;

/*synchronized表示当前线程，独占 对象 someObject
当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
someObject 又叫同步对象，所有的对象，都可以作为同步对象
为了达到同步的效果，必须使用同一个同步对象*/
public class Synchronized_ {
     
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
     
    public static void main(String[] args) {
        final Object someObject = new Object();
        Thread t1 = new Thread(){
            public void run(){
            	try {
            		System.out.println(now()+"线程1已经运行");
            		System.out.println(now()+this.getName()+" 试图占有对象:someObject");
            		synchronized(someObject) {
            			System.out.println(now()+this.getName()+" 占有对象:someObject");
            			Thread.sleep(1000);
            			System.out.println(now()+this.getName()+" 释放对象:someObject");
            		}
            	}catch(InterruptedException e) {
            		e.printStackTrace();
            	}
            }
        };
        t1.setName(" 线程1");
        t1.start();
	       
	    Thread t2=new Thread() {
	    	public void run() {
	    		try {
	    			System.out.println(now()+"线程2已经运行");
            		System.out.println(now()+this.getName()+" 试图占有对象:someObject");
            		synchronized(someObject) {
            			System.out.println(now()+this.getName()+" 占有对象:someObject");
            			Thread.sleep(1000);
            			System.out.println(now()+this.getName()+" 释放对象:someObject");
            		}
	    		}catch(InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    };
	    t2.setName(" 线程2");
	    t2.start();
	    
}
    
    
    
    
    
    
    
    
    
}