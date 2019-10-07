import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class File_InputStream {

	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		FileInputStream FIS=null;
		try {
			FIS=new FileInputStream(f1);
			byte[]all=new byte[(int)f1.length()];
			FIS.read(all);
			for(byte b:all) {
				System.out.print(b+" ");
			}
			//在try中关闭流。弊端:若文件不存在或抛出异常，则不会关闭流，存在巨大的资源占用隐患
			//FIS.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//在finally中关闭流
			if(FIS!=null) {
				try {
					FIS.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}