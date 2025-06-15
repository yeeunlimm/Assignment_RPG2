package Character;

public class Warrior extends Hero {
	public Warrior() {
		this("이름없음");
	}

	public Warrior(String name) {
		this.name = name;
		this.hp = 80;
		this.mp = 0;
		this.level = 1;
		this.power = 15;
		this.defense = 25;
	}

	public int attack(int type) {
		return switch (type) {
		case 1 -> level * 5 + power * 2;
		case 2 -> level * 10 + power * 3;
		case 3 -> level * 15 + power * 4;
		case 4 -> level * 12 + hp / 8;
		default -> power * 2;
		};
	}

	public void attacked(int dmg) {
		int realDmg = Math.max(0, dmg - defense);
		this.hp -= realDmg;
		System.out.println(name + "는 " + realDmg + "의 피해를 입었습니다.");
	}
}