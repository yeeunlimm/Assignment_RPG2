package Map;

import java.util.Scanner;

import Character.Archer;
import Character.Hero;
import Character.Warrior;
import Character.Wizard;

public class WeaponStore {
	Scanner in = new Scanner(System.in);

	public void enter(Hero hero) {
		while (true) {
			System.out.println("무기 상점에 입장하였습니다.");
			System.out.println("직업에 따라 구매할 수 있는 무기가 다릅니다.");

			if (hero instanceof Warrior) {
				System.out.println("1. 검 (+10 공격력, 50원)\n2. 도끼 (+20 공격력, 100원)\n0. 나가기");
			} else if (hero instanceof Wizard) {
				System.out.println("1. 지팡이 (+10 공격력, 50원)\n2. 마법지팡이 (+20 공격력, 100원)\n0. 나가기");
			} else if (hero instanceof Archer) {
				System.out.println("1. 단궁 (+10 공격력, 50원)\n2. 장궁 (+20 공격력, 100원)\n0. 나가기");
			}

			System.out.print("무기를 선택하세요: ");
			int num = in.nextInt();

			if (num == 0) {
				System.out.println("상점에서 나갑니다.\n");
				break;
			}

			if (num == 1 && hero.money >= 50) {
				hero.power += 10;
				hero.money -= 50;
				System.out.println("+10 공격력 무기를 구매했습니다. 남은 돈: " + hero.money + "원\n");
			} else if (num == 2 && hero.money >= 100) {
				hero.power += 20;
				hero.money -= 100;
				System.out.println("+20 공격력 무기를 구매했습니다. 남은 돈: " + hero.money + "원\n");
			} else {
				System.out.println("돈이 부족하거나 잘못된 입력입니다.\n");
			}
		}
	}
}
