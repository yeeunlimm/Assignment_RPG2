package Character;

public class Dog extends Monster {
	public Dog() {
		this.name = "들개";
		this.level = 4;
		this.hp = 120;
		this.mp = 0;
		this.power = 12;
		this.defense = 5;
		this.expReward = 50;
		this.rewardMoney = 20;
	}

	@Override
	public int attack() {
		return level * 5 + power * 2;
	}
}