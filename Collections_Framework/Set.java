package Collections_Framework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Set {
	
	public static void main(String[] args) {
		//set的特点:元素不重复
		HashSet <Integer>numberSet1=new HashSet<Integer>();
		/*HashSet中的数据不是按照插入顺序存放,而是依据hashcode原理。当为单个数字或
		 * 字符时，与TreeSet一样，依据ASCII码排序。add字符串时就不一样了*/
		numberSet1.add(11);
		numberSet1.add(1);
		numberSet1.add(111);
		numberSet1.add(111);
		System.out.println(numberSet1);
		
		LinkedHashSet<Integer>numberSet2=new LinkedHashSet<Integer>();
		//LinkedHashSet中的数据是按照插入顺序存放
		numberSet2.add(11);
		numberSet2.add(1);
		numberSet2.add(111);
		numberSet2.add(111);
		System.out.println(numberSet2);
		
		TreeSet <Integer>numberSet3=new TreeSet<Integer>();
		//TreeSet中的数据进行了排序
		numberSet3.add(11);
		numberSet3.add(1);
		numberSet3.add(111);
		numberSet3.add(111);
		System.out.println(numberSet3);
	}
}
