public class S3 {
	public static void main(String[] args) {
		String s1="Hello ";
		String s2="World!";
		//int c1=1000,c2=1000;
		long start1=System.nanoTime();
		String s3=s1.concat(s2);
		System.out.println(s3);
		long end1=System.nanoTime();
		System.out.println("程序1运行时间为:"+(end1-start1)+" ns");
		
		long start2=System.nanoTime();
		String s4=s1+s2;
		System.out.println(s4);
		long end2=System.nanoTime();
		System.out.println("程序2运行时间为:"+(end2-start2)+" ns");
		/*String s1="the light";
		String start="the";
		String end="ight";
		System.out.println(s1.startsWith(start));
		System.out.println(s1.endsWith(end));*/
		
		/*String s1="Hello World!";
		String s2=new String(s1);
		String s3=s1.toUpperCase();
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.contentEquals(s2));
		System.out.println(s1.contentEquals(s3));
		System.out.println(s1.equalsIgnoreCase(s3));*/
	}
}