package lambda;

public class Hero {
	public String name;
	public double hp;
	public int damage;
	
	public Hero(String name) {
		this.name=name;
	}

	public Hero(String name,double hp,int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	public String toString() {
		return name;
	}
	
	//引用容器中的对象
	public boolean matched() {
		return this.hp>99&&this.damage<49;
	}
	public static void main(String[] args) {
		
	}


}