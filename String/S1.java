import java.util.Scanner;

public class S1 {
	
	
	public static void PhraseUpperCase(String sentence) {
		String phrase[]=sentence.split(" ");
		for(int i=0;i<phrase.length;i++) {
			String p1=phrase[i].substring(0,1).toUpperCase()+phrase[i].substring(1);
			System.out.print(p1+" ");
		}
	}

	public static void main(String[] args) {
		final int maxnum=100;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入需要统计的字符串:");
		String sentence=sc.nextLine();
		System.out.println("请输入需要统计的字符:");
		String keyphrase=sc.nextLine();
		char key=keyphrase.charAt(0);
		
		int allcases=0,startcases=0;
		
		char str[]=new char[maxnum];
		str=sentence.toCharArray();
		for(int i=0;i<str.length;i++) {
			if(str[i]==key)allcases++;
		}
		
		String []str2=sentence.split(" ");
		for(String sub:str2) {
			char []str3=sub.toCharArray();
			if(str3[0]==key)startcases++;
		}
		System.out.println("字符"+key+"在字符串中出现了一共"+allcases+"次");
		System.out.println("字符"+key+"在字符串中每个单词的首字母出现了一共"+startcases+"次");
		sc.close();
		/*System.out.println("请输入需要转换为大写的字符串:");
		String sentence=sc.nextLine();
		System.out.print("转换后输出:");
		PhraseUpperCase(sentence);*/
		/*左闭右开
		String subsentence1=sentence.substring(3,7);
		System.out.println(subsentence1);*/
		
		/*String subsentences[]=sentence.split(",");
		for(String sub:subsentences) {
			System.out.println(sub);
		}*/
		
		//System.out.println(sentence);
		//System.out.println(sentence.trim());
		
		/*System.out.println(sentence.indexOf('吴'));
		System.out.println(sentence.indexOf("真的"));
		System.out.println(sentence.indexOf(','));
		System.out.println(sentence.lastIndexOf(','));
		System.out.println(sentence.contains("姐"));*/
		
		/*String CorrectAnswer=sentence.replaceAll("学姐", "学妹");
		System.out.println(CorrectAnswer);
		CorrectAnswer=CorrectAnswer.replaceAll("哇","");*/	
	}

}