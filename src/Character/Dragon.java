package Character;

public class Dragon extends Monster {
	public Dragon() {
		this.name = "드래곤";
		this.level = 9;
		this.hp = 200;
		this.mp = 50;
		this.power = 20;
		this.defense = 10;
		this.expReward = 150;
		this.rewardMoney = 100;
	}

	@Override
	public int attack() {
		return level * 10 + power * 4;
	}
}