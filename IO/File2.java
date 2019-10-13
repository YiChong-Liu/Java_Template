import java.io.File;
import java.util.Scanner;

public class File2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入要查询的文件路径:");
		String filepath=sc.nextLine();
		File f1=new File(filepath);
		System.out.println(f1.exists());
		File []folder=f1.listFiles();
		if(folder.length==0)System.out.println("该目录下为空！");
		
		long max=0;
		long min=Integer.MAX_VALUE;
		File MaxFile=null,MinFile=null;
		for(File f:folder) {
			if(f.isDirectory()) {
				continue;
			}
			
			if(f.length()>max) {
				max=f.length();
				MaxFile=f;
			}
			if(f.length()<min&&f.length()>0) {
				min=f.length();
				MinFile=f;
			}
		}
		System.out.printf("在%s文件目录下,最大的文件是  \t%s\t,大小为%d字节\n", f1,MaxFile,max);
		System.out.printf("在%s文件目录下,最小的文件是  \t%s\t,大小为%d字节\n", f1,MinFile,min);
		sc.close();
	}

}