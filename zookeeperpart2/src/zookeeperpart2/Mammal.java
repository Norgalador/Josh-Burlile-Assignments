package zookeeperpart2;

public class Mammal {

protected int  energyLvl = 100;
	
	public Mammal(int energyLvl) {
		this.energyLvl = energyLvl;
	}
	
	public int displayEnergy() {
		System.out.println("Current energy level is: ");
		return this.energyLvl;
	}
	
}
