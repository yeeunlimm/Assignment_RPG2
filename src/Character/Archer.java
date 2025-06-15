package Character;

public class Archer extends Hero {

	public Archer() {
		this("이름없음");
	}

	public Archer(String name) {
		this.name = name;
		this.hp = 80;
		this.mp = 40;
		this.level = 1;
		this.power = 15;
		this.defense = 35;
	}

	public int attack(int type) {
		return switch (type) {
		case 1 -> level * 6 + power * 2;
		case 2 -> level * 12 + power * 3;
		case 3 -> level * 18 + power * 4;
		case 4 -> level * 14 + hp / 6;
		default -> power * 2;
		};
	}

	public void attacked(int dmg) {
		int realDmg = Math.max(0, dmg - defense);
		this.hp -= realDmg;
		System.out.println(name + "는 " + realDmg + "의 피해를 입었습니다.");
	}
}