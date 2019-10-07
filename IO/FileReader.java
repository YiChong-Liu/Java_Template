import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class File_FileReader {
	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		try (FileReader fr=new FileReader(f1)){
			char []all=new char[(int)f1.length()];
			fr.read(all);
			for(char b:all) {
				System.out.print(b+" ");
			}
			System.out.println();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}