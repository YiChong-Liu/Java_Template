package Collections_Framework;

/*Collections:容器的工具类*/
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Collection {
	public static void main(String[] args) {
		List <Integer>numbers=new ArrayList<>();
		for(int i=0;i<10;i++) {
			numbers.add(i);
		}
		System.out.println(numbers);
		
		//reverse:使list中的数据发生反转
		Collections.reverse(numbers);
		System.out.println(numbers);
		
		//shuffle:混淆list中数据的顺序
		Collections.shuffle(numbers);
		System.out.println(numbers);
		
		//sort:对list中数据进行排序
		Collections.sort(numbers);
		System.out.println(numbers);
		
		//swap:交换2个数据的位置
		Collections.swap(numbers, 1, 8);
		System.out.println(numbers);
		
		//rotate:把List中的数据向右滚动指定单位长度
		Collections.rotate(numbers, 1);
		System.out.println(numbers);
		
		//synchronizedList:把非线程安全的List转换为线程安全的List
		List<Integer>synchronizedNumbers=(List<Integer>)Collections.synchronizedList(numbers);
	}
}
