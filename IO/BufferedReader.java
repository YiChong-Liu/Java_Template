import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class File_BufferedReader {
	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		try (
			FileReader fr=new FileReader(f1);
				//缓存流必须建立在一个存在的流的基础上
			BufferedReader br=new BufferedReader(fr);
			)
		{
			while(true) {
				String line=br.readLine();
				if(null==line)break;
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}