import java.util.HashMap; 
public class _hashMap {
	public static void main(String[] args) {
		HashMap<String,String>candidates=new HashMap<>();
		candidates.put("1", "Andrew Yang");
		candidates.put("2", "Elizabeth Warren");
		candidates.put("3","Joe Biden");
		candidates.put("3","Bernie Sanders");
		System.out.println(candidates.get("1"));
		//"Joe Biden"被覆盖
		System.out.println(candidates.get("3"));
		candidates.put("4","Andrew Yang");
		System.out.println(candidates);
		candidates.clear();
	}
}