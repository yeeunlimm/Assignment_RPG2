package Character;

public class Raccoon extends Monster {
	public Raccoon() {
		this.name = "너구리";
		this.level = 1;
		this.hp = 50;
		this.mp = 0;
		this.power = 5;
		this.defense = 2;
		this.expReward = 30;
		this.rewardMoney = 10;

	}

	@Override
	public int attack() {
		return level * 3 + power * 2;
	}
}