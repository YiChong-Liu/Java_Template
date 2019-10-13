import java.io.File;
import java.util.Scanner;

public class File2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("������Ҫ��ѯ���ļ�·��:");
		String filepath=sc.nextLine();
		File f1=new File(filepath);
		System.out.println(f1.exists());
		File []folder=f1.listFiles();
		if(folder.length==0)System.out.println("��Ŀ¼��Ϊ�գ�");
		
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
		System.out.printf("��%s�ļ�Ŀ¼��,�����ļ���  \t%s\t,��СΪ%d�ֽ�\n", f1,MaxFile,max);
		System.out.printf("��%s�ļ�Ŀ¼��,��С���ļ���  \t%s\t,��СΪ%d�ֽ�\n", f1,MinFile,min);
		sc.close();
	}

}