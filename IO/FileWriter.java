import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_FileWriter {
	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		try(FileWriter fw=new FileWriter(f1)){
			String data="我爱学Java!";
			char []cs=data.toCharArray();
			fw.write(cs);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}