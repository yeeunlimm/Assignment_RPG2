package Character;

public class Wizard extends Hero {

	public Wizard() {
		this("이름없음");
	}

	public Wizard(String name) {
		this.name = name;
		this.hp = 60;
		this.mp = 60;
		this.level = 1;
		this.power = 18;
		this.defense = 10;
	}

	public int attack(int type) {
		return switch (type) {
		case 1 -> level * 5 + power * 3;
		case 2 -> level * 10 + power * 4;
		case 3 -> level * 20 + power * 5;
		case 4 -> level * 18 + mp / 5;
		default -> power * 3;
		};
	}

	public void attacked(int dmg) {
		int realDmg = Math.max(0, dmg - defense);
		this.hp -= realDmg;
		System.out.println(name + "는 " + realDmg + "의 피해를 입었습니다.");
	}
}