package Collections_Framework;

import java.util.ArrayList;
import java.util.List;

public class binaryTree {
	//二叉树特点:每个节点都可以有左子节点和右子节点,每个节点都有一个值
	//左子节点
	public binaryTree leftNode;
	//右子节点
	public binaryTree rightNode;
	//值
	public Object value;
	/*假设通过二叉树对如下10个随机数进行排序
	67,7,30,73,10,0,78,81,10,74
	排序的第一个步骤是把数据插入到该二叉树中
	插入基本逻辑是，小、相同的放左边，大的放右边
	1. 67 放在根节点
	2. 7 比 67小，放在67的左节点
	3. 30 比67 小，找到67的左节点7，30比7大，就放在7的右节点
	4. 73 比67大， 放在67的右节点
	5. 10 比 67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，放在30的左节点。
	...
	...
	9. 10比67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，找到30的左节点10，10和10一样大，放在左边
	*/
	
	//插入数据
	public void add(Object v) {
		if(value==null)value=v;
		else {
			//左小右大
			if((Integer)v-(Integer)value<=0) {
				if(leftNode==null)leftNode=new binaryTree();
				leftNode.add(v);
			}
			else {
				if(rightNode==null)rightNode=new binaryTree();
				rightNode.add(v);
			}
		}
	}
	
	//中序遍历二叉树
	public List<Object> InOrderTraverse(){
		List<Object>nodes=new ArrayList<Object>();
		if(leftNode!=null) {
			nodes.addAll(leftNode.InOrderTraverse());
		}
		nodes.add(value);
		if(null!=rightNode)nodes.addAll(rightNode.InOrderTraverse());
		return nodes;
	}
	
	public List<Object> PostOrderTraverse(){
		List <Object>nodes=new ArrayList<Object>();
		if(leftNode!=null) {
			nodes.addAll(leftNode.PostOrderTraverse());
		}
		if(rightNode!=null)nodes.addAll(rightNode.PostOrderTraverse());
		nodes.add(value);
		return nodes;
	}
	
	public List<Object> PreOrderTraverse(){
		List <Object>nodes=new ArrayList<Object>();
		nodes.add(value);
		if(leftNode!=null) {
			nodes.addAll(leftNode.PostOrderTraverse());
		}
		if(rightNode!=null) {
			nodes.addAll(rightNode.PostOrderTraverse());
		}
		return nodes;
	}
	
	public static void main(String[] args) {
		int numbers[]=new int[] {67,7,30,73,10,0,78,81,10,74};
		binaryTree bt=new binaryTree();
		for(int sub:numbers) {
			bt.add(sub);
		}
		System.out.print("中序遍历二叉树:  \t");
		System.out.println(bt.InOrderTraverse());
		System.out.print("后序遍历二叉树:  \t");
		System.out.println(bt.PostOrderTraverse());
		System.out.print("前序遍历二叉树:  \t");
		System.out.println(bt.PreOrderTraverse());
	}
}
