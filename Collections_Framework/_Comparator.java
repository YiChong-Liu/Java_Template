package Collections_Framework;

import Collections_Framework.Hero;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

//比较器(记得将hero的hp设为public)
public class _Comparator {
	public static void main(String[] args) {
		Random rd=new Random();
		List <Hero>heros=new ArrayList<Hero>();
		
		double []data= {2.3,2.1,3.2,2.4,4.6,19.1,23.8,20.2,78,53};
		for(int i=0;i<10;i++) {
			heros.add(new Hero("hero "+i,data[i]+rd.nextDouble(),rd.nextInt(10)));
		}
		System.out.println(heros);
		//不能直接调用sort，因为Hero有各种属性
		//Collections.sort(heros);
		
		//引入Comparator,指定比较的算法
		Comparator<Hero>cmp=new Comparator<Hero>() {
			public int compare(Hero h1,Hero h2) {
				if(h1.hp>=h2.hp)return 1;
				else
					return -1;
			}
		};
		
		Collections.sort(heros,cmp);
		System.out.println(heros);
	}
	
}
