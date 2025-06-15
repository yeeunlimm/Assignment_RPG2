package Character;

public class Gorani extends Monster {
	public Gorani() {
		this.name = "고라니";
		this.level = 6;
		this.hp = 140;
		this.mp = 0;
		this.power = 14;
		this.defense = 6;
		this.expReward = 60;
		this.rewardMoney = 30;
	}

	@Override
	public int attack() {
		return level * 6 + power * 3;
	}
}
