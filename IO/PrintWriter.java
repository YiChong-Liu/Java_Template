import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class File_PrintWriter {
	public static void main(String[] args) {
		File f1=new File("F:/Java_IO/Class1/HelloIO2.txt");
		
		try (
			FileWriter fw=new FileWriter(f1);
			PrintWriter pw=new PrintWriter(fw);
			)
		{
			pw.println("I'm learning Java now!");
			pw.flush();
			pw.println("I love Java and I'm making great progress.");
			pw.flush();
			pw.println("Don't worry,everything is just fine!");
			pw.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}