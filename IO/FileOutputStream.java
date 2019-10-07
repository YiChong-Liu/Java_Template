import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_OutputStream {
	
	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		FileOutputStream FOS=null;
		try {
			FOS=new FileOutputStream(f1);
			byte data[]= {68,69,70};
			FOS.write(data);
			//在try中关闭流
			//FOS.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				FOS.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
