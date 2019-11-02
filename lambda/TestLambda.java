package lambda;

import java.util.List;
import java.util.ArrayList;
import lambda.Hero;
//import java.util.Random;

public class TestLambda {
	public static void main(String[] args) {
		List <Hero>heros=new ArrayList<>();
		for(int i=0;i<10;i++) {
			heros.add(new Hero("hero "+i,i+95,i+30));
		}
		System.out.println("初始化后的集合");
		System.out.println(heros);
		System.out.println("使用lambda的方式，筛选出英雄");
		/*HeroChecker为接口，本来可以在main函数里面或者外面单独写一个对应的方法(匿名类)，去实现功能，
		 * 这里把其去掉，直接写在参数HeroChecker中*/
		filter(heros,h->h.hp>100&&h.damage<50);
		
		//静态方法：2种写法
		filter(heros,h->TestLambda.testHero(h));
		filter(heros,TestLambda::testHero);
		
		//对象方法
		TestLambda tl=new TestLambda();
		filter(heros,tl::testHero2);
		
		//引用容器中的对象
		filter(heros,Hero::matched);
		
		
		/*与匿名类相比较,lambda其实就是匿名方法,这是一种把方法作为参数进行传递的编程思想
		 * 弊端:可读性差，不便于调试，在JDK8后才支持*/
		
		
		
		//聚合操作方式遍历数据
		System.out.println("通过聚合操作方式遍历数据:");
		heros
			.stream()
			.filter(h->h.hp>99&&h.damage<49)
			.forEach(h->System.out.println(h.name));
		//Stream概念见_Stream.java
	}
	
	//引用静态方法
	public static boolean testHero(Hero h) {
		return (h.hp>99&&h.damage<49);
	}
	
	//引用对象方法
	public  boolean testHero2(Hero h) {
		return (h.hp>99&&h.damage<49);
	}
	
	private static void filter(List <Hero>heros,HeroChecker checker) {
		for(Hero sub:heros) {
			if(checker.test(sub)) {
				System.out.print(sub+" ");
			}
		}
		System.out.println();
	}
}
