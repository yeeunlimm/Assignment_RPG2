package Character;

public abstract class Monster extends Character {
	public int power, defense;
	public int expReward;
	public int rewardMoney;

	public abstract int attack();

	public void attacked(int dmg, int skillType, String heroClass) {
		int realDmg = Math.max(0, dmg - defense);
		this.hp -= realDmg;
		System.out.println(name + "는 " + realDmg + "의 피해를 입었습니다.");
	}

	public void attacked(int dmg) {
		attacked(dmg, 0, "");
	}
}
