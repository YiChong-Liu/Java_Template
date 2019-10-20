package Collections_Framework;

public class Hero {
	public String name;
	private double hp;
	public int damage;
	
	public Hero(String name) {
		this.name=name;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	
	public String toString() {
		return name;
	}
	public static void main(String[] args) {
		
	}


}