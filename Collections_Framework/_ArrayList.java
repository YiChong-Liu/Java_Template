import java.util.ArrayList;
import java.util.Scanner;
import Collections_Framework.Hero;

//ArrayList的基本操作
public class _ArrayList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		ArrayList <Hero>heros=new ArrayList<Hero>();
		for(int i=0;i<5;i++) {
			heros.add(new Hero("Andrew Yang"));
			System.out.println(heros.size());
		}
		
		System.out.println(heros);
		
		Hero specialHero=new Hero("Donald Trump");
		heros.add(3,specialHero);
		System.out.println(heros);
		
		//contains判断标准:是否是同一个对象，而不是name是否相同
		System.out.println("Containing a new hero with the same name:"+heros.contains(new Hero("Andrew Yang")));
		System.out.println("containing the specialHero:"+heros.contains(specialHero));
		
		//get:获取对象 （越界会报错）
		System.out.print("the length of the Arraylist is "+heros.size()+" ,please input the location you want to get:");
		int num=sc.nextInt();
		System.out.println(heros.get(num));
		
		//indexof:获取对象所处的位置
		System.out.println("the location of specialHero is:"+heros.indexOf(specialHero));
		//remove:删除
		heros.remove(heros.indexOf(specialHero));
		System.out.println(heros);
		
		//set:替换
		heros.set(2, specialHero);
		System.out.println(heros);
		
		//toArray:把一个ArrayList对象转换为数组
		Hero hs[]=(Hero [])heros.toArray(new Hero[] {});
		for(Hero sub:hs) {
			System.out.print(sub+" ");
		}
		System.out.println();
		
		//addAll:把另一个容器所有对象都加进来
		ArrayList <Hero>Hero2=new ArrayList<Hero>();
		Hero2.add(new Hero("Elizabeth Warren"));
		System.out.println("Hero2:\t"+Hero2);
		heros.addAll(Hero2);
		System.out.println("heros:\t"+heros);
		
		//clear:清空
		Hero2.clear();
		
		sc.close();
	}
}