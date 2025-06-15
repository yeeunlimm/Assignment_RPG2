package Character;

public class WildCat extends Monster {
	public WildCat() {
		this.name = "살쾡이";
		this.level = 3;
		this.hp = 100;
		this.mp = 0;
		this.power = 10;
		this.defense = 4;
		this.expReward = 40;
		this.rewardMoney = 15;
	}

	@Override
	public int attack() {
		return level * 4 + power * 2;
	}
}
