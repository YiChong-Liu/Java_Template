package multiThreading;

//多线程同步问题
/*假设hkq有10000滴血，并且在基地里，同时又被对方多个英雄攻击
 * 就是有多个线程在减少盖伦的hp
 * 同时又有多个线程在恢复盖伦的hp
 * 假设线程的数量是一样的，并且每次改变的值都是1，那么所有线程结束后，hkq应该还是10000滴血。
 * 但是。。。*/
public class SynchronizedQuestion {
	
	public static void main(String[] args) {
		final Hero hkq=new Hero();
		hkq.name="胡柯青";
		hkq.hp=10000;
		
		System.out.printf("胡柯青的初始血量是%g\n",hkq.hp);
		int times=10000;
		Thread []addThreads=new Thread[times];
		Thread []reduceThreads=new Thread[times];
		
		for(int i=0;i<times;i++) {
			Thread t1=new Thread() {
				public void run() {
					hkq.recover();
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t1.start();
			addThreads[i]=t1;
		}
		
		for(int i=0;i<times;i++) {
			Thread t2=new Thread() {
				public void run() {
					hkq.hurt();
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t2.start();
			reduceThreads[i]=t2;
		}
		for(Thread sub:addThreads) {
			try {
				sub.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		//等待所有减少线程结束
		for(Thread sub:reduceThreads) {
			try {
				sub.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("%d个增加线程和%d个减少线程结束后%nhkq的血量变成了 %.0f%n", times,times,hkq.hp);
	}
}
/*
 * 产生原因1. 假设增加线程先进入，得到的hp是10000
2. 进行增加运算
3. 正在做增加运算的时候，还没有来得及修改hp的值，减少线程来了
4. 减少线程得到的hp的值也是10000
5. 减少线程进行减少运算
6. 增加线程运算结束，得到值10001，并把这个值赋予hp
7. 减少线程也运算结束，得到值9999，并把这个值赋予hp
hp最后的值就是9999
虽然经历了两个线程各自增减了一次，本来期望还是原值10000，但是却得到了一个9999
这个时候的值9999是一个错误的值，在业务上又叫做脏数据*/
