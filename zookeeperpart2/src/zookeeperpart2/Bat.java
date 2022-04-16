package zookeeperpart2;

public class Bat extends Mammal {

	public Bat() {
		super(300);
		// TODO Auto-generated constructor stub
	}
	
	public void fly() {
		System.out.println("Wahhhh! The bat is flying.");
		this.energyLvl -= 10;
		System.out.println(displayEnergy());
	}

	public void eatHumans() {
		this.energyLvl += 25;
		System.out.println(displayEnergy());
	}
	
	public void attackTown() {
		System.out.println("Fsshhh...Boom! The town is under attack.");
		this.energyLvl -= 100;
		System.out.println(displayEnergy());
	}
}
