import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class 文件复制系统 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("欢迎来到文件复制系统！");
		System.out.println("请输入目标文件的路径:");
		String filePath=sc.nextLine();
		File targetFile=new File(filePath);
		if(targetFile.isDirectory()) {
			System.out.println("target file is actually a directory!");
			System.out.println("请输入新文件夹路径:");
			String newPath=sc.nextLine();
			File newDirectory=new File(newPath);
			//创建新的文件夹
			if(!newDirectory.exists()) {
				newDirectory.mkdir();
			}
			
			File []all=targetFile.listFiles();
			for(File sub:all) {
				//获取文件名字
				String tempPath=newPath;
				String name=sub.getName();
				tempPath=tempPath+"/"+name;
				copyFile(sub,tempPath);
			}
		}
		else if(targetFile.exists()) {
			System.out.println("target file is a file,not directory!");
			System.out.println("请输入新文件路径:");
			String newPath=sc.nextLine();
			copyFile(targetFile,newPath);
		}
		else {
			System.out.println("target file not exists!");
		}
		sc.close();
	}
	
	public static void copyFile(File targetFile,String newPath) {
		File newFile=new File(newPath);
		try(FileReader fr=new FileReader(targetFile);
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter(newFile);
			PrintWriter pw=new PrintWriter(fw);
				)
		{
			String line=br.readLine();
			while(line!=null) {
				pw.println(line);
				line=br.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
