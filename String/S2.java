import java.util.Scanner;

public class S2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一串字符串:");
		String s1=sc.nextLine();
		if(s1.contains("two")) {
			int mark=s1.lastIndexOf("two");
			char []s2=s1.toCharArray();
			//将two首字母大写
			s2[mark]=Character.toUpperCase(s2[mark]);
			String s3=new String(s2);
			System.out.println(s3);
		}
		sc.close();
	}
}