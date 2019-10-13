import java.io.File;
import java.util.Date;

public class File1 {
	public static void main(String[] args) {
		File f1=new File("F:/HelloIO.txt");
		System.out.println("当前文件是:"+f1);
		System.out.println("该文件是否存在:"+f1.exists());
		System.out.println("判断是否是文件夹:"+f1.isDirectory());
		System.out.println("判断是否是文件:"+f1.isFile());
		System.out.println("获取文件的长度:"+f1.length());
		
		//文件最后修改时间
		long time=f1.lastModified();
		Date d=new Date(time);
		System.out.println("获取文件的最后修改时间："+d);
		//设置文件修改时间为1970.1.1  08:00:00
		f1.setLastModified(1200);
		
		File f2=new File("F:/HelloIO2.txt");
		f1.renameTo(f2);
		System.out.println("改名完成");
	}
}