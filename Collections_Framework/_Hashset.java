package Collections_Framework;

import java.util.HashSet;
import java.util.Iterator;
/*HashMap储存键值对，使用put方法将元素放入HashMap中，键唯一（较快)
 * 使用键对象计算HashCode的值
 * 而HashSet储存的是对象,使用add方法->HashSet,不包含重复元素
 * 使用成员对象计算HashCode的值*/

public class _Hashset {
	public static void main(String[] args) {
		HashSet <String>names=new HashSet<String>();
		names.add("Sam");
		System.out.println(names);
		
		//第二次插入同样的数据，插不进去
		names.add("Sam");
		System.out.println(names);
		
		//存放顺序按hashcode原理,不是按原顺序
		HashSet <Integer>numbers=new HashSet<Integer>();
		numbers.add(9);
		numbers.add(79);
		numbers.add(61);
		numbers.add(23);
		System.out.println(numbers);
		//迭代器遍历
		for(Iterator <Integer>it=numbers.iterator();it.hasNext();) {
			Integer i=(Integer)it.next();
			System.out.println(i);
		}
		
		
	}
}
