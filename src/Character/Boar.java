package Character;

public class Boar extends Monster {
	public Boar() {
		this.name = "멧돼지";
		this.level = 7;
		this.hp = 160;
		this.mp = 0;
		this.power = 16;
		this.defense = 7;
		this.expReward = 80;
		this.rewardMoney = 50;
	}

	@Override
	public int attack() {
		return level * 7 + power * 3;
	}
}