package multiThreading;

//守护线程setDaemon
/*Every thread has a priority. Threads with higher priority are executed in preference to threads
 *  with lower priority. Each thread may or may not also be marked as a daemon. 
 *  When code running in some thread creates a new Thread object, the new thread has its priority initially 
 *  set equal to the priority of the creating thread,
 *  and is a daemon thread if and only if the creating thread is a daemon.
 *  When a Java Virtual Machine starts up, there is usually a single non-daemon thread 
 *  (which typically calls the method named main of some designated class). 
 *  The Java Virtual Machine continues to execute threads until either of the following occurs:
 * 1. The exit method of class Runtime has been called and the security manager has permitted the exit operation to take place.
 * 2. All threads that are not daemon threads have died, 
 *  either by returning from the call to the run method or by throwing an exception that propagates beyond the run method. 
 *  Marks this thread as either a daemon thread or a user thread.
 *  The Java Virtual Machine exits when the only threads running are all daemon threads.*/

/*每个线程都有一个优先级。“高优先级线程”会优先于“低优先级线程”执行。每个线程都可以被标记为一个守护进程或非守护进程。在一些运行的主线程中创建新的子线程时，子线程的优先级被设置为等于“创建它的主线程的优先级”，当且仅当“创建它的主线程是守护线程”时“子线程才会是守护线程”。

当Java虚拟机启动时，通常有一个单一的非守护线程（该线程通过是通过main()方法启动）。JVM会一直运行直到下面的任意一个条件发生，JVM就会终止运行：
(01) 调用了exit()方法，并且exit()有权限被正常执行。
(02) 所有的“非守护线程”都死了(即JVM中仅仅只有“守护线程”)。

每一个线程都被标记为“守护线程”或“用户线程”。当只有守护线程运行时，JVM会自动退出。*/

public class ThreadDaemon {
	public static void main(String[] args) {
		Thread s1=new Thread() {
			public void run() {
				int seconds=0,times=10;
				while(times-->0) {
					try {
						Thread.sleep(1000);
						
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					
					seconds++;
					System.out.println("您已经学习了"+seconds+"s");
				}
			
			}
		};
		
		Thread s2=new Thread() {
			public void run() {
				int seconds=0;
				while(true) {
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
					seconds++;
					System.out.println("您已休息了"+seconds+"s");
				}
			}
		};
		s1.setDaemon(false);
		s2.setDaemon(true);
		s1.start();
		s2.start();
		
		//设置线程优先级
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		/*s1.setPriority(5);
		s2.setPriority(5);*/
	}
	
}
/*总结：
 * 1.用户线程和守护线程的区别
 * 用户线程和守护线程都是线程，区别是Java虚拟机在所有用户线程dead后，程序就会结束。而不管是否还有守护线程还在运行，若守护线程还在运行，则会马上结束。很好理解，守护线程是用来辅助用户线程的，如公司的保安和员工，各司其职，当员工都离开后，保安自然下班了。
 * 2.用户线程和守护线程的适用场景
由两者的区别及dead时间点可知，守护线程不适合用于输入输出或计算等操作，因为用户线程执行完毕，程序就dead了，适用于辅助用户线程的场景，如JVM的垃圾回收，内存管理都是守护线程，还有就是在做数据库应用的时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监听连接个数、超时时间、状态等。
 * 3.创建守护线程
调用线程对象的方法setDaemon(true)，设置线程为守护线程。
1)thread.setDaemon(true)必须在thread.start()之前设置。
2)在Daemon线程中产生的新线程也是Daemon的。
3)不是所有的应用都可以分配给Daemon线程来进行服务，比如读写操作或者计算逻辑。因为Daemon Thread还没来得及进行操作，虚拟机可能已经退出了。
*/
