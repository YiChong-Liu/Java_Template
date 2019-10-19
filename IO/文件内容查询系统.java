import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class 文件内容查询系统 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("欢迎来到文件内容查询系统！");
		System.out.println("Please input the path of your target directory:");
		String checkPath=sc.nextLine();
		File targetFile=new File(checkPath);
		if(!targetFile.exists()) {
			System.out.println("Not exists!");
		}
		else {
			System.out.println("We've found the directory!");
			System.out.println("Please input the content you want to find among files in this directory:");
			String searchContent=sc.nextLine();
			search(targetFile,searchContent);
		}
		sc.close();
	}
	
	public static void search(File targetFile,String searchContent) {
		File all[]=targetFile.listFiles();
		if(all.length==0) {
			System.out.println("The directory is empty!");
			return;
		}
		for(File sub:all) {
			try (
					FileReader fr=new FileReader(sub);
					BufferedReader br=new BufferedReader(fr);
					)
			{
				boolean temp=false;
				String line=br.readLine();
				while(line!=null) {
					if(line.contains(searchContent)) {
						temp=true;
					}
					line=br.readLine();
				}
				
				if(temp) {
					System.out.print("We've found the subcontent!");
					String filePath=sub.getAbsolutePath();
					System.out.println("It's:"+filePath);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}