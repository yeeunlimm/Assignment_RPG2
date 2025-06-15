package Character;

import Map.Mission;

public class Hero extends Character {
	public int power, defense, money = 0, experience = 0;
	private Mission mission;

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Mission getMission() {
		return mission;
	}

	public void reportKill(String monsterName) {
		if (mission != null && !mission.isCompleted()) {
			if (mission.isCompleted()) {
				this.level++;
				System.out.println("경험치 누적으로 인해" + name + "의 레벨이 " + level + "이/가 되었습니다!");
			}
		}
	}

	public void gainExp(int exp) {
		this.experience += exp;
		while (this.experience >= 100) {
			this.experience -= 100;
			levelUp();
		}
	}

	private void levelUp() {
		level++;
		power += 5;
		defense += 3;
		hp += 20;
		System.out.println("★ 레벨업! Now Lv." + level);
	}

	public int attack(int type) {
		return 0;
	};

	public void attacked(int dmg) {

	};
}